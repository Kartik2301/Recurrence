function populateBlogs() {
	$.ajax({
		url : 'https://kartiknema.pythonanywhere.com/blogs/',
		method: 'GET',
		success: data => {
			console.log(data)
		}
	});
}

populateBlogs()