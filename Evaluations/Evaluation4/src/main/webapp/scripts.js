(()=>{
    const xhr = new XMLHttpRequest()
    xhr.open("GET", `dish-servlet?option=1`, true);
    xhr.onreadystatechange = ()=>{
        if ( xhr.readyState === 4 && xhr.status === 200 ){
            console.log( `La respuesta es ${xhr.responseText}` )
        }
    }
    xhr.send()
})()
