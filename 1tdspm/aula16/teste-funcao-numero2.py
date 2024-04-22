def recebe_numero( texto="Digite um numero:" ):
    """
        Função utilizada para pedir numero inteiro, 
        e verifica se o valor digitado é um número válido
    """
    valido = False
    while not valido:
        print(texto)
        digitado = input()
        try:
            numero = int(digitado)
            valido = True
        except:
            print("Numero invalido")
    return numero

print("Inicio do programa")
n1 = recebe_numero("Digite o 1º numero: ")
n2 = recebe_numero("Digite o 2º numero: ")
soma = n1 + n2
print("A soma dos dois números é: ", soma)
print("Termino do programa")



