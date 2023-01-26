from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User
from django.forms import ModelForm
from .models import UserMediaDetails

class UserCreationForm(UserCreationForm):
    email = forms.EmailField(required=True)

    class Meta:
        model = User
        fields = ['username', 'email', 'password1', 'password2', 'first_name', 'last_name']

class UserMediaDetailsForm(ModelForm):

    class Meta:
        model = UserMediaDetails
        fields = ['description', 'uploaded_image']
        widgets = {
            'description': forms.Textarea(attrs={'class': 'description-field'})
        }
