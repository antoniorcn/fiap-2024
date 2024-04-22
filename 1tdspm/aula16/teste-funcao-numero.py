texto = "digite um numero"
valido = False
while not valido:
    print(texto)
    digitado = input()
    try:
        numero = int(digitado)
        valido = True
    except:
        print("Numero invalido")
print("Numero digitado: ", numero)
