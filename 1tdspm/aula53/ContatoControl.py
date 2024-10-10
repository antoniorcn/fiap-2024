from Contato import Contato
from ContatoService import ContatoService

class ContatoControl:
    def __init__(self):
        self.service = ContatoService()
        self.lista = []
        self.ler_todos()

    def gravar(self, contato : Contato) -> bool:
        cadastrado = self.service.salvar(contato)
        self.ler_todos()
        return cadastrado

    def ler_todos(self) -> None:
        self.lista = self.service.ler_todos()

    def pesquisar_por_nome(self, parte_nome : str) -> Contato:
        for contato in self.lista:
            if parte_nome in contato.nome:
                return contato
        return None