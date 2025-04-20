document.addEventListener('DOMContentLoaded', () => {
    const loginCard = document.querySelector('.login-card');
    loginCard.classList.add('show');

    // Optional: greet the user
    const greeting = ["Welcome!", "Hello again!", "Ready to log in?", "Let's go 🚀"];
    const h2 = loginCard.querySelector("h2");
    h2.textContent = greeting[Math.floor(Math.random() * greeting.length)];
});
