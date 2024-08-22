from kivymd.app import MDApp
from kivy_garden.mapview import MapView

class TesteMap(MDApp): 
    def build(self):
        return MapView(zoom=20, lat=-23.563100880255938, lon=-46.65251524512608)

if __name__=="__main__":
    TesteMap().run()

