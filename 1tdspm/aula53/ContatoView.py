import os
from ContatoControl import ContatoControl
from Contato import Contato

class ContatoView:

    def __init__(self):
        self.executando = True
        self.control = ContatoControl()

    def menu_principal(self):
        while self.executando:
            os.system("cls")
            print("""
                    M E N U   P R I N C I P A L
                    (C)adastrar
                    Pesquisar por (N)ome
                    (S)air
                    """)
            opcao = input("Por favor informe a opção desejada: ")
            if opcao != "" and len(opcao) > 0:
                escolha = opcao.upper()[0]
                if escolha == 'C':
                    self.cadastrar()
                elif escolha == 'N':
                    self.pesquisar_nome()
                elif escolha == 'S':
                    self.sair()
                else:
                    print("Por favor informe uma opção válida")
            if self.executando:
                input("Tecler <ENTER> para continuar")

    def pedir_dados_contato(self) -> Contato:
        contato = Contato()
        contato.nome = input("Por favor digite o nome completo:")
        contato.telefone = input("Informe o Telefone (DDD) Numero:")
        contato.email = input("Informe o email: ")
        return contato


    def cadastrar(self) -> None :
        print("Opção cadastrar selecionado")
        contato = self.pedir_dados_contato()
        gravado = self.control.gravar(contato)
        if gravado:
            print("Contato gravado com sucesso")
        else:
            print("Erro ao gravar o contato, por favor consulte o Administrador")

    def pesquisar_nome(self) -> None :
        print("Opção pesquisar por nome selecionado")
        nome = input("Por favor informe um nome ou parte dele para pesquisar:")
        contato = self.control.pesquisar_por_nome(nome)
        if contato != None:
            print("Contato encontrado: ", contato)
        else:
            print("Contato não foi encontrado")

    def sair(self) -> None :
        print("Opção sair selecionada")
        self.executando = False


# cv = ContatoView()
# cv.menu_principal()