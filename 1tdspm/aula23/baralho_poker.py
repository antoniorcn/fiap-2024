from random import sample
baralho_poker = list(range(1, 14))
mao = sample(baralho_poker, 5)
print("Monte: ", baralho_poker)
print("Mão: ", mao )

# for carta in mao:
#    baralho_poker.remove(carta)
cartas = baralho_poker - mao

print("Monte: ", cartas)
print("Mão: ", mao )