def somar( n1, n2 ):
    s = n1 + n2
    print( "Soma: ", s )
    return s
def dividir( n1, n2 ):
    r = n1 / n2
    print( "Divisao: ", r)
    return r
numero1 = int(input("Informe um numero"))
numero2 = int(input("Informe outro numero"))
soma = somar(numero1, numero2)
resultado = dividir(soma, 2)
