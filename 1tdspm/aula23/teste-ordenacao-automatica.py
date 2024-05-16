from random import sample
#         0  1  2  3  4  5
# cartas = [6, 4, 3, 1, 5, 2]
cartas = sample(range(0, 1000), 100)
print("Desordenada: ", cartas)
# i         0  1  2  3  4  5
# i + 1
# cartas = [4, 6, 3, 1, 5, 2]
# ajuda = 6
for j in range(len(cartas)):
    for i in range(0, len(cartas) - 1):
        if cartas[i] > cartas[i + 1]:
            # Trocar o valor de cartas[0] por cartas[1]
            ajuda = cartas[i]
            cartas[i] = cartas[i + 1]
            cartas[i + 1] = ajuda
    # print(cartas)

print("\n\nOrdenada: ", cartas)