print("Programa para calcular a média")
print(" aritmetica de 3 notas de um aluno")

lista = []

print("Por favor digite a 1ª nota: ")
n = float(input())
lista.append(n)

print("Por favor digite a 2ª nota: ")
n = float(input())
lista.append(n)

print("Por favor digite a 3ª nota: ")
n = float(input())
lista.append(n)

media = (lista[0] + lista[1] + lista[2]) / 3.0
print("A média final é: ", media)