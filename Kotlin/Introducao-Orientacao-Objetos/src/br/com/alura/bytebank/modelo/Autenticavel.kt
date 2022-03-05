package br.com.alura.bytebank.modelo

interface Autenticavel {

    //O que vai ser usado em comum em todas as entidades

    fun autentica(senha: Int): Boolean
}