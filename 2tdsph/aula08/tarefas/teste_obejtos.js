const aluno1 = {
    ra: "11111",
    nome: "João Silva",
    tel: "(11) 1111-1111"
}

const aluno2 = aluno1;

// const a = 19;
// const b = a;

// Copia do aluno1 com Object Assign
// const aluno3 = {};
// Object.assign(aluno3, aluno1);

// Copia usando o operador Spread
const aluno3 = { ... aluno1 };

aluno1.nome = "Maria Silva";

console.log("Aluno1: ", aluno1);
console.log("Aluno3: ", aluno3);
