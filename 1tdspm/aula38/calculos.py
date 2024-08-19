def somar( n1, n2 ):
    soma = n1 + n2
    print("Soma realizada")
    return soma
def subtrair( n1, n2 ):
    subtracao = n1 - n2
    print("Subtracao realizada")
    return subtracao
if __name__ == "__main__":
    print("Digitar um numero: ")
    num1 = float(input())
    print("Digitar outro numero: ")
    num2 = float(input())
    s = somar(num1, num2)
    print("O resultado da soma é: ", s)

