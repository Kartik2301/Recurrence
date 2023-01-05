console.log("Connected")

let fetchBtn = document.getElementById("fetchBtn");
let popBtn = document.getElementById("populateBtn");

fetchBtn.addEventListener("click", buttonClickHandler)
popBtn.addEventListener("click", popHandler)

function buttonClickHandler() {
	// Instantiate the XHR object
	const xhr = new XMLHttpRequest();
	// Open the Object
	// xhr.open('GET','https://jsonplaceholder.typicode.com/todos/1', true)

	xhr.open('POST', 'http://dummy.restapiexample.com/api/v1/create', true)
	xhr.getResponseHeader('Content-type', "application/json");

	// What to do during progress, optional
	xhr.onprogress = function() {
		console.log("onProgress")
	}
	// What to do when, response is ready
	xhr.onload = function() {
		if(this.status == 200) {
			console.log(this.responseText);
		} 
	}
	// send the request
	params = `{"name":"test3378558","salary":"123","age":"23"}`
	xhr.send(params)

	console.log("We are done")
}

function popHandler() {
	// Instantiate the XHR object
	const xhr = new XMLHttpRequest();
	// Open the Object
	xhr.open('GET','http://dummy.restapiexample.com/api/v1/employees', true)

	// What to do during progress, optional
	// xhr.onprogress = function() {
	// 	console.log("onProgress")
	// }
	// What to do when, response is ready
	xhr.onload = function() {
		if(this.status == 200) {
			let obj = JSON.parse(this.responseText)
			console.log(obj)
			obj = obj['data']
			let list = document.getElementById("list")
			var str = ""
			for(key in obj) {
				str += `<li>${obj[key].employee_name}</li>`
			}
			list.innerHTML = str
		} 
	}
	// send the request
	xhr.send()

	console.log("We are done")
}

// https://codepen.io/tcannonfodder/pen/QjpMoL
// https://stackoverflow.com/questions/21884963/how-to-submit-this-form-using-ajax-without-jquery-but-pure-javascript/21885125
//https://github.com/Kartik2301/personal-website/blob/master/portfolio/static/portfolio/custom.js