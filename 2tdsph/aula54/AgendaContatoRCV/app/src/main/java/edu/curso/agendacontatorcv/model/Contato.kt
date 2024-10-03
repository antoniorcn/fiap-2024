package edu.curso.agendacontatorcv.model

import java.io.Serializable

data class Contato(
    var id : Long = 0,
    var nome : String = "",
    var telefone : String = "",
    var email : String = "") : Serializable {
}