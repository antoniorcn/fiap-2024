agenda = []

print("Digite o nome de um arquivo")
nome_arquivo = input()

arquivo = open(nome_arquivo, "r", encoding="utf-8")

num_linha = 1
while True:
    linha = arquivo.readline()
    if linha != "":
        # if num_linha > 1:
        linha = linha.replace("\n", "")
        lista = linha.split(";")
        contato = {}
        contato['nome'] = lista[0]
        contato['telefone'] = lista[1]
        contato['email'] = lista[2]
        agenda.append(contato)
        # print(f"Linha: {num_linha} - [{linha}]")
    else:
        break
    num_linha += 1
# agenda.pop(0)
agenda = [elemento for elemento in agenda[1:]] 

print(agenda)
arquivo.close()