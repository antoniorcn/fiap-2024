lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]

def transforma_quadrado( numero ):
    return numero * numero

lista_transformada = map( transforma_quadrado, lista )

print("Lista: ")
print(lista)
print("Lista transformada: ")
print( list(lista_transformada) )