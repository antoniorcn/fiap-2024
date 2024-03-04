const aluno1 = {
    ra: "111111",
    nome: "João Silva",
    telefone: "(11) 1111-1111"
}

// Criar variaveis apontando para 
// atributos do objeto
// const ra = aluno1.ra;
// const nome = aluno1.nome;
// const telefone = aluno1.telefone;

// Criar variaveis apontando para 
// atributos do objeto
// usando desetruturação

const {ra, nome, telefone} = aluno1;

console.log("RA: ", ra);
console.log("Nome: ", nome);
console.log("Telefone: ", telefone);