console.log("Programa para testar a temperatura")
console.log("Autor: Antonio Carvalho");
console.log("Faculdade: FIAP")

const prompt = require("prompt-sync")();

const temperatura = 
    prompt("Digite a temperatura atual ==> ");

// Uso do IF encadeado

if (temperatura < 0) { 
    console.log("Está congelando")
} else {
    if (temperatura >= 0 && temperatura <= 10) { 
        console.log("Está muito frio");
    } else { 
        if (temperatura >= 11 && temperatura <= 16) { 
            console.log("Está frio");
        } else { 
            if (temperatura >= 17 && temperatura <= 22) { 
                console.log("Está agradável");
            } else {
                if (temperatura >= 23 && temperatura <= 30) { 
                    console.log("Está calor");
                } else { 
                    if (temperatura > 30) { 
                        console.log("Está muito calor");
                    }
                }
            }
        }
    }
}
    
    
