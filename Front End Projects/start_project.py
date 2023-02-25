import os

def create_file(filename, text):
	with open(filename, mode="w") as file:
		file.write(text)

project_name = input('Enter name of project ')
html_file_name = input('Enter name of root html file [default index.html] ')
css_file_name = input('Enter name of stylesheet/css file [default styles.css] ')
js_file_name = input('Enter name of static script/js file [default script.js] ')
create_sw = input('Should a Service Worker be created [y/n] ')

if html_file_name == None or len(html_file_name) == 0:
	html_file_name = 'index'

if css_file_name == None or len(css_file_name) == 0:
	css_file_name = 'styles'

if js_file_name == None or len(js_file_name) == 0:
	js_file_name = 'script'

if create_sw == None or len(create_sw) == 0:
	create_sw = 'y'

os.system(f'mkdir {project_name}')
os.chdir(f"{project_name}")

os.system(f'mkdir css')
os.chdir("css")
create_file(f'{css_file_name}.css', "")
os.chdir("..")


os.system(f'mkdir js')
os.chdir("js")
create_file(f'{js_file_name}.js', "")
os.chdir("..")

html_boilerplate = '\
	<!DOCTYPE html>\
	\n<html lang="en">\
	\n<head>\
	  \n<meta charset="UTF-8">\
	  \n<meta http-equiv="X-UA-Compatible" content="IE=edge">\
	  \n<meta name="viewport" content="width=device-width, initial-scale=1.0">\
	  \n<title>Document</title>\
	\n</head>\
	\n<body>\
	\n</body>\
	\n</html>'\

create_file(f'{html_file_name}.html', html_boilerplate)

if create_sw == 'y':
	create_file('sw.js', "")