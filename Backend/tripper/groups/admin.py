from django.contrib import admin
from .models import GroupModel, GroupAdditionalDetailsModel

# Register your models here.
admin.site.register(GroupModel)
admin.site.register(GroupAdditionalDetailsModel)