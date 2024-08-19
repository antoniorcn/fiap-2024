contador = 0

def consumir():
    global contador
    contador = contador + 1
    print("Executando consumir: ", contador)
    consumir()


consumir()