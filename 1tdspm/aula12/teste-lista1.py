lista = ["Pedro", "João", "Maria", "Pedro"] 
print("Lista Original: ", lista)

lista.append("José")
print("Lista com José: ", lista)

tamanho = len(lista)
print("Tamanho: ", tamanho)

lista.insert(1, "Matheus")
tamanho = len(lista)
print("Lista com Matheus: ", lista)

nome = lista.pop(3)
print("Lista sem a Maria: ", lista)

print("Tamanho: ", tamanho)
pedros = lista.count("Pedro")
print(f"Há {pedros} Pedros na lista")
lista.remove("Pedro")
print("Lista sem o Pedro: ", lista)