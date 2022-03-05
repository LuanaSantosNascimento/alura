package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.exceptions.FalhaDeAutenticacaoException
import br.com.alura.bytebank.exceptions.SaldoInsuficienteException

abstract class Conta(var titular: Cliente, val numero: Int): Autenticavel {
    var saldo = 0.0
        protected set

    companion object Contador {
        var totalContas = 0
            private set

        //Sem o companion apenas imlpementações dentro do objeto Contador conseguiriam alterar o valor da variável com o set privado
        //O Companion object possibilita que o Object Declaration compartilhe seus membros (quando ele está dentro de uma classe)
    }

    init {
        println("Criando conta")
        totalContas++
    }

    override fun autentica(senha: Int): Boolean {
        return titular.autentica(senha)
    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun saca(valor: Double)
}

class ContaSalario(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        if (this.saldo >= valor)
            this.saldo -= valor
    }

}

abstract class ContaTransferivel(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    fun transfere(valor: Double, destino: Conta, senha: Int) {
        if (saldo < valor)
            throw SaldoInsuficienteException(mensagem = "Seu saldo é insuficiente para realizar a transferência no valor de R$ $valor.\n Saldo atual: R$ $saldo.")
        if (!autentica(senha))
            throw FalhaDeAutenticacaoException()

        throw kotlin.NumberFormatException()
        saldo -= valor
        destino.deposita(valor)
    }

    class ContaPoupanca(
        titular: Cliente,
        numero: Int
    ) : ContaTransferivel(titular = titular, numero = numero) {
        override fun saca(valor: Double) {
            if (this.saldo >= valor)
                this.saldo -= valor
        }
    }

    class ContaCorrente(
        titular: Cliente,
        numero: Int
    ) : ContaTransferivel(titular = titular, numero = numero) {
        override fun saca(valor: Double) {
            val valorComTaxa = valor + 0.1

            if (this.saldo >= valorComTaxa)
                this.saldo -= valorComTaxa
        }
    }
}