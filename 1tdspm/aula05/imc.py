print("Programa para calcular o IMC")
print("Por favor informe seu peso ==>")
peso = float(input())
print("Por favor digite sua altura ==>")
altura = float(input())
imc = peso / ((altura / 100)**2)
print("Seu IMC é :", imc)
if imc >= 25:
    print("Você precisa emagrecer")
else:
    print("Você está bem")
print("Fim do programa")