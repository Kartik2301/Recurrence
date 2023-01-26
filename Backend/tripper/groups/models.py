from django.db import models
from django.contrib.auth.models import User

# Create your models here.
class GroupModel(models.Model):
    name = models.CharField(max_length=120, null=False)
    description = models.CharField(max_length=400, null=False)
    owner = models.ForeignKey(User, on_delete=models.CASCADE, null=True)

    def __str__(self):
        return f"{self.name} - {self.description}"
    
class GroupAdditionalDetailsModel(models.Model):
    uploaded_image = models.ImageField(upload_to='group_thumbs/', null=True)
    image_url = models.URLField(null=True, blank=True)
    members = models.ManyToManyField(User)
    group_id = models.ForeignKey(GroupModel, on_delete=models.RESTRICT)