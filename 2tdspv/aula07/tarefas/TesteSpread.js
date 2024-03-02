//       0  1  2  3  4  5
lista = [1, 3, 5, 7, 9, 11];
// lista2 = lista; // substituir por uma copia

/*
lista2 = []
for (let i = 0; i < lista.length; i++) { 
    lista2.push( lista[i] );
}
*/

/*
lista2 = []
Object.assign(lista2, lista);
*/

lista2 = [ ...lista ];

lista3 = lista2;
lista[4] = 8;
console.log("Lista: ", lista);
console.log("Lista2: ", lista2);
console.log("Lista3: ", lista3);