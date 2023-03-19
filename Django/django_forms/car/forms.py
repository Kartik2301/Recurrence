from django import forms
from .models import Review
from django.forms import ModelForm



# class ReviewForm(forms.Form):
#     first_name = forms.CharField(label='First Name', max_length=100)
#     last_name = forms.CharField(label='Last Name', max_length=100)
#     email = forms.EmailField(label='Email')
#     review = forms.CharField(label='Write your review', widget=forms.Textarea(attrs={'rows': '5'}))

class ReviewForm(ModelForm):
    class Meta:
        model = Review
        fields = ['first_name', 'last_name', 'stars']

        labels = {
            'first_name': 'This is the first name',
            'last_name': 'This is the last name',
            'stars': 'The stars are'
        }

        error_messages = {
            'stars': {
                'min_value': "too low",
                'max_value': "too high"
            }
        }