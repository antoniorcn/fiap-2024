console.log("Programa para testar a temperatura")
console.log("Autor: Antonio Carvalho");
console.log("Faculdade: FIAP")

const prompt = require("prompt-sync")();

const temperatura = 
    prompt("Digite a temperatura atual ==> ");

if (temperatura < 0) { 
    console.log("Está congelando")
}

if (temperatura >= 0 && temperatura <= 10) { 
    console.log("Está muito frio");
}

if (temperatura >= 11 && temperatura <= 16) { 
    console.log("Está frio");
}

if (temperatura >= 17 && temperatura <= 22) { 
    console.log("Está agradável");
}

if (temperatura >= 23 && temperatura <= 30) { 
    console.log("Está calor");
}

if (temperatura > 30) { 
    console.log("Está muito calor");
}
    
    