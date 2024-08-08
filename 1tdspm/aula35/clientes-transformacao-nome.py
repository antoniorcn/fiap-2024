clientes = [
    {"nome": "Joao Silva", "idade": 24, "genero": "M"},
    {"nome": "Maria Silva", "idade": 25, "genero": "F"},
    {"nome": "Alberto Roberto", "idade": 30, "genero": "M"},
    {"nome": "Iracema Souza", "idade": 23, "genero": "F"}
]

transforma_nome = lambda d : d["nome"]

nomes_clientes = map( transforma_nome, clientes )

print("Lista clientes: ")
print(clientes)
print("Apenas os nomes: ")
print( list(nomes_clientes) )