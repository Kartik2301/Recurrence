# Generated by Django 4.1.5 on 2023-01-22 20:35

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0004_alter_usermediadetails_description'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='usermediadetails',
            name='local_img_path',
        ),
    ]
