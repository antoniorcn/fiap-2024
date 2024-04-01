"""
Faça um programa usando laços para desenhar
um retangulo na tela utilizando numeros, solicitando
que o usuário informe quantas linhas e 
quantas colunas o retangulo deve conter
linha ==> 5
colunas ==> 6
Ex.
123456
123456
123456
123456
123456
"""
print("Digite o numero linhas")
linhas = int(input())
print("Digite o numero colunas")
colunas = int(input())

for l in range(0, linhas):
    for c in range(0, colunas):
        print(c + 1, end="")
    print("")
 