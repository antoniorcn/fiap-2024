from datetime import datetime


class Contato:
    """
        Classe que descreve os objetos do tipo Contato
    """
    def __init__(self, contato_id="", nome="", telefone="",
                 email="", nascimento=datetime.now):
        self.contato_id = contato_id
        self.nome = nome
        self.telefone = telefone
        self.email = email
        self.nascimento = nascimento

    def __str__(self):
        return f"""({self.contato_id}) - {self.nome}
                    {self.email}
                    {self.telefone}
                    {self.nascimento.strftime("%d/%m/%Y")}"""



if __name__=="__main__":
    temp_nascimento = datetime.strptime("01/04/2003", "%d/%m/%Y")
    c1 = Contato("0001", "Joao Silva", "(11) 111-111",
                 "joao@teste.com", temp_nascimento)
    print("Contato: ", c1)
