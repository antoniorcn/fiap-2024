def menu_principal():
    print("SISTEMA DE GESTÃO PARA HORTIFRUTI")
    print("MENU PRINCIPAL")
    print("(C)adastrar um produto")
    print("(L)istar os produtos")
    print("(G)ravar a lista em arquivo CSV")
    print("Le(R) a lista do arquivo CSV")
    print("(S)air do sistema")


def solicita_opcao():
    print("Escolha sua opcao: ")
    return input().lower()[0]


def produto_cadastrar( lista_produto ):
    produto = {}
    print("Digite o nome do produto: ")
    produto["nome"] = input()
    print("Digite a cor do produto: ")
    produto["cor"] = input()
    print("Digite o preço do produto: ")
    produto["preco"] = float(input())
    print("Digite a unidade de medida do produto: ")
    produto["unidade_medida"] = input()
    lista_produto.append( produto )


def produto_listar( lista_produto ):
    for p in lista_produto:
        print(f"Nome Produto: {p['nome']}\tCor: {p['cor']}")
        print(f"Preço: {p['preco']:.2f}\tUnidade de Medida: {p['unidade_medida']}")
        print("-"*60)


def gravar_arquivo( lista_produto ):
    arq1 = open("./hortfrut.csv", "w", encoding="utf-8")
    arq1.write("Nome Produto, Cor, Preco, Unidade de Medida\n")
    for p in lista_produto:
        arq1.write(f"{p['nome']}, {p['cor']}, {p['preco']:.2f}, {p['unidade_medida']}\n")
    arq1.close()


def ler_arquivo( lista_produto ):
    lista_produto.clear()
    arq1 = open("./hortfrut.csv", "r", encoding="utf-8")
    linha = "-"
    indice = 0
    while linha != "":
        linha = arq1.readline()
        if linha != "" and indice > 0:
            campos = linha.split(",")
            produto = {}
            produto["nome"] = campos[0].strip()
            produto["cor"] = campos[1].strip()
            produto["preco"] = float(campos[2].strip())
            produto["unidade_medida"] = campos[3].strip()
            lista_produto.append(produto)
        indice = indice + 1



# Trecho do programa principal
lista = []
executando = True 

while executando:
    menu_principal()
    opcao = solicita_opcao()
    if opcao == 'c':
        produto_cadastrar( lista )
    elif opcao == 'g':
        gravar_arquivo( lista )
    elif opcao == 'r':
        ler_arquivo( lista )
    elif opcao == 'l':
        produto_listar( lista )
    elif opcao == 's':
        print("Obrigado por usar o sistema, até breve")
        executando = False

print("Fim do programa")