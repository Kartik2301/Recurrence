# Generated by Django 4.1.5 on 2023-01-26 16:18

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('groups', '0010_remove_groupadditionaldetailsmodel_username_to_be_added'),
    ]

    operations = [
        migrations.AddField(
            model_name='groupadditionaldetailsmodel',
            name='username_to_be_added',
            field=models.CharField(blank=True, max_length=80, null=True),
        ),
    ]
