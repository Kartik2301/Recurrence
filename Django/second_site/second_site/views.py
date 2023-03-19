from django.shortcuts import render

def my_custom_page_not_found_view(req, exception):
    return render(req, 'eview.html', status=404)