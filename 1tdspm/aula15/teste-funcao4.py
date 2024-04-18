def area_retangulo( b, a = 1 ):
    """
        Calcular a area do Retangulo
        usando como formula area = base * altura
    """
    area = b * a
    return area, b, a

def area_triangulo( b = 1, a = 1 ):
    """
        Calcular a area do Triangulo
        usando como formula area = base * altura / 2
    """    
    area = b * a / 2
    return area, b, a

# Calcular area de retangulo
# base * altura

# Calcular area do triangulo retangulo
# base * altura / 2

print ("PROGRAMA PARA CALCULAR AREAS")

print("Informe o valor da base==>")
base = float(input())

print("Informe o valor da altura==>")
altura = float(input())

menu = """
Informe o tipo do objeto
(T)riangulo
(R)etangulo
"""
print(menu)
opcao = input().lower()[0]

if opcao == 't':
    # resultado, b1, a1 = area_triangulo( a=altura )
    # print("Base ==> ", b1)
    # print("Altura ==> ", a1)
    resultado, _, _ = area_triangulo(base)
elif opcao == 'r':
    # resultado, b1, a1 = area_retangulo( base )
    # print("Base ==> ", b1)
    # print("Altura ==> ", a1)
    resultado, _, _ = area_triangulo( a=altura )
print("Area é igual a ==> ", resultado)