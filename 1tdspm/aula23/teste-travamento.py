# progressão aritmetica
# PA(500) = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 ... 498 + 499 + 500
# numero_para_pa = 500
# pa = (numero_para_pa + 1) * (numero_para_pa / 2)

def trava( profundidade ):
    print(f"Executando a função trava na profundidade: {profundidade}")
    if profundidade > 1:
        trava( profundidade - 1 )

def progressao_aritmetica( valor_progressao ):
    if valor_progressao <= 1:
        return 1
    else:
        return valor_progressao + progressao_aritmetica(valor_progressao - 1)

# trava( 10 )
numero_para_pa = 100
resultado_pa = progressao_aritmetica( numero_para_pa )
pa = (numero_para_pa + 1) * (numero_para_pa / 2)
print("Resultado da PA (Recursividade): ", resultado_pa)
print("Resultado da PA (Formula): ", pa)