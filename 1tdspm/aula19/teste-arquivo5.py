arq1 = open("D:/temp/teste6/nomes-idades.csv", "r")

lista = []
linha = "-"
while linha != "":
    linha = arq1.readline()
    linha = linha.replace("\n", "")
    # joao;(11)1111-1111;23
    #    0           1          2
    # ['joao    ', '(11)1111-1111, '23']
    if linha != "":
        dados = linha.split(";")
        print("Dados: ", dados)
        d = {
                # 'joao    '
                "nome": dados[0].strip(" "),
                # 'joao'
                "telefone": dados[1].strip(),
                "idade": int(dados[2].strip())
            }
        lista.append(d)
print(lista)

arq1.close()