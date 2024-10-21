package edu.curso.testelogin

data class SignUpResponseDTO(
    var idToken: String="",
    var email: String="",
    var refreshToken: String="",
    var expiresIn: String="",
    var localId: String){}