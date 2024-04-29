import os

lista = []
def menu_principal():
    print("MENU PRINCIPAL")
    print("(C) Cadastrar")
    print("(L) Listar")
    print("(P) Procurar")
    print("(B) Backup em um arquivo")
    print("(R) Restaurar de um arquivo")
    print("(S) Sair")
    print("Por favor escolha sua opção ==> ")
    opcao = input()
    return opcao


def cadastrar_contato():
    print("Cadastro de contato")
    print("Digite o nome completo do contato: ")
    nome = input()
    print("Informe o Telefone do contato: ")
    telefone = input()
    print("Informe o E-Mail do contato: ")
    email = input()
    print("Informe o Peso do contato: ")
    peso = float(input())
    d = {"nome": nome, "telefone": telefone, "email": email, "peso": peso}
    return d


def listar_contatos(  lista_contato ):
    indice = 0
    while indice < len(lista_contato):
        contato = lista_contato[indice]
        print("Nome\t\tTelefone\t\tEmail\t\tPeso")
        print(f"{contato['nome']}\t\t{contato['telefone']}\t\t" + \
              f"{contato['email']}\t\t{contato['peso']}")
        indice = indice + 1
    print("Tecle <ENTER> para continuar")
    input()


def procurar_contato( lista_contato ):
    print("Procurar contato:")
    print("Informe o email para pesquisar: ")
    email = input()
    indice = 0
    while indice < len(lista_contato):
        contato = lista_contato[indice]
        if contato["email"] == email:
            print("Nome\t\tTelefone\t\tEmail\t\tPeso")
            print(f"{contato['nome']}\t\t{contato['telefone']}\t\t" + 
                  f"{contato['email']}\t\t{contato['peso']}")
            
            print("MENU DE OPCOES PARA CONTATO")
            print("(R)emover o contato")
            print("(A)lterar o contato")
            print("(V)oltar para o menu principal")
            print("Por favor escolha sua opcao ==> ")
            opcao = input()
            if opcao == 'R':
                del lista_contato[indice]
            elif opcao == 'A':
                print("Alterar contato")
                print("Digite o nome completo do contato: ")
                nome = input()
                print("Informe o Telefone do contato: ")
                telefone = input()
                print("Informe o E-Mail do contato: ")
                email = input()
                print("Informe o Peso do contato: ")
                peso = float(input())
                d = {"nome": nome, "telefone": telefone, "email": email, "peso": peso}
                lista_contato[indice] = d

        indice = indice + 1

def backup( lista_contato ): 
    arq1 = open("./contatos.csv", "w")
    indice = 0
    while indice < len(lista_contato):
        contato = lista_contato[indice]
        arq1.write(f"'{contato['nome']}';'{contato['telefone']}';" + 
                  f"'{contato['email']}';{contato['peso']}\n")
        indice = indice + 1
    arq1.close()

def restaurar( lista_contato ): 
    arq1 = open("./contatos.csv", "r")
    lista_contato.clear()
    linha = "-"
    while linha != "":
        contato = {}
        linha = arq1.readline()
        colunas = linha.split(";")
        contato['nome'] = colunas[0].strip(" ").replace(";", "")
        contato['email'] = colunas[1].strip(" ").replace(";", "")
        contato['peso'] = colunas[2].strip(" ").replace(";", "")
        contato['telefone'] = colunas[3].strip(" ").replace("\n", "")
        lista_contato.append(contato)
    arq1.close()


rodando = True
while rodando:
    os.system("CLS") 
    print("Programa de Gestão de Contatos")
    letra = menu_principal()
    if letra == 'C':
        contato = cadastrar_contato()
        lista.append( contato )
    elif letra == 'L':
        listar_contatos( lista )
    elif letra == 'P':
        procurar_contato( lista )
    elif letra == 'B':
        backup( lista )
    elif letra == 'R':
        restaurar( lista )
    elif letra == 'S':
        print("Até breve")
        rodando = False

print("Programa encerrado")