document.addEventListener("DOMContentLoaded", function () {
    const registrationForm = document.getElementById("registration-form");
    const messageDiv = document.getElementById("message");

    registrationForm.addEventListener("submit", function (e) {
        e.preventDefault();

        const username = document.getElementById("username").value;
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        const user = {
            username,
            email,
            password,
        };

        axios.post("http://localhost:8080/api/v1/register", JSON.stringify(user), {
            Headers: {
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                messageDiv.innerHTML = "Registration successful!";
            })
            .catch(function (error) {
                if (error.response) {
                    messageDiv.innerHTML = "Registration failed: " + error.response.data.message;
                } else {
                    messageDiv.innerHTML = "Registration failed: " + error.message;
                }
            });
    });
});