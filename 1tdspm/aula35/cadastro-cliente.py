clientes = [
    {"nome": "Joao Silva", "idade": 24, "genero": "M"},
    {"nome": "Maria Silva", "idade": 25, "genero": "F"},
    {"nome": "Alberto Roberto", "idade": 30, "genero": "M"},
    {"nome": "Iracema Souza", "idade": 23, "genero": "F"}
]
filtro_homens = lambda dicionario : dicionario['genero'] == "M"
filtro_mulheres = lambda dicionario : dicionario['genero'] == "F"
homens = filter( filtro_homens, clientes )
mulheres = filter( filtro_mulheres, clientes)
print("Todo mundo: ")
print(clientes)
print("Apenas os homens: ")
print( list(homens) )
print("Apenas as mulheres: ")
print( list(mulheres) )