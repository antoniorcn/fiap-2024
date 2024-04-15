lista = []
executando = True

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
        produto = {}
        produto["nome"] = input("Digite o nome do produto: ")
        produto["cor"] = input("Digite a cor do produto: ")
        produto["preco"] = float(input("Digite o preço do produto: "))
        produto["unidade_medida"] = input("Informe a unidade de medida: ")
        lista.append(produto)
    elif opcao == 'l':
        for p in lista:
            print("Produto: ", p["nome"])
            print(f"Cor: {p['cor']}   Preço: {p['preco']} {p['unidade_medida']}")
    elif opcao == 'p':
        print("Digite o nome do produto a ser pesquisado ==> ")
        n1 = input()
        for p in lista:
            if n1 == p["nome"]:
                print("Produto: ", p["nome"])
                print(f"Cor: {p['cor']}   Preço: {p['preco']} {p['unidade_medida']}")
    elif opcao == 's':
        print("\n\nObrigado por usar nosso sistema!")
        executando = False
    

