console.log("Programa de arrays");
console.log("Autor: Antonio Carvalho");
//             0  1  2   3  4   5   6   7
const lista = [3, 5, 7, 11, 3, 17, 19, 23];
console.log(lista[3]);

let s = lista[0] + lista[1] + lista[2]
console.log(s);

let soma = 0;
let i = 0;
while(i < 8) { 
    soma = soma + lista[i];
    i = i + 1;
}
console.log("Soma: ", soma);
