from django.shortcuts import render, redirect

def landing(req):
    return render(req, 'landing.html')