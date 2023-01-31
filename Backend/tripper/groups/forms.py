from django import forms
from django.forms import ModelForm
from .models import GroupModel, UploadGroupData

class GroupForm(ModelForm):
    class Meta:
        model = GroupModel
        fields = ['name', 'description']

class UploadGroupDataForm(ModelForm):
    class Meta:
        model = UploadGroupData
        fields = '__all__'