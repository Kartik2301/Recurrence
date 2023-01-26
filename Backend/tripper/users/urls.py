from django.urls import path
from . import views

app_name = 'users'

urlpatterns = [
    path('signup/', views.signup, name='signup_user'),
    path('signin/', views.signin, name='signin_user'),
    path('profile/', views.view_profile, name='view_profile'),
    path('logout/', views.logoutuser, name='logout_user')
]