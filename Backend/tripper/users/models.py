from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class UserMediaDetails(models.Model):
    description = models.TextField(max_length=200, null=True, blank=True)
    uploaded_image = models.ImageField(upload_to='images/', null=True)
    user_id = models.ForeignKey(User, on_delete=models.RESTRICT)
    image_url = models.URLField(null=True, blank=True)