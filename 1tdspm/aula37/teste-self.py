class Pessoa:
    nome = ""
    sobrenome = ""

    def imprimir(self):
        print(f"Nome: {self.nome}\t\tSobrenome: {self.sobrenome}")



p1 = Pessoa()
p1.nome = "Joao"
p1.sobrenome = "Silva"
p1.imprimir()
# print(f"Nome: {p1.nome}\t\tSobrenome: {p1.sobrenome}")

p2 = Pessoa()
p2.nome = "Maria"
p2.sobrenome = "Silva"
p2.imprimir()
# print(f"Nome: {p2.nome}\t\tSobrenome: {p2.sobrenome}")