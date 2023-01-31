from django.shortcuts import render, redirect
from django.contrib.auth import login, logout, authenticate
from django.contrib.auth.models import User
from django.contrib.auth.forms import AuthenticationForm
from django.db import IntegrityError
from django.http.response import HttpResponse
from django.urls import reverse
from django.contrib.auth.decorators import login_required

from pathlib import Path
import os
import environ
import threading
import pyrebase

from .forms import UserCreationForm, UserMediaDetailsForm
from .models import UserMediaDetails
from . import constants

# Create your views here.


def signup(req):
    if req.method == 'GET':
        return render(req, 'users/signup.html', context={'form': UserCreationForm()})
    else:
        if req.POST['password1'] == req.POST['password2']:
            try:
                user = User.objects.create_user(
                    username=req.POST['username'],
                    password=req.POST['password1'], 
                    email=req.POST['email'],
                    first_name=req.POST['first_name'],
                    last_name=req.POST['last_name'])
                user.save()
                login(req, user)
                return redirect('users:view_profile')
            except IntegrityError:
                return render(req, 'users/signup.html', 
                              {'form': UserCreationForm(), 'error': constants.USERNAME_TAKEN})
        else:
            return render(req, 'users/signup.html', 
                          {'form': UserCreationForm(), 'error': constants.PASSWORDS_DONT_MATCH})


def signin(req):
    if req.method == 'GET':
        return render(req, 'users/signin.html', {'form': AuthenticationForm()})
    else:
        user = authenticate(req, username=req.POST['username'], password=req.POST['password'])
        if user is None:
            return render(req, 'users/signin.html', 
                          {'form': AuthenticationForm(), 'error': constants.LOGIN_FAIL})
        else:
            login(req, user)
            return redirect('users:view_profile')

@login_required
def logoutuser(req):
    if req.method == 'POST':
        logout(req)
        return redirect('landing')

@login_required
def view_profile(req):
    if req.method == 'GET':
        target_user_details = UserMediaDetails.objects.filter(user_id=req.user.id)

        img_url = None
        
        if len(target_user_details) > 0:
            img_url = target_user_details[0].uploaded_image.url
            return render(req, 'users/profile.html', {'form': UserMediaDetailsForm(instance=target_user_details[0]), 'img_url': img_url})

        return render(req, 'users/profile.html', {'form': UserMediaDetailsForm(), 'img_url': img_url})
    else:
        form = UserMediaDetailsForm(req.POST, req.FILES)
        if form.is_valid():
            user_details = form.save(commit=False)
            user_details.user_id = req.user

            user_details.save()

            firebase_image_storage(req.user.username, user_details.uploaded_image.url, req.user.id)

            return redirect(reverse('users:view_profile'))
        else:
            return render(req, 'users/profile.html', 
                          {'form': UserMediaDetailsForm(), 'error' : 'Form data invalid'})


def firebase_image_storage(user_name, file_path, pk):
    thread_task = threading.Thread(target=firebase_image_storage_helper, args=[file_path, user_name, pk])
    thread_task.setDaemon(True)
    thread_task.start()


def firebase_image_storage_helper(file_path, user_name, pk):
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

    rvalue = storage.child(f"profile_images/{user_name}.jpg").put(full_path)

    download_link = f"{env('DOWNLOAD_BASE_URL')}{user_name}.jpg?alt=media&token={rvalue['downloadTokens']}"

    print('the download link is', download_link)

    user_details = UserMediaDetails.objects.filter(user_id=pk)[0]
    user_details.image_url = download_link
    user_details.save()