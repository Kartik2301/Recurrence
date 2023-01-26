from django.shortcuts import render, redirect, get_object_or_404
from .forms import GroupForm, GroupAdditionalDetailsForm
from .models import GroupModel, GroupAdditionalDetailsModel
from django.urls import reverse

# Create your views here.
def list_all_groups(req):
    all_groups = GroupModel.objects.all()
    return render(req, 'groups/groups.html', {'groups': all_groups})

def create_group(req):
    if req.method == 'GET':
        return render(req, 'groups/add_group.html', {'form': GroupForm})
    else:
        form = GroupForm(req.POST)
        if form.is_valid():
            new_group = form.save(commit=False)
            new_group.owner = req.user
            new_group.save()

            return redirect('groups:all_groups')
        else:
            return render(req, 'groups/add_group.html', {'form': GroupForm, 'error' : 'Invalid Data'}) 
         

def view_group_details(req, pk):
    group = get_object_or_404(GroupModel, pk=pk)
    if group.owner == req.user:
        return redirect(reverse('groups:edit_group_detail', kwargs={'pk': pk}))
    return render(req, 'groups/view_group_detail.html', {'group': group})

def edit_group_detail(req, pk):
    group = GroupAdditionalDetailsModel.objects.filter(group_id=pk)
        
    if req.method == 'GET':
        if len(group) > 0:
            return render(req, 'groups/edit_group_detail.html', {'form': GroupAdditionalDetailsForm(instance=group)})
        return render(req, 'groups/edit_group_detail.html', {'form': GroupAdditionalDetailsForm()})
    else:
        form = GroupAdditionalDetailsForm(req.POST, req.FILES)
        if form.is_valid():
            group_details = form.save(commit=False)
            group_details.owner = req.user
            group_details.save()
            return redirect(reverse('groups:edit_group_detail'), kwargs={'pk': pk})
        else:
            return render(req, 'groups/edit_group_detail.html',
                          {'form': GroupAdditionalDetailsForm(instance=group), 'error': 'Invalid form data'})
