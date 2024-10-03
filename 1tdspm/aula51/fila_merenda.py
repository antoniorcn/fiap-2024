

casos_testes = int(input()) # numero de casos de teste
for caso in range(casos_testes):
    alunos_fila = int(input()) # Numero de alunos na fila
    notas_alunos = input()
    notas_lista = notas_alunos.split(" ")
    notas_lista_float = [float(nota_texto) for nota_texto in notas_lista]
    notas_lista_ordenada = sorted(notas_lista_float, reverse=True)
    # print("Notas Lista: ", notas_lista)
    # print("Notas Float: ", notas_lista_float)
    # print("Notas Ordenada: ", notas_lista_ordenada)
    contador = 0
    for i in range(len(notas_lista_float)):
        if notas_lista_float[i] == notas_lista_ordenada[i]:
            contador += 1
    print(f"{contador}")