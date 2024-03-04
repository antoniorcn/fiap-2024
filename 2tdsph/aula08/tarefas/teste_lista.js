// Operador Spread
//              0  1  2  3  4
const lista1 = [1, 3, 5, 7, 11];

// Ter outra variavel apontando para a mesma lista
// const lista2 = lista1;

// Copia da lista1
// const lista3 = [];
// for(let i = 0; i < lista1.length; i++) { 
//     // lista3[i] = lista1[i];
//     lista3.push(lista1[i]);
// }


// Copia da lista1 - usando Object Assign
// const lista3 = [];
// Object.assign(lista3, lista1);


// Copia da lista1 - usando o operador Spread
const lista3 = [  ...lista1  ];

lista1[4] = 13;

console.log("Lista1: ", lista1);
// console.log("Lista2: ", lista2);
console.log("Lista3: ", lista3);