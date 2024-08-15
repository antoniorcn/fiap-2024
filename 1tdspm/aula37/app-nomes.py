from kivy.app import App
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.label import Label
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button

class AppNome( App ):

    txt_nome = TextInput(size_hint=(0.7, 1.0))
    txt_telefone = TextInput(size_hint=(0.7, 1.0))

    def submit(self, e):
        print("Botão pressionado")
        print(self.txt_nome.text)
        print(self.txt_telefone.text)

    def build(self):
        box = BoxLayout(orientation="vertical")
        box_nome = BoxLayout(orientation="horizontal",
                            size_hint = (1.0, 0.2))
        box_telefone = BoxLayout(orientation="horizontal",
                                size_hint=(1.0, 0.2))
        
        lbl_nome = Label(text="Nome:", 
                        size_hint = (0.3, 1.0))
        lbl_telefone = Label(text="Telefone: ", 
                            size_hint = (0.3, 1.0))
        
        btn_salvar = Button(text="Salvar", 
                           size_hint = (1, 1),
                           on_release = self.submit)
        
        box_nome.add_widget(lbl_nome)
        box_nome.add_widget(self.txt_nome)
        box_telefone.add_widget(lbl_telefone)
        box_telefone.add_widget(self.txt_telefone)
        box.add_widget(box_nome)
        box.add_widget(box_telefone)
        box.add_widget(btn_salvar)
        return box
    

if __name__ == "__main__":
    app = AppNome()
    app.run()
    # AppNome().run()
