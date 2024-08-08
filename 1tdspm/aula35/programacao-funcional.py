lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]

def filtro_impar( numero ):
    if numero % 2 == 0:
        return False
    else:
        return True

nova_lista = filter( filtro_impar, lista  )

print("Lista: ")
print(lista)
print("Impares: ")
print(list(nova_lista))