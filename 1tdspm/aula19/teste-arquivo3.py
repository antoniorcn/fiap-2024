# Fazer um programa para gravar nome e idade
# de 3 pessoas dentro de um arquivo chamado
# nomes-idades.txt
arq1 = open("d:\\temp\\teste6\\nomes-idades.csv", "w")
# CSV ==> Comma Separated Values
arq1.write("joao;(11)1111-1111;23\n")
arq1.write("maria;(11)2222-2222;24\n")
arq1.write("jose;(11)3333-3333;27\n")



arq1.close()