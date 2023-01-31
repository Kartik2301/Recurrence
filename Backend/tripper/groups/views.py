from django.shortcuts import render, redirect, get_object_or_404
from .forms import GroupForm, UploadGroupDataForm
from .models import GroupModel, GroupAdditionalDetailsModel
from django.urls import reverse
from django.contrib.auth.decorators import login_required
from django.contrib.auth.models import User
from users.models import UserMediaDetails
from django.http.response import HttpResponse
from events.models import MeetupEvents

import os
import environ
import threading
import pyrebase

# Create your views here.
def list_all_groups(req):
    all_groups = GroupModel.objects.all()
    return render(req, 'groups/groups.html', {'groups': all_groups})

@login_required
def create_group(req):
    if req.method == 'GET':
        return render(req, 'groups/add_group.html', {'form': GroupForm})
    else:
        form = GroupForm(req.POST)
        if form.is_valid():
            new_group = form.save(commit=False)
            new_group.owner = req.user
            new_group.save()

            return redirect(reverse('groups:edit_group_detail', kwargs={'pk': new_group.id}))
        else:
            return render(req, 'groups/add_group.html', {'form': GroupForm, 'error' : 'Invalid Data'}) 
         
def view_group_details(req, pk):
    group = get_object_or_404(GroupModel, pk=pk)
    is_owner = False
    if group.owner == req.user:
        is_owner = True

    target_group = get_object_or_404(GroupModel, pk=pk)
    
    group_details = GroupAdditionalDetailsModel.objects.filter(group_id=target_group)
    detail_list = []
    group_detail = None
        
    if len(group_details) > 0:
        group_detail = group_details[0]

    events = MeetupEvents.objects.filter(group_id=target_group)

    for member in group_detail.members.all():
        member_info_item = {'username':  member.username}
        member_info_item['full_name'] = f"{member.first_name}  {member.last_name}"

        get_user = get_object_or_404(User, username=member.username)

        memeber_additional_details = get_object_or_404(UserMediaDetails, user_id=get_user)

        if memeber_additional_details != None:
            member_info_item['image_url'] = memeber_additional_details.image_url
        else:
            member_info_item['image_url'] = "https://www.indiewire.com/wp-content/uploads/2020/06/Dark-Season-3-Netflix-Jonas-Martha.jpg"

        detail_list.append(member_info_item)
    
    return render(req, 'groups/view_group_detail.html', 
                {'group': group, 'is_owner' : is_owner, 'group_details': group_detail,
                'members': detail_list, 'events': events})

@login_required
def edit_group_detail(req, pk):
    if req.method == 'GET':
        return render(req, 'groups/edit_group_detail.html', {'form': UploadGroupDataForm()})
    else:
        form = UploadGroupDataForm(req.POST, req.FILES)
        if form.is_valid():

            new_group_info = form.save()

            group_details = GroupAdditionalDetailsModel.objects.filter(group_id=pk)
            target_group = get_object_or_404(GroupModel, pk=pk)

            if len(group_details) == 0:
                GroupAdditionalDetailsModel.objects.create(group_id=target_group)

            group_details = GroupAdditionalDetailsModel.objects.filter(group_id=target_group)[0]
            group_details.image_url = new_group_info.uploaded_image.url

            group_details.save()

            firebase_image_storage(target_group.name, new_group_info.uploaded_image.url, pk)

            return redirect(reverse('groups:edit_group_detail', kwargs={'pk': pk}))
        else:
            return render(req, 'groups/edit_group_detail.html', {'form': UploadGroupDataForm()})

def add_user_to_group(req):
    name1 = req.POST['name_user']
    pk = req.POST['group_id']

    print('Request reached inside', name1, pk)

    user_to_be_added = get_object_or_404(User, username=name1)

    group_details = GroupAdditionalDetailsModel.objects.filter(group_id=pk)
    target_group = get_object_or_404(GroupModel, pk=pk)

    if len(group_details) == 0:
        GroupAdditionalDetailsModel.objects.create(group_id=target_group)

    group_details = GroupAdditionalDetailsModel.objects.filter(group_id=target_group)[0]
    group_details.members.add(user_to_be_added)

    group_details.save()

    return HttpResponse('Request serviced')

def firebase_image_storage(grp_name, file_path, pk):
    thread_task = threading.Thread(target=firebase_image_storage_helper, args=[file_path, grp_name, pk])
    thread_task.setDaemon(True)
    thread_task.start()

def firebase_image_storage_helper(file_path, grp_name, pk):
    env = environ.Env()
    environ.Env.read_env()

    firebase = pyrebase.initialize_app({
        "apiKey": env('API_KEY'),
        "authDomain": env('AUTH_DOMAIN'),
        "projectId": env('PROJECT_ID'),
        "storageBucket": env('STORAGE_BUCKET'),
        "messagingSenderId": env('MESSAGING_SENDER_ID'),
        "appId": env('APP_ID'),
        "measurementId": env('MEASUREMENT_ID'),
        "databaseURL": ""
    })
    storage = firebase.storage()
    BASE_DIR = str(os.path.dirname(os.path.realpath(__file__)))
    BASE_DIR =  BASE_DIR[:BASE_DIR.rfind('\\')]
    file_path = str(file_path).replace('/', '\\')
    full_path = BASE_DIR + file_path

    rvalue = storage.child(f"group_thumbs/{grp_name}.jpg").put(full_path)
    download_link = f"{env('DOWNLOAD_BASE_URL')}{grp_name}.jpg?alt=media&token={rvalue['downloadTokens']}"

    group_details = GroupAdditionalDetailsModel.objects.filter(group_id=pk)[0]
    group_details.image_url = download_link
    group_details.save()