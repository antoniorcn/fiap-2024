from random import random, randrange, sample
numeros = sample(range(1, 15), 14)
print(numeros)

# cartas = [8, 14, 6, 5, 4, 13, 1, 12, 9, 10, 7, 3, 11, 2]

cartas = [6, 4, 3, 1, 5, 2]
# Algoritmo Bubble Sort
#         0  1  2  3  4  5      Etapa 1
# cartas = [4, 3, 1, 5, 2, 6]

#         0  1  2  3  4  5     Etapa 2
# cartas = [3, 1, 4, 2, 5, 6]

#         0  1  2  3  4  5     Etapa 3
# cartas = [1, 3, 2, 4, 5, 6]

#         0  1  2  3  4  5     Etapa 4
# cartas = [1, 2, 3, 4, 5, 6]
# Agora a lista esta ordenada

print( "Cartas desordenadas: ", cartas)
cartas.sort()
print( "Cartas ordenadas: ", cartas)