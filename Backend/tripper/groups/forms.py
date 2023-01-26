from django import forms
from django.forms import ModelForm
from .models import GroupModel, GroupAdditionalDetailsModel

class GroupForm(ModelForm):
    class Meta:
        model = GroupModel
        fields = ['name', 'description']

class GroupAdditionalDetailsForm(ModelForm):
    class Meta:
        model = GroupAdditionalDetailsModel
        fields = ['members', 'uploaded_image']

        widgets = {
            'members': forms.Select(attrs={'class': 'form-control'}),
        }