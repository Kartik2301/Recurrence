function createBlogElement(title, date_time, description) {

	let blog_item = 
	`
		<div class="groups-card-body" style="width: auto; text-align: left; background-color: #fdf2e9; border: none;">
			<a href="#" style="color: black">
				<div class="card-body">
					<h5 style="color: blue; text-align: center;" class="card-title">${title}</h5>
					<small><b><i>${date_time}</i></b></small>
					<br>
					<p>${description}</p>
				</div>
			</a>
		</div>
	`

	htmlObject = document.createElement('div');
	htmlObject.class = "page-setup-padding";
	htmlObject.innerHTML = blog_item;

	return htmlObject;
}

function populateBlogs() {
	$.ajax({
		url : 'https://kartiknema.pythonanywhere.com/blogs/',
		method: 'GET',
		success: data => {
			for(let i = 0; i < data.length; i++) {
				blog_item = createBlogElement(data[i]['title'], 
											  data[i]['date_time'], 
											  data[i]['description'])
				$(".group-content")[0].appendChild(blog_item)
			}
		}
	});
}

populateBlogs()