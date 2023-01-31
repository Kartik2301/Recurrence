from django.shortcuts import render, redirect, get_object_or_404
from .models import MeetupEvents
from .forms import AddEventForm
from django.urls import reverse
from django.http.response import HttpResponse
from groups.models import GroupModel
from datetime import datetime

# Create your views here.
def all_events(req, pk):
    evs = MeetupEvents.objects.filter(group_id=pk)
    return render(req, 'events/all_events.html', {'all_events': evs})

def add_event(req, pk):
    event_name = req.POST['event_name']
    event_description = req.POST['event_description']
    event_time = req.POST['event_time']
    
    event = MeetupEvents.objects.create(
        event_name=event_name,
        description=event_description,
        event_time=event_time,
        group_id = get_object_or_404(GroupModel, pk=pk))
    event.save()

    return HttpResponse('Event Added')