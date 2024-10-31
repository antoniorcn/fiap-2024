import json
import requests

class Acessorio:
    nome : str = ""
    modelo : str = ""
    preco : float = 0.0

    def __init__(self, nome : str = "",
                 modelo : str = "",
                 preco : float = ""):
        self.nome = nome
        self.modelo = modelo
        self.preco = preco

    def to_dict(self) -> dict:
        d = {"nome": self.nome, 
             "modelo": self.modelo,
             "preco": self.preco}
        return d
    
    def from_dict(self, dicionario : dict):
        self.nome = dicionario.get("nome", "")
        self.modelo = dicionario.get("modelo", "")
        self.preco = dicionario.get("preco", 0.0)

    def __str__(self) -> str:
        return f"""Nome: {self.nome}\t
        Modelo: {self.modelo}\tPreço: {self.preco}"""

class Apresentacao: 

    def menu_principal(self):
        while True:
            print("(C) - Cadastrar")
            print("(L) – Ler Todos")
            print("(S) - Sair")
            opcao = input("Digite sua opção-->")
            if opcao != "" and len(opcao) > 0:
                choice = opcao[0].upper()
                match choice:
                    case "C": self.cadastrar()
                    case "L": self.ler_todos()
                    case "S": self.exit()
                    case _:
                        print("Opção inválida")
            input("Tecle <ENTER> para continuar")
    

    def cadastrar(self):
        """O método cadastrar() deve gerar um objeto do tipo do modelo 
        mostrado na descrição da aplicação, Solicite que o usuário digite 
        as informações colocando-as nos atributos do objeto criado, 
        e validando para não aceitar dados em branco"""
        status_ok = False
        while not status_ok:
            try:
                acessorio = Acessorio()
                nome = input("Por favor informe o nome do Acessorio: ")
                modelo = input("Informe o modelo do acessorio: ")
                preco = float(input("Informe o preço do acessorio: "))
                acessorio.nome = nome
                acessorio.modelo = modelo
                acessorio.preco = preco
                status_ok = True
            except ValueError:
                print("Erro, por favor digite os dados novamente")


class Repositorio:
    def __init__(self):
        self.URL_BASE = "https://fiap.firebaseio.com"
        self.lista = []    

    def gravar(self, acessorio : Acessorio):
        """
        Crie um método chamado gravar( acessorio : Acessorio ) 
        deve transformar o objeto recebido como parâmetro 
        em um texto JSON em seguida deve encaminhar um 
        request do tipo POST para o recurso chamado 
        '/acessorios.json' se o status_code da resposta 
        for 200 então o método deverá retornar True 
        caso contrário deverá retornar False
        """
        dicionario = acessorio.to_dict()
        acessorioJson = json.dumps(dicionario)
        resposta = requests.post(f"{self.URL_BASE}/acessorios.json",
                                 json=acessorioJson,
                                 timeout=5)
        return resposta.status_code == 200

    def ler_todos(self):
        """
        Crie um método chamado ler_todos() deve encaminhar um request
        do tipo GET para o recurso chamado "/acessorios.json", 
        ler o corpo da resposta e transforma-lo em um dicionário. 
        Em seguida deve iterar no dicionário gerando um objeto para 
        cada value e adicionando-o na lista gerada na instância
        """

        resposta = requests.get(f"{self.URL_BASE}/acessorios.json", timeout=5)
        if resposta.status_code == 200:
            dicionario = json.loads(resposta.json)
            for chave in dicionario.keys():
                acessorioDict = dicionario[chave]
                acessorio = Acessorio()
                acessorio.from_dict( acessorioDict )
                self.lista.append( acessorio )
