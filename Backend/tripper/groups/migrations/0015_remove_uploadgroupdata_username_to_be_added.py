# Generated by Django 4.1.5 on 2023-01-28 16:09

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('groups', '0014_groupadditionaldetailsmodel_members'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='uploadgroupdata',
            name='username_to_be_added',
        ),
    ]
