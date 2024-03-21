print("Programa da Tabuada")

print("Por favor digite um numero \
      para eu mostrar a tabuada dele")
numero = int(input())

i = 1   # Inicialização

while i <= 10:      # Condição
    res = numero * i
    print(f"{numero} X {i:>2} = {res:>2}")
    i = i + 1   # Incremento
# 8 X 1 = 8
# 8 X 2 = 16
# ...
# 8 X 10 = 80