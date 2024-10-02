package edu.curso.listacompras

data class Item(
    var id : Long=0,
    var nome : String = "",
    var preco : Double = 0.0,
    var quantidade : Int = 0   // UInt => U -> Unsigned
)

val item = Item(nome="Coca cola 2L")

