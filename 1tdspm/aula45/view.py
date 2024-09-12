import os
from controller import Controller
from model import Contato
from datetime import datetime

class View:
    rodando = True
    def __init__(self):
        self.control = Controller()

    def ler_dados_contato(self):
        print("Digite as informações completas do contato")
        contato = Contato()
        contato.nome = input("Nome: ")
        contato.telefone = input("Telefone: ")
        contato.email = input("Email: ")
        str_nascimento = input("Nascimento: ")
        contato.nascimento = datetime.strptime(str_nascimento, "%d/%m/%Y")
        return contato

    def menu_principal(self):
        os.system("CLS")
        print("Agenda de Contato no Firebase")
        print("Menu Principal")
        print("(C)adastrar novo contato")
        print("(P)rocurar contatos existentes")
        print("(R)emover um contato especifico")
        print("(A)tualizar um contato especifico")
        print("(S)air do sistema")
        opcao = input("Por favor escolha uma opção e tecle <ENTER>: ")
        if len(opcao) > 0:
            opcao = opcao.upper()[0]
            match opcao:
                case 'C':
                    contato = self.ler_dados_contato()
                    self.control.cadastrar( contato )
                case 'P':
                    contatos = self.control.pesquisar()
                    for contato in contatos:
                        print("=" * 40)
                        print(contato)
                case 'R':
                    self.control.remover()
                case 'A':
                    self.control.atualizar()
                case 'S':
                    print("Obrigado por usar nosso sistema. Até Breve !!!")
                    self.rodando = False
                case _:
                    print("Opção inválida")
        else:
            print("Você precisa selecionar uma opção")

    def executar(self):
        while self.rodando:
            self.menu_principal()
            input("Tecle <ENTER> para continuar")
