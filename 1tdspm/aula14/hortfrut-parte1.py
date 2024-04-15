lista = []

for i in range(3):
    produto = {}
    # nome = input("Digite o nome do produto: ")
    # produto["nome"] = nome
    produto["nome"] = input("Digite o nome do produto: ")
    produto["cor"] = input("Digite a cor do produto: ")
    produto["preco"] = float(input("Digite o preço do produto: "))
    produto["unidade_medida"] = input("Informe a unidade de medida: ")

    lista.append(produto)

for p in lista:
    print("Produto: ", p["nome"])
    print(f"Cor: {p['cor']}   Preço: {p['preco']} {p['unidade_medida']}")

