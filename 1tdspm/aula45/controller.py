from servico import Servico

class Controller:
    def __init__(self):
        self.servico = Servico()

    def cadastrar(self, contato):
        print("Cadastrando o contato")
        response = self.servico.cadastrar_firebase( contato )
        print("Response: ", response)

    def pesquisar(self):
        print("Pesquisar contatos")

    def remover(self):
        print("Remover um contato especifico")

    def atualizar(self):
        print("Atualizar um contato especifico")

    def sair(self):
        pass