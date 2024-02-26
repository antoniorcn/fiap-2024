class Matematica {

    somar(num1, num2) { 
        const r = num1 + num2;
        return r;
    }

    subtrair(num1, num2) { 
        const r = num1 - num2;
        return r;
    }

    multiplicar(num1, num2) { 
        const r = num1 * num2;
        return r;
    }

    dividir(num1, num2) { 
        const r = num1 / num2;
        return r;
    }

}

const objMat = new Matematica();

r1 = objMat.somar(10, 20);
r2 = objMat.subtrair(r1, 5);
r3 = objMat.multiplicar(r2, 3);
r4 = objMat.dividir(r3, 5);
console.log("Resultado: ", r4);