from django.shortcuts import render
from . import models

# Create your views here.
def list_patients(req):
    all_patients = models.Patient.objects.all()
    context_list = {'patients': all_patients}
    return render(req, 'office/list.html', context=context_list)