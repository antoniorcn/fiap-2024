#         0, 1,  2
# lista1 = [4, 8, 12]
# print("Lista1: ", lista1)
# lista1[1] = 16
# print("Lista1: ", lista1)

tupla1 = (4, 8, 12)
print("Tupla1: ", tupla1)
print("Tupla1 indice 1: ", tupla1[1])

lista1 = list(tupla1)
lista1[1] = 16
print("Lista1: ", lista1)

tupla2 = tuple([9, 15, 22])
print("tupla2: ", tupla2)