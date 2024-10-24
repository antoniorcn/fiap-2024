import os
from Contato import Contato
from ContatoControl import ContatoControl

class ContatoBoundary:

    control = ContatoControl()

    def __init__(self):
        pass

    def cadastrar(self):
        contato = self.pegar_dados_contato()
        self.control.cadastrar(contato)

    def pesquisar(self):
        nome = input("Informe o nome do contato a ser pesquisado: ")
        lista_contatos = self.control.pesquisar_por_nome(nome)
        for contato in lista_contatos:
            print(contato)
            print("-"*80)

    def atualizar(self):
        contato_id = input("Informe o id do contato a ser atualizado: ")
        print("Informe os dados do contato para sobreescrever")
        contato = self.pegar_dados_contato()
        self.control.atualizar(contato_id, contato)

    def remover(self):
        contato_id = input("Informe o id do contato a ser removido: ")
        self.control.remover(contato_id)

    def pegar_dados_contato(self):
        contato = Contato()
        valido = False
        while not valido:
            contato.nome = input("Digite o nome do contato: ")
            contato.email = input("Digite o email do contato: ")
            contato.telefone = input("Digite o telefone do contato: ")
            if contato.nome == "" or\
                contato.email == "" or\
                contato.telefone == "":
                print("Os dados precisam ser preenchidos")
                input("Tecle <ENTER> para continuar")
            else:
                valido = True
        return contato

    def mostrar_menu(self):
        opcao_valida = False
        while not opcao_valida:
            os.system("cls")
            print("M E N U  -  C O N T A T O S")
            print("(C)adastrar um novo contato")
            print("(P)esquisar contatos pelo nome")
            print("(R)emover contato pelo nome")
            print("(A)tualizar contato pelo nome")
            opcao = input("Informe sua opção ==>")
            if opcao is None or opcao == "" or len(opcao) < 1:
                print("Opção inválida")
            else:
                escolha = opcao[0].upper()
                match (escolha):
                    case 'C': self.cadastrar()
                    case 'P': self.pesquisar()
                    case 'R': self.remover()
                    case 'A': self.atualizar()
                    case _:
                        print("Escolha inválida")
            input("Tecle <ENTER> para continuar")