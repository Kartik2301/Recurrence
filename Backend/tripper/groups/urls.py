from django.urls import path, include
from . import views

app_name = 'groups'

urlpatterns = [
    path('', views.list_all_groups, name='all_groups'),
    path('add/', views.create_group, name='create_group'),
    path('group/<int:pk>/', views.view_group_details, name='view_group_details'),
    path('group/edit/<int:pk>/', views.edit_group_detail, name='edit_group_detail'),
    path('add_user_to_group/', views.add_user_to_group, name='add_user_to_group'),
    path('group/<int:pk>/events/', include('events.urls')),
]