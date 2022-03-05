package br.com.alura.bytebank.testes

import br.com.alura.bytebank.exceptions.SaldoInsuficienteException

fun testaFilaDeExecucao() {
    teste()
    println("Início main()")
    funcao1()
    println("Fim main()")

    testaExceptions()
}
public fun testaExceptions() {
    val valorEntrada = "1.9"

    val valorRecebido: Double? = try {
        valorEntrada.toDouble()
    } catch (ex: NumberFormatException) {
        println("Erro na conversão")
        ex.printStackTrace()
        null
    }

    val valorComTaxa: Double? = if (valorRecebido != null) {
        valorRecebido + 0.1
    } else {
        null
    }

    if (valorComTaxa != null) {
        println("valor recebido: $valorComTaxa")
    } else {
        println("valor inválido")
    }
}

fun funcao1() {
    println("Início funcao1()")
    try {
        funcao2()
    }catch (ex: SaldoInsuficienteException){
        println("SaldoInsuficienteException pegada")
        ex.printStackTrace()
    }
    println("Fim funcao1()")
}

fun funcao2() {
    println("Início funcao2()")
    for(i in 1..20 step 5) {
        println(i)
        val endereco = Any()
//        endereco as Endereco
//        throw ClassCastException()
        throw SaldoInsuficienteException(mensagem = "Seu saldo é insuficiente. A operação não será autorizada.\n\n Mensagem personalizada")
    }
    println("Fim funcao2()")
}

fun teste(){
    return teste()
}
