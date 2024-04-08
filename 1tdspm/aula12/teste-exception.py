try:
    n1 = float(input("Digite um numero: "))
    n2 = float(input("Digite outro numero: "))
    resultado = n1/n2
    print(f"A divisão de {n1} por {n2} é igual a {resultado}")
except ValueError as err:
    print("Erro! Digite um numero válido")
except ZeroDivisionError as err:
    print("Erro! O segundo numero precisa ser diferente de 0.0")
except:
    print("Erro! Não foi possivel executar a divisão")