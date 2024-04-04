print("Programa para calcular a média")
print(" aritmetica de 3 notas de um aluno")

lista = []
for i in range(3):
    print(f"Por favor digite a {i + 1}ª nota: ")
    n = float(input())
    lista.append(n)

print("Lista: ", lista)

soma = 0
for i in range(3):
    numero = lista[i]
    soma = soma + numero
    print("Numero: ", numero, "\tSoma: ", soma)

media = soma / 3
print("Media é: ", media)