from django.shortcuts import render

# Create your views here.
def example_view(req):
    return render(req, 'my_app/example.html')

def variable_view(request):
    my_var = {
        'first_name': 'Rose',
        'last_name': 'Mask',
        'some_list': [1,2,3],
        'some_dict': {'inside_key': 'inside_value'},
        'user_logged_in': False

    }
    return render(request, 'my_app/variable.html', context=my_var)