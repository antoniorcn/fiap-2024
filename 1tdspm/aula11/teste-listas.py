# lista1 = []
# lista1  = list()
# indices 0  1  2
lista1 = [7, 6, 9]

lista1.append(8)
#  0  1  2  3
# [7, 6, 9, 8]

print( "Original: ", lista1 )

lista1[2] = 8.5

print( "Depois de alterar a nota: ", lista1 )

lista1.pop(1)

print( "Depois da remoção: ", lista1 )


'''
Exercicio, crie um programa que calcule 
a média aritmética das notas de um 
aluno.
O prgrama deve pedir para o usuário digitar
as notas 1, 2 e 3
O programa deve guardar estas notas 
em uma lista
Em seguida deve somar as notas e dividi-las
por 3 colocando a resposta na tela.
'''