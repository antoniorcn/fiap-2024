function somar(num1, num2) { 
    const r = num1 + num2;
    return r;
}

function subtrair(num1, num2) { 
    const r = num1 - num2;
    return r;
}

function multiplicar(num1, num2) { 
    const r = num1 * num2;
    return r;
}

function dividir(num1, num2) { 
    const r = num1 / num2;
    return r;
}

r1 = somar(10, 20);
r2 = subtrair(r1, 5);
r3 = multiplicar(r2, 3);
r4 = dividir(r3, 5);
console.log("Resultado: ", r4);