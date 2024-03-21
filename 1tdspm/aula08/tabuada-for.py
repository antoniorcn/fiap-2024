print("Programa da Tabuada")

print("Por favor digite um numero \
      para eu mostrar a tabuada dele")
numero = int(input())
         #     inicialização    termino     incremento
for i in range(1,               11,         1):
    res = numero * i
    print(f"{numero} X {i:>2} = {res:>2}")
