from django.shortcuts import render
from django.http.response import HttpResponse, HttpResponseNotFound, Http404, HttpResponseRedirect
from django.urls import reverse
from django.shortcuts import render

# Create your views here.
def simple_view(request):
    return render(request, 'first_app/example.html')