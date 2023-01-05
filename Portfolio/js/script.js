let bookshelf = document.getElementsByClassName("bookshelf")[0];
let blogBtn =  document.getElementById("blog-btn");
let blogsDiv = document.getElementsByClassName("blogs-div")[0];
let bookshelfBtn = document.getElementById("bookshelf-btn");

blogBtn.classList.add("btn-set-background");
bookshelf.classList.add("hide");

function sendEmail() {
    Email.send({
      Host: "smtp.gmail.com",
      Username: "sender@email_address.com",
      Password: "Enter your password",
      To: 'receiver@email_address.com',
      From: "sender@email_address.com",
      Subject: "Sending Email using javascript",
      Body: "Well that was easy!!",
    })
      .then(function (message) {
        alert("mail sent successfully")
      });
  }

blogBtn.addEventListener("click", event => {
  if(blogsDiv.classList.contains("hide")) {
    bookshelf.classList.add("hide");
    blogsDiv.classList.remove("hide");

    blogBtn.classList.add("btn-set-background");
    bookshelfBtn.classList.remove("btn-set-background");
  }
});

document.getElementById("bookshelf-btn").addEventListener("click", event => {
  if(bookshelf.classList.contains("hide")) {
    bookshelf.classList.remove("hide");
    blogsDiv.classList.add("hide");

    blogBtn.classList.remove("btn-set-background");
    bookshelfBtn.classList.add("btn-set-background");
  }
});

document.getElementById("submit-btn").addEventListener("click", event => {
    event.preventDefault()

    let username = document.getElementById("full-name").value;
    let email = document.getElementById("email").value;
    let message = document.getElementById("message").value;

    console.log(username);
    console.log(email);
    console.log(message);

    document.getElementById("full-name").value = ""
    document.getElementById("email").value = ""
    document.getElementById("message").value = ""

    // sendEmail(username, email, message);
  });
