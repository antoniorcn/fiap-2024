const prompt = require("prompt-sync")();

console.log("Programa para checar se um número é par");
console.log("Autor: Antonio Carvalho");
console.log("Faculdade: FIAP")

let numero = prompt("Digite um numero entre 0 e 1000 ==>");

// condição
if (numero % 2 === 0) {
    console.log("O número: ", numero, " é par");
} else { 
    console.log("O número: ", numero, " é impar");
}

// if (numero % 2 === 1) { 
//     console.log("O número: ", numero, " é impar");
// }