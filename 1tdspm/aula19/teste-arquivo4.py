# Faça um programa para ler o conteudo do arquivo
# nomes-idades.csv mostrando cada linha lida 
# na console

arq1 = open("D:/temp/teste6/nomes-idades.csv", "r")

lista = []
linha = "-"
while linha != "":
    linha = arq1.readline()
    linha = linha.replace("\n", "")
    if linha != "":
        lista.append(linha)
# lista.pop(-1)

print("Linhas: ", lista)

# texto = arq1.read()
# print("Texto: ", texto)

# linha1 = arq1.readline()
# linha1 = linha1.replace("\n", "")
# print("Linha1: ", linha1)
# linha2 = arq1.readline()
# linha2 = linha2.replace("\n", "")
# print("Linha2: ", linha2)
# linha3 = arq1.readline()
# linha3 = linha3.replace("\n", "")
# print("Linha3: ", linha3)

arq1.close()