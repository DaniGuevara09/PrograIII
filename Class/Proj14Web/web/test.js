console.log("Bienvenidos")

var age = 34
let name = 'Valentina Vega'

sueldo = parseInt("8000000")
sueldo = "Muchos dolares"


console.log(`age=${typeof age} sueldo = ${typeof sueldo}  name=${typeof name}`)

state = true

console.log(typeof (state))

const student = {
    id: 2342,
    name: 'Juan',
    age: 25,
    address: 'Calle 123',
    gender: false

}

console.log(`student= ${typeof student}`);

//arreglos

const array = [33, 352.3, true, "sogamoso", { x: 455, y: 35 }]
console.log(array);
//muestra por posición
console.log(array[3]);

const numbers = [123, 3454, 334983, 3249]
//push agrega
numbers.push(11111);

console.log(numbers);

for (let i = 0; i < numbers.lengtht; i++) {
    console.log(numbers[i]);
}

console.log("-------- for mejorado -------- ");
//con el in toma indice
for (num in numbers) {
    console.log(num);

}
//con el of el dato

for (num of numbers) {
    console.log(num);
}

//v valor, i indice
console.log("------------ callback ------------ ");
numbers.forEach((v, i, x) => {
    console.log(`v =${v} i=${i} `)
})


console.log("-----------------------------------");

//programación funcional
//funciones de orden mayor como map, filter, reduce

const squares = numbers.filter(n => n % 2 != 0).map(v => v * 2).sort((x, y) => x - y)
console.log(squares)
//filtrar primos

function prime(n) {
    cont = 2;
    sw = true
    while (cont <= n / 2 && sw) {
        if (n % cont == 0) {
            sw = !(n % cont++ == 0);

        }
        return sw
    }

}

//filtarndo primos 
const squares2 = numbers.filter(n => prime(n)).map(v => v * 2).sort((x, y) => x - y)
console.log(squares2)


console.log("---------------------------------------")

const nums = [54, 12, 78, 10, 20]

let suma = nums.reduce((ant, act) => act + ant)

console.log(suma);

//ahora sumandole 10 al reuslatdo
let suma2 = nums.reduce((ant, act) => { return act + ant + 10 })
console.log(suma2);










