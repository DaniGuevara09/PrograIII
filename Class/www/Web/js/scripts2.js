const xhr = new XMLHttpRequest()
console.log(xhr.readyState)
xhr.open("GET", "data.json", true)
console.log(xhr.readyState)

xhr.onreadystatechange = () => {
    //console.log(xhr.readyState)
    if (xhr.readyState === 4 && xhr.status === 200) {
        console.log(xhr.responseText)

        const data = JSON.parse(xhr.responseText)
        console.log(typeof data)
        console.log(data)
    }
}

xhr.send()