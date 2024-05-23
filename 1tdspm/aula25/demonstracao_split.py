agenda = []

linha = "Maria Silva;(11) 2222-2222;maria@teste.com"
lista = linha.split(";")
#      0  - nome      1 - telefone      2 - email
#  ['Maria Silva', '(11) 2222-2222', 'maria@teste.com']
 
contato = {}
contato['nome'] = lista[0]
contato['telefone'] = lista[1]
contato['email'] = lista[2]

agenda.append(contato)

linha = "Rodrigo Alberto;(11) 3333-3333;rodrigo@teste.com"
lista = linha.split(";")
contato = {}
contato['nome'] = lista[0]
contato['telefone'] = lista[1]
contato['email'] = lista[2]
agenda.append(contato)


print(agenda)