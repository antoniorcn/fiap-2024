import numpy as np
contador = 1
class No: 
    A = np.zeros((1000, 1000, 1000, 100))
    proximo = None
if __name__ == "__main__":
    raiz = No()
    temp = raiz
    while True:
        print("Contador: ", contador)
        contador += 1
        outro = No()
        temp.proximo = outro
        temp = outro
    