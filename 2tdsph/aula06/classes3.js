class Matematica {

    numero1 = 10
    numero2 = 20

    somar() { 
        const r = this.numero1 + this.numero2;
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
objMat.numero1 = 50;
objMat.numero2 = 60;
r1 = objMat.somar();

console.log("Resultado: ", r1);