from kivy.app import App
from kivy.uix.label import Label
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.textinput import TextInput
class AppExample( App ):
    def build(self):
        box = BoxLayout(orientation="vertical")
        lbl_nome = Label(text="Nome:")        
        txt_nome = TextInput()
        box.add_widget(lbl_nome)
        box.add_widget(txt_nome)        
        return box
if __name__ == "__main__":
    AppExample().run()