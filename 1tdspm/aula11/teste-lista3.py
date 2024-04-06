print("Programa para calcular a média de crescimento de uma planta")
 
crescimento = []
 
for i in range(12):
    print(f"Digite o crescimento da planta no {i + 1}º mês ")
    cres_mes = float(input())
    crescimento.append(cres_mes)
 
soma = 0
for i in range(12):
    soma = soma + crescimento[i]
 
media = soma / 12
print("Esta é a média de crescimento mesnsal da planta: ", media)