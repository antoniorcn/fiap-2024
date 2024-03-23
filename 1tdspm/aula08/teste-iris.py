print("Programa nota")
 
print("Digite o nome do aluno")
nome = input()
 
print("Digite 3 notas")
executar = True
while executar:
  nota1 = float(input())
  nota2 = float(input())
  nota3 = float(input())
  res = (nota1 + nota2 + nota3) / 3
  print("Nome       Nota 1    Nota2    Nota 3     Média")
  print(f"{nome:<12}{nota1:<10}{nota2:<10}{nota3:<10}{res}")
 
print("Deseja calcular a média de outro estudante (S/N) ?")
escolha = input()
if escolha == 'N' or escolha == 'n':
  escolha = False
 
print("Fim do programa")