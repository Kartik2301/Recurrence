let bookshelf = document.getElementsByClassName("bookshelf")[0];
let blogBtn =  document.getElementById("blog-btn");
let blogsDiv = document.getElementsByClassName("blogs-div")[0];
let bookshelfBtn = document.getElementById("bookshelf-btn");

blogBtn.classList.add("btn-set-background");
bookshelf.classList.add("hide");

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
          url: 'https://kartiknema.pythonanywhere.com/send_email/',
          data: frm.serialize(),
          success: function (data) {
              $("#contactForm")[0].reset();
          }
      });
      
      document.getElementById("full-name").value = ""
      document.getElementById("email").value = ""
      document.getElementById("message").value = ""
      ev.preventDefault();
  });
});
