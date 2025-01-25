alert("Si funciona")
document.querySelector("#btnSend").addEventListener('click', (event) => {
    console.log(event);
})

document.getElementById("num1").addEventListener('keypress', (e) => {
    if (/[a-zA-Z]/.test(e.key)) { // Verifica si la tecla es una letra
        e.preventDefault(); // Evita que la tecla se registre en el input
    }
});
