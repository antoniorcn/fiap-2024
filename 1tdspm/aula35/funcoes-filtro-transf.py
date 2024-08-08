lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 17]

def impares( lista_numeros ):
    lista_temp = []
    for numero in lista_numeros:
        if numero % 2 != 0:
            lista_temp.append( numero )
    return lista_temp

def quadrado( lista_numeros ):
    lista_temp = []
    for numero in lista_numeros:
        lista_temp.append(numero * numero)
    return lista_temp

print("Lista de numeros: ")
print( lista )
print("Numeros impares: ")
numeros_impares = impares( lista )
print( numeros_impares )
print("O quadrado dos numeros: ")
numeros_quadrado = quadrado( numeros_impares )
print( numeros_quadrado )