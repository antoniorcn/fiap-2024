lista = []
executando = True


def gravar_lista():
    produto = {}
    produto["nome"] = input("Digite o nome do produto: ")
    produto["cor"] = input("Digite a cor do produto: ")
    produto["preco"] = float(input("Digite o preço do produto: "))
    produto["unidade_medida"] = input("Informe a unidade de medida: ")
    lista.append(produto)


def exibir_produto( produto ):
    print(f"Produto: {produto['nome']} Cor: {produto['cor']}", )
    print(f"Preço: {produto['preco']} {produto['unidade_medida']}")


def mostrar_lista():
    for p in lista:
        exibir_produto( p )        


def pesquisar_lista( nome ):
    for p in lista:
        if nome == p["nome"]:
            return p
    return None
            

def sair():
    print("\n\nObrigado por usar nosso sistema!")
    executando = False


while executando:
    menu = '''
        S I S T E M A   P A R A   H O R T - F R U T
        (A)dicionar um novo produto
        (L)istar todos os produtos
        (P)esquisar por um produto específico
        (S)air do sistema
        \n\n\n
        Digite sua opção ==> 
    '''

    print(menu)
    opcao = input().lower()[0]
    
    if opcao == 'a':
        gravar_lista()
    elif opcao == 'l':
        mostrar_lista()
    elif opcao == 'p':
        print("Digite o nome do produto a ser pesquisado ==> ")
        n1 = input()
        produto = pesquisar_lista( n1 )
        if produto is not None:
            exibir_produto( produto )
    elif opcao == 's':
        sair()
    

