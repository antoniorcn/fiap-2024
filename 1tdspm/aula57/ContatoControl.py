from Contato import Contato
# from ContatoRepositorioLista import ContatoRepositorioLista
from ContatoRepositorioDB import ContatoRepositorioDB
# from ContatoRepositorioAPIRest import ContatoRepositorioAPIRest

class ContatoControl:

    repositorio = ContatoRepositorioDB()

    def cadastrar(self, contato : Contato):
        return self.repositorio.cadastrar( contato )
    
    def pesquisar_por_nome(self, nome : str) -> list: 
        return self.repositorio.pesquisar_por_nome(nome)
    
    def atualizar(self, contato_id : int, contato : Contato):
        return self.repositorio.atualizar(contato_id, contato)
    
    def remover(self, contato_id : int):
        return self.repositorio.remover( contato_id )
