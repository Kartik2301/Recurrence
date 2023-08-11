# End option with print statement

def outputting():
	print(4.5, "Hello", 'end', 87, False)
	# arguments
	# end: default is '\n'
	print(5.5, "Nice", 'end', 66, True, end='|')
	print('Next Line')

# outputting()

# input
def inputting():
	name = input('Name: ')
	print(name)

	list_input = input('Enter space separated list of integers:\n')
	list_input = list_input.strip().split(" ")

	print(list_input)
	print(type(list_input))

# inputting()

def division():
	# / => returns float devision output
	# // => floor devision
	# int(a / b) alternative to 1
	pass

def string_methods():
	hello = 'hello'
	print(type(hello))

	hello_upper = hello.upper() # lower()
	print(hello_upper)

	hello_lower = hello.capitalize()
	print(hello_lower)

	# count occurences of a substring in a string
	print(hello.count('ll'))

	x = "morning"
	y = 3

	print(x * y)

# string_methods()

def ascii_ordinal():
	print(ord('Z'), ord('a'))

	ord_value = 115
	print(chr(ord_value))

# ascii_ordinal()

# Collections

def list_tuples():

	## Lists

	x = [4, True, 'hi'] # Hetrogeneous and Mutable
	print(x, len(x))

	x.append(5)
	print(x)

	x.extend([4,5,6,4,6,7,8,9])
	print(x)

	print(x.pop()) # Remove and return the last element
	print(x.pop(2))
	print('Modified List: ', x)

	print(x[1], x[-1])

	x[0] = "hello"
	print(x)

	# x stores a reference to the list and not a copy of the list
	# In the below example y will also store a reference to the list and hence any change to y will cause change in x because they are storing 
	# a reference to the list and not a copy of the list
	y = x
	y[0] = -1

	print(x, y)
	x[0] = "hello"

	# Copying a list without creating references, shallow copy
	z = x[:]
	z[0] = -1

	print(x, z)

	## Tuples

	# Tuples are immutable, we cannot append / remove or change elements

	x = (0,0,2,2)

# list_tuples()

def enumerate_list():
	x = [1,2,12,4,5,6,9,7,80]

	for index, value in enumerate(x):
		print(index, value)

# enumerate_list()

def sliced():
	x = [1,2,3,4,5,6,7,8,9,10,11,12]

	print(x[2:])
	print(x[2:4])
	print(x[4:2:-1])
	print(x[0:4:2])


	# Reverse a list

	rev = x[::-1]
	print(rev)

	s = "hello"
	print(s[::2])

# sliced()

# Set - Unordered, unique collection of elements
def set_lookups():
	x = [2,3,4,4,5,5,7,2,30]

	x = set(x)
	print(x)

	# x = set()

	# Set literal, different ffrom dict definition
	s = {4,32,2,2}
	print(s)

	s.add(5)
	print(s)

	s.remove(4)
	print(s)

	print(32 in s) # O(1)

	s2 = {3, 4, 22, 1}

	print(s, s2)

	print(s.union(s2))
	print(s.intersection(s2))

# set_lookups()

def dictionary():
	x = {'key': 4}

	print(x)

	x['key2'] = 58
	print(x)

	x[3] = 'hello'
	print(x)

	print('key' in x)

	li = list(x.values())
	print(li)

	print(list(x.keys()))

	# delete a key
	del x['key2']
	print(x)

	for key, value in x.items():
		print(key, value)

# dictionary()

def comprehension():
	x = [x + 5 for x in range(5)]
	print(x)

	x = [[0 for x in range(4)] for x in range(5)]
	print(x)

	x = [i for i in range(100) if i % 5 == 0]
	print(x)

	x = (i for i in range(100) if i % 5 == 0)
	print(x, type(x))

	x = tuple(i for i in range(100) if i % 5 == 0)
	print(x, type(x))

# comprehension()

# args and kwargs
# args are collected as a tuple
# kwargs are collected as a dictionary
def args_kwargs():
	def func(x):
		def func2():
			print(x)
		return func2

	x = func(3)
	print(x())

	x = [1,277,8,4,5,6,8,9,2,288,7]
	print(x)
	print(*x)

	def func3(x, y):
		print(x,y)
		print(y - x)

	pairs = [(1,2), (3,4)]

	for pair in pairs:
		func3(*pair)

	func3(**{'x': 2, 'y': 5})

	def generic(*args, **kwargs):
		print(args, kwargs)
		print('Unpack', *args)

	generic(1,2,3,4,5,6,one=0,two=1)

# args_kwargs()

def exceptions():
	# raise Exception('Bad')
	try:
		x = 7 / 0
	except Exception as e:
		print(e)
	finally:
		x = 0
		print('finally')

# exceptions()

def lambda_functions():
	x = lambda x: x+5
	print(x(5))

	# map
	x = [1,2,3,4,5,6,7,8,9]
	x = map(lambda i: i**2, x)
	print(list(x))

	#filter
	x = [1,2,3,4,5,6,7,8,9]
	x = filter(lambda i: i % 2 == 0, x)
	print(list(x))

	# Can define custom function, which can be passed in place of lambda

# lambda_functions()

# F-strings are new in Python 3.6