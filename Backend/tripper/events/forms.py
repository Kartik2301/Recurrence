from django import forms 
from django.forms import ModelForm
from .models import MeetupEvents

class AddEventForm(ModelForm):
    class Meta:
        model = MeetupEvents
        fields = ['event_name', 'description']

        widgets = {
            'description': forms.Textarea(attrs={'class': 'form-control'}),
            'event_name': forms.TextInput(attrs={'class': 'form-control'})
        }