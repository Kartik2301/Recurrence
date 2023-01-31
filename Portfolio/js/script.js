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

$(function () {
  var frm = $('#contactForm');
  frm.submit(function (ev) {
      $.ajax({
          type: frm.attr('method'),
          url: 'http://127.0.0.1:8000/send_email/',
          data: frm.serialize(),
          success: function (data) {
              $("#contactForm")[0].reset();
          }
      });
      ev.preventDefault();
  });
});
