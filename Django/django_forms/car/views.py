from django.shortcuts import render, redirect
from django.urls import reverse
from .forms import ReviewForm

# Create your views here.
def rental_review(req):

    if req.method == 'POST':
        form = ReviewForm(req.POST)
        if form.is_valid():
            form.save()
            return redirect(reverse('car:thank_you'))
    else:
        form = ReviewForm()

    return render(req, 'car/rental.html', context={'form': form})

def thank_you(req):
    return render(req, 'car/thanks.html')