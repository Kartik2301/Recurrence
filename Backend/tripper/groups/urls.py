from django.urls import path
from . import views

app_name = 'groups'

urlpatterns = [
    path('', views.list_all_groups, name='all_groups'),
    path('add/', views.create_group, name='create_group'),
    path('group/<int:pk>/', views.view_group_details, name='view_group_details'),
    path('group/edit/<int:pk>/', views.edit_group_detail, name='edit_group_detail'),
]