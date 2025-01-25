(() => {
    // Al cargar la página, obtenemos los datos
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "SvItem", true);

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);
            table(response);
        }
    };
    xhr.send();
})();

// Actualiza la tabla con los items recibidos
function table(items) {
    const tableBody = document.querySelector("#table tbody");

    if (!tableBody) {
        console.error("El elemento #table tbody no se encuentra.");
        return;
    }
    tableBody.innerHTML = "";  // Limpiar tabla antes de actualizar

    if (items.length === 0) {
        console.log("No hay items para mostrar.");
        return;
    }

    // Crear las filas de la tabla
    items.forEach(item => {
        const row = document.createElement("tr");

        const idCell = document.createElement("td");
        idCell.textContent = item.id;
        row.appendChild(idCell);

        const nameCell = document.createElement("td");
        nameCell.textContent = item.name;
        row.appendChild(nameCell);

        const kiCell = document.createElement("td");
        kiCell.textContent = item.ki;
        row.appendChild(kiCell);

        const razaCell = document.createElement("td");
        razaCell.textContent = item.race;
        row.appendChild(razaCell);

        const descriptionCell = document.createElement("td");
        descriptionCell.textContent = item.description;
        row.appendChild(descriptionCell);

        const imageCell = document.createElement("td");
        const img = document.createElement("img");
        img.src = item.image;
        img.alt = item.name;
        img.style.width = "50px";  // Ajustar tamaño de imagen
        imageCell.appendChild(img);
        row.appendChild(imageCell);

        tableBody.appendChild(row);
    });
}

// Filtra la tabla según la selección
function filterTable() {
    const filterValue = document.getElementById('filter').value;

    const kiSelect = document.getElementById('kiSelect');
    const kiLabel = document.getElementById('kiLabel');

    const raceSelect = document.getElementById('raceSelect');
    const raceLabel = document.getElementById('raceLabel');

    // Mostrar u ocultar el selector de raza dependiendo de la opción seleccionada
    if (filterValue === 'race') {
        raceSelect.style.display = 'inline';  // Mostrar selector de raza
        raceLabel.style.display = 'inline';   // Mostrar etiqueta de raza
    } else {
        raceSelect.style.display = 'none';    // Ocultar selector de raza
        raceLabel.style.display = 'none';     // Ocultar etiqueta de raza
    }

    if (filterValue === 'ki') {
        kiSelect.style.display = 'inline';  // Mostrar selector de raza
        kiLabel.style.display = 'inline';   // Mostrar etiqueta de raza
    } else {
        kiSelect.style.display = 'none';    // Ocultar selector de raza
        kiLabel.style.display = 'none';     // Ocultar etiqueta de raza
    }


    // Filtrar según la selección
    if (filterValue === 'all') {
        loadItems();  // Mostrar todos los items
    } else if (filterValue === 'ki') {
        const selectedKi = kiSelect.value;
        if (selectedKi) {
            loadItemsByKi(selectedKi);  // Filtrar por Ki
        }
    } else if (filterValue === 'race') {
        const selectedRace = raceSelect.value;
        if (selectedRace) {
            loadItemsByRace(selectedRace);  // Filtrar por raza
        }
    }
}

// Función para cargar todos los items
function loadItems() {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "SvItem", true);

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);
            table(response);  // Llamar a la función table para mostrar los datos
        }
    };
    xhr.send();
}

// Función para cargar los items filtrados por Ki
function loadItemsByKi() {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "SvItem", true);

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);
            const filteredItems = filterByKi(response);  // Filtrar por Ki
            table(filteredItems);  // Mostrar los items filtrados
        }
    };
    xhr.send();
}

// Función para cargar los items filtrados por raza
function loadItemsByRace(race) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "SvItem", true);

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);
            const filteredItems = filterByRace(response, race);  // Filtrar por raza
            table(filteredItems);  // Mostrar los items filtrados
        }
    };
    xhr.send();
}

// Filtrar por Ki
function filterByKi(data) {
    const kiSelect = document.getElementById('kiSelect');
    const selectedKi = kiSelect.value;

    if (!selectedKi) return data;  // Si no hay un rango seleccionado, no filtramos

    // Definir los rangos para Ki
    const kiRanges = {
        "0-20000": [0, 20000],
        "530000-45000000": [530000, 45000000],
        "54000000-250000000": [54000000, 250000000]
    };

    // Obtener el rango seleccionado
    const [minKi, maxKi] = kiRanges[selectedKi];

    // Filtrar los items por el rango de Ki seleccionado
    return data.filter(item => {
        // Convertir el valor de Ki en cada item a número y verificar si está en el rango
        const itemKi = parseInt(item.ki.replace(/[.]/g, ''), 10);  // Limpiar posibles caracteres no numéricos
        console.log(itemKi)
        return itemKi >= minKi && itemKi <= maxKi;
    });
}


// Filtrar por Raza
function filterByRace(data, race) {
    return data.filter(item => item.race === race);  // Filtrar items por la raza seleccionada
}
