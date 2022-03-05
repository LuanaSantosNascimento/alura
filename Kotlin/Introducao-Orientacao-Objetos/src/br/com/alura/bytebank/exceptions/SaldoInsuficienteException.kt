package br.com.alura.bytebank.exceptions

class SaldoInsuficienteException(mensagem: String = "Seu saldo é insuficiente. A operação não será autorizada.") : Exception(mensagem)
