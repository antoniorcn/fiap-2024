lancamentos = [
    {"lancamento": "Pagamento recebido", "valor": 2419.35},
    {"lancamento": "Posto Shell", "valor": 55.00},
    {"lancamento": "Mc Donalds", "valor": 38.99}
]

for lancamento in lancamentos:
    print("{0:.<50}  R$ {1:<6.1f}".format(lancamento['lancamento'], lancamento['valor']))
    # print(f"{lancamento['lancamento']}\t\tR$ {lancamento['valor']}")
    # print(lancamento['lancamento'], "\t\t", lancamento['valor'])
