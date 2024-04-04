'''
Utilizando as ténicas para popular listas e somar 
valores da lista, crie um programa para calcular
a media de crescimento anual de uma planta. Para isto
o programa deverá pedir a altura da planta medida no mês,
por 12 meses. e utilizando a tecnica de soma por iteração 
calcule a soma de todos os crescimentos. Com base na soma 
dos crescimentos calcule a média de crescimento ao 
longo do ano.
'''

print("Programa para calcular a media de crescimento")
print(" anual de uma planta ")
qtd_meses = 3
crescimentos = []

for i in range(qtd_meses):
    print(f"Por favor informe o crescimento do mês {i + 1}")
    cres_mes = float(input())
    crescimentos.append( cres_mes )

soma = 0
for i in range(qtd_meses):
    soma = soma + crescimentos[i]

media = soma / qtd_meses
print("Media: ", media)