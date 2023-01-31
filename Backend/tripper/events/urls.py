from django.urls import path
from .import views

app_name = 'events'

urlpatterns = [
    path('', views.all_events, name='all_events'),
    path('add/', views.add_event, name='add_event')
]