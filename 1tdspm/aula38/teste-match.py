print("M E N U  D E  O P Ç Õ E S")
print("(C)adastrar")
print("(M)ostrar")
print("(R)emover")
print("(A)tualizar")
print("(S)air")
temp_opcao = input("Por favor escolha sua opção: ")
opcao = temp_opcao.lower()[0]
match opcao:
    case 'c': 
        print("Você selecionou cadastrar")
    case 'm': 
        print("Você selecionou mostrar")
    case 'r': 
        print("Você selecionou remover")
    case 'a': 
        print("Você selecionou atualizar")
    case 's': 
        print("Você selecionou sair do sistema")
    case _: 
        print("Opção inválida")