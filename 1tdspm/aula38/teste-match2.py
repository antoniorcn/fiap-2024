lista = ['Bom', 'Dia', 'joao', 'maria', 'jose', 'sara']

match lista:
    case [saudacao, periodo, *nomes]: 
        for nome in nomes:
            print(saudacao, periodo, nome)         