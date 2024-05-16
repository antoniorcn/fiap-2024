from random import sample, randrange, randint

lista = [10, 20, 60, 80, 90, 1000, 40]
sample_list = sample( lista, 3 )

print("RandRange: ", randrange(1, 10, 3))
print("RandInt: ", randint(1, 10) )
print("Sample List: ", sample_list )