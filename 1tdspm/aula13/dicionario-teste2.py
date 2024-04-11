d1 = {"nome": "Maria", "telefone": "(11) 1111-1111"}
d2 = {"nome": "Joao", "telefone": "(11) 2222-2222"}

lista = []
lista.append(d1)        # Adicionado no indice 0
lista.append(d2)        # Adicionado no indice 1

for i in range(0, 2):
    d = lista[i]
    print("Nome: ", d['nome'])
    print("Telefone: ", d['telefone'])