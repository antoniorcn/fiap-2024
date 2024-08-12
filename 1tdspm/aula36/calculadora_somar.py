from kivy.app import App
from kivy.uix.label import Label
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
from kivy.uix.boxlayout import BoxLayout
class CalculadoraSoma(App):
    def build(self):
        box = BoxLayout(orientation='vertical')
        lbl_numero1 = Label(text="Digite o 1o numero")
        txt_numero1 = TextInput()
        lbl_numero2 = Label(text="Digite o 2o numero")
        txt_numero2 = TextInput()
        btn_somar = Button(text="Somar")
        box.add_widget(lbl_numero1)
        box.add_widget(txt_numero1)
        box.add_widget(lbl_numero2)
        box.add_widget(txt_numero2)
        box.add_widget(btn_somar)
        return box
obj_calculadora_soma = CalculadoraSoma()
obj_calculadora_soma.run()

