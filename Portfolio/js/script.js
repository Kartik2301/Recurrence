document.getElementsByClassName("bookshelf")[0].classList.add("hide");
document.getElementById("blog-btn").classList.add("btn-set-background");

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

document.getElementById("blog-btn").addEventListener("click", event => {
  if(document.getElementsByClassName("blogs-div")[0].classList.contains("hide")) {
    document.getElementsByClassName("bookshelf")[0].classList.add("hide");
    document.getElementsByClassName("blogs-div")[0].classList.remove("hide");

    document.getElementById("blog-btn").classList.add("btn-set-background");
    document.getElementById("bookshelf-btn").classList.remove("btn-set-background");
  }
});

document.getElementById("bookshelf-btn").addEventListener("click", event => {
  if(document.getElementsByClassName("bookshelf")[0].classList.contains("hide")) {
    document.getElementsByClassName("bookshelf")[0].classList.remove("hide");
    document.getElementsByClassName("blogs-div")[0].classList.add("hide");

    document.getElementById("blog-btn").classList.remove("btn-set-background");
    document.getElementById("bookshelf-btn").classList.add("btn-set-background");
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
