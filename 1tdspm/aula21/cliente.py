class Cliente:
    def __init__(self):
        self.nome = "desconhecido"
        self.cpf = ""
        self.idade = 0

    def comprar(self):
        print(f"{self.nome} com {self.idade} anos está comprando um produto")

    def trocar(self):
        print(f"{self.nome} trouxe um periferico para trocar")

    def reclamar(self):
        print(f"Eu {self.nome} CPF: {self.cpf} faço uma reclamação formal")