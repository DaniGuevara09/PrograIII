document.querySelector("#btn").addEventListener('click', ()=>{
    //alert('Pulsó el boto')
    const num = parseInt(document.querySelector("#num").value);
    //alert(num);
    const content = document.querySelector('#content') //.innerHTML = `<p>${num}</p>`;
    content.innerHTML = "Dani"

    const title = document.createElement('p')
    title.setAttribute("style", "font-weight: bold;")
    title.appendChild(document.createTextNode('Guevara'))
    content.appendChild(title)

    const thead = document.getElementById('thead')
    thead.innerHTML = ""
    const tbody = document.getElementById('tbody')
    const tit_table = document.createElement('tr')
    const  col_title = document.createElement('th')

    col_title.appendChild(document.createTextNode(`Numeros del 1 hasta el ${num}`))
    tit_table.appendChild(col_title)


    thead.appendChild(tit_table)

    for (let i = 1; i <= num ; i++) {

        // Crear una fila
        // Crear una columna (td)
        // Agrego a la columna el valor del contador
        // Agrego a la fila la columna
        // Agrego al body de la tabla la nueva fila
    }
})