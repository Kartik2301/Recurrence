from django.shortcuts import render
from django.http.response import HttpResponse
from .models import Book, Author, Genre, Book, Language, BookInstance
from django.views.generic import CreateView, DetailView
from django.contrib.auth.decorators import login_required
from django.contrib.auth.mixins import LoginRequiredMixin

# Create your views here.
def index(req):
    num_books = Book.objects.all().count()
    num_instances = BookInstance.objects.all().count()

    num_instances_available = BookInstance.objects.filter(status__exact='a').count()

    context = {
        'num_books': num_books,
        'num_instances': num_instances,
        'num_instances_avail': num_instances_available
    }
    return render(req, 'catalog/index.html', context=context)


class BookCreate(LoginRequiredMixin, CreateView):
    model = Book
    fields = '__all__'

class BookDetail(DetailView):
    model = Book

@login_required
def my_view(req):
    return render(req, 'catalog/my_view.html')