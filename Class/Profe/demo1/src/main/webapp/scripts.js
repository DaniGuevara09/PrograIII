(()=>{
    const xhr = new XMLHttpRequest()

    xhr.open("GET","servlet-example?option=1",true)

    xhr.onreadystatechange = ()=>{
        if ( xhr.readyState === 4 && xhr.status === 200 ){
            console.log( `La respuesta es ${xhr.responseText}` )
        }
    }
    xhr.send()
})()

document.querySelector("#btnSend").addEventListener('click',()=>{
    const plate = document.querySelector("#plate").value

    const xhr = new XMLHttpRequest()
    xhr.open("GET",`servlet-example?option=2&plate=${plate}`,true)

    xhr.onreadystatechange = ()=>{
        if ( xhr.readyState === 4 && xhr.status === 200 ){
            if( xhr.responseText != "null"){
                const car = JSON.parse( xhr.responseText )
                console.log(`Placa=${car.plate}`)
                console.log(`Marca=${car.mark}`)
                console.log(`Modelo=${car.model}`)
                console.log(`Color=${car.color}`)
            }else{
                alert( alert("El Carro no Existe"))
            }
        }
    }
    xhr.send()
})

document.querySelector("#btnSave").addEventListener('click',()=>{
    const plate = document.querySelector("#plateAux").value
    const mark = document.querySelector("#mark").value
    const model = document.querySelector("#model").value
    const color = document.querySelector("#color").value

    const car = {"plate":plate,"mark":mark,"model":model,"color":color}
    const xhr = new XMLHttpRequest()
    xhr.open("POST","servlet-example")
    xhr.onreadystatechange = ()=>{
        if ( xhr.readyState === 4 && xhr.status === 200){
            alert(xhr.responseText)
        }
    }
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded")
    const data = `plate=${plate}&mark=${mark}&model=${model}&color=${color}`
    xhr.send(data)

})

document.querySelector("#btnPut").addEventListener('click',()=>{
    const xhr = new XMLHttpRequest()
    xhr.open("PUT","servlet-example",true)
    xhr.onreadystatechange =()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            alert(xhr.responseText)
        }
    }
    xhr.send(null)
})

