from kivy.app import App
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.label import Label
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
from kivy.config import Config

class AppAgenda( App ):

    agenda = []

    contato_atual = None

    txt_nome = TextInput(size_hint=(0.7, 1.0))
    txt_telefone = TextInput(size_hint=(0.7, 1.0))
    txt_email = TextInput(size_hint=(0.7, 1.0))
    txt_nascimento = TextInput(size_hint=(0.7, 1.0))

    def __init__(self):
        App.__init__(self)
        Config.set('input', 'mouse', 'mouse,multitouch_on_demand')

    def salvar(self, e):
        print("Botão pressionado")
        obj_contato = {"nome": self.txt_nome.text,
                       "telefone": self.txt_telefone.text,
                       "email": self.txt_email.text,
                       "nascimento": self.txt_nascimento.text}
        if self.contato_atual is not None:
            self.agenda.remove(self.contato_atual)
            self.contato_atual = None
        self.agenda.append( obj_contato )
        self.txt_nome.text = ""
        self.txt_telefone.text = ""
        self.txt_email.text = ""
        self.txt_nascimento.text = ""
        print(self.agenda)
    
    def pesquisar(self, e): 
        for contato in self.agenda:
            if self.txt_nome.text.lower() in contato["nome"].lower():
                self.contato_atual = contato
                self.txt_nome.text = contato["nome"]
                self.txt_telefone.text = contato["telefone"]
                self.txt_email.text = contato["email"]
                self.txt_nascimento.text = contato["nascimento"]

    def informacoes(self):
        print("App Agenda de Contato")

    def build(self):
        box = BoxLayout(orientation="vertical")
        box_nome = BoxLayout(orientation="horizontal",
                            size_hint = (1.0, 0.2))
        box_telefone = BoxLayout(orientation="horizontal",
                                size_hint=(1.0, 0.2))
        box_email = BoxLayout(orientation="horizontal",
                              size_hint = (1.0, 0.2))
        box_nascimento = BoxLayout(orientation="horizontal",
                                   size_hint=(1.0, 0.2))
        box_botoes = BoxLayout(orientation="horizontal",
                               size_hint=(1.0, 0.2))
        lbl_nome = Label(text="Nome:", 
                        size_hint = (0.3, 1.0))
        lbl_telefone = Label(text="Telefone: ", 
                            size_hint = (0.3, 1.0))
        lbl_email = Label(text="Email: ",
                          size_hint = (0.3, 1.0))
        lbl_nascimento = Label(text="Data Nascimento:",
                               size_hint=(0.3, 1.0))
        
        btn_salvar = Button(text="Salvar", 
                           size_hint = (0.5, 1),
                           on_release = self.salvar)
        btn_pesquisar = Button(text="Pesquisar", 
                           size_hint = (0.5, 1),
                           on_release = self.pesquisar)
        
        box_nome.add_widget(lbl_nome)
        box_nome.add_widget(self.txt_nome)
        box_telefone.add_widget(lbl_telefone)
        box_telefone.add_widget(self.txt_telefone)
        box_email.add_widget(lbl_email)
        box_email.add_widget(self.txt_email)
        box_nascimento.add_widget(lbl_nascimento)
        box_nascimento.add_widget(self.txt_nascimento)
        box_botoes.add_widget(btn_salvar)
        box_botoes.add_widget(btn_pesquisar)
        box.add_widget(box_nome)
        box.add_widget(box_telefone)
        box.add_widget(box_email)
        box.add_widget(box_nascimento)
        box.add_widget(box_botoes)
        return box
    

if __name__ == "__main__":
    app = AppAgenda()
    app.informacoes()
    app.run()
    # AppAgenda().run()
