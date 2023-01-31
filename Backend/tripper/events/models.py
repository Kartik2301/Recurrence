from django.db import models
from groups.models import GroupModel
from django.contrib.auth.models import User
from datetime import datetime

# Create your models here.
class MeetupEvents(models.Model):
    event_name = models.CharField(max_length=120)
    description = models.TextField(max_length=600)
    group_id = models.ForeignKey(GroupModel, on_delete=models.RESTRICT)
    attending_members = models.ManyToManyField(User)
    event_time = models.DateTimeField(default=datetime.now())