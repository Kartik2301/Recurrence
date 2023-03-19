from django.shortcuts import render

# Create your views here.
def list(req):
    return render(req, "cars/list.html")

def add(req):
    return render(req, "cars/add.html")

def delete(req):
    return render(req, "cars/delete.html")