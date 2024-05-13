from carro import Carro, Pneu

lista_carros = []
executando = True

while executando: 
    print("Concessionaria de Veiculos")
    print("(C)adastrar novo carro")
    print("(L)istar carros")
    print("(S)air")
    print("Escolha a opção ==>:")
    opcao = input().lower()[0]

    if opcao == 'c':
        print("Criar Novo Carro: ")
        print("Informe a marca: ")
        marca = input()
        print("Informe o modelo: ")
        modelo = input()

        c1 = Carro(marca, modelo)
        # c1 = Carro()
        # c1.marca = marca
        # c1.modelo = modelo

        lista_carros.append( c1 )
    elif opcao == 'l':
        for carro in lista_carros:
            carro.situacao()
    elif opcao == 's':
        print("Até breve")
        executando = False