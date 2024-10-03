animais = {
    "vertebrado": {
        "ave": {
                "carnivoro" : "aguia",
                "onivoro": "pomba"
                }, 
        "mamifero": {
                "onivoro": "homem",
                "herbivoro": "vaca"
                }
        },
    "invertebrado": {
        "inseto" : {
                "hematofago": "pulga",
                "herbivoro": "lagarta"
                },
        "anelideo": {
                "hematofago": "sanguessuga",
                "onivoro": "minhoca"
                }
        }
}

def procurar( palavra1 : str, palavra2 : str, palavra3 : str ) -> str:
    global animais
    valor = ""
    nivel2 = animais.get(palavra1, "")
    if type(nivel2) is dict:
        nivel3 = nivel2.get(palavra2, "")
        if type(nivel3) is dict:
            valor = nivel3.get(palavra3, "")
    return valor


palavra1 = input()
palavra2 = input()
palavra3 = input()
print(procurar(palavra1, palavra2, palavra3))