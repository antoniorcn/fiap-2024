from modelo import Contato
from controle import Controle
import os

class Visualizacao:
    def __init__(self) -> None:
        self.controle = Controle()

    def criar_contato(self) -> Contato:
        c = Contato()
        print("")
        c.nome = input("Informe o Nome Completo do contato: ")
        c.telefone = input("Informe o Telefone do contato: ")
        c.email = input("Informe o eMail do contato: ")
        return c
    
    def mostrar_contatos(self, lista_contatos : list) -> None:
        for contato in lista_contatos:
            print("-"*40)
            print(contato)

    def ler_id_contato(self) -> int:
        numero = -1
        while numero == -1:
            str_contato_id = input("Digite um id de contato válido: ")
            if len(str_contato_id) > 0 and str_contato_id.isnumeric():
                numero = int(str_contato_id)
            else:
                input("Número digitado não é um id válido. Tecler <ENTER> para continuar")
        return numero
            

    def menu_principal(self) -> None:
        os.system("cls")
        print("A G E N D A   D E   C O N T A T O S")
        print("(C)adastrar um contato")
        print("(P)esquisar contatos")
        print("(R)emover um contato")
        print("(A)tualizar um contato")
        print("(G)erar tabela de dados")
        print("(S)air")
        entrada = input("Por favor escolha uma opção: ")
        if (len(entrada) > 0):
            opcao = entrada.upper()[0]
            match (opcao):
                case 'C':
                    c1 = self.criar_contato()
                    self.controle.salvar(c1)
                case 'P':
                    nome = input("Digite um nome para pesquisar: ")
                    lista_contatos = self.controle.pesquisar( nome )
                    self.mostrar_contatos(lista_contatos)
                case 'R':
                    contato_id = self.ler_id_contato()
                    self.controle.apagar( contato_id )
                case 'A':
                    contato_id = self.ler_id_contato()
                    print("Agora digite os novos valores para o Contato")
                    c1 = self.criar_contato()
                    self.controle.atualizar(contato_id, c1)
                case 'G':
                    self.controle.gerar_tabela()
                case 'S':
                    print("Até breve")
                    exit()

if __name__ == "__main__":
    vis = Visualizacao()

    while True:
        vis.menu_principal()
        input("Tecle <ENTER> para continuar")