#        0  1  2  3   4   5   6   7   8   9
lista = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

sub_lista = lista[4:8]
   #    inicio  :   termino    :   passo         
lista[   4      :      8       :      1   ]

sub_lista2 = lista[0:10:2]
sub_lista3 = lista[7:3:-1]
# sub_lista4 = lista[9::-1]
sub_lista4 = lista[::-1]

print(lista)
print(sub_lista)
print(sub_lista2)
print(sub_lista3)
print(sub_lista4)