
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