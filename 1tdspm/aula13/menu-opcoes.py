'''
M E N U  P R I N C I P A L

Cadastrar Nova (B)icicleta
Cadastrar (U)suario
(C)alcular seguro
(L)istar Usuarios
Listar B(I)cicletas
'''
print("Inicio do Programa")
executar = True
while executar:
    print("M E N U  P R I N C I P A L")
    print("\n\n")
    print("Cadastrar Nova (B)icicleta")
    print("Cadastrar (U)suario")
    print("(C)alcular seguro")
    print("(L)istar Usuarios")
    print("Listar B(I)cicletas")
    print("(S)air")

    print("Informe a opção desejada: ")
    # 'Sair' ==> 'SAIR' ==> 'S'
    # 0123
    # Sair
    opcao = input().upper()[0]
    if opcao == "B":
        print("Voce escolheu a opção Cadastrar Bicicleta")
    elif opcao == "U": 
        print("Voce escolheu a opção Cadastrar Usuairo")
    elif opcao == "C":
        print("Voce escolheu a opção Calcular o seguro")
    elif opcao == "L":
        print("Voce escolheu a opção Listar Usuarios")
    elif opcao == "I":
        print("Voce escolheu a opção Listar Bicicletas")
    elif opcao == "S":
        print("Até breve")
        executar = False
    else: 
        print("Opção inválida por favor escolha outra")

print("Fim do Programa")