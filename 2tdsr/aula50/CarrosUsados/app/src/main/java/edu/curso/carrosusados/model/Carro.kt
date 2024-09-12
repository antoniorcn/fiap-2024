package edu.curso.carrosusados.model

/*
    marca: String
	modelo: String
	placa : String
	ano : Int
 */
data class Carro(
    var marca : String = "",
    var modelo : String = "",
    var placa : String = "",
    var ano : Int = 1960) {

//    var marca : String = ""
//        get() { return field}
//        set(value) { field = value }

    // Data class além de criar os getter e setters
    // sobreescreve os métodos
        // toString()
        // hashCode()
        // equals()

//    override fun toString(): String {
//        return "$marca - $modelo ($ano) - placa: $placa"
//    }
}
