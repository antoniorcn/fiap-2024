lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]

def filtro_divisivel_3_ou_4( numero ):
    return numero % 3 == 0 or numero % 4 == 0
    
nova_lista = filter( filtro_divisivel_3_ou_4, lista )

print("Lista: ")
print(lista)
print("Filtrado 3 ou 4: ")
print( list(nova_lista) )