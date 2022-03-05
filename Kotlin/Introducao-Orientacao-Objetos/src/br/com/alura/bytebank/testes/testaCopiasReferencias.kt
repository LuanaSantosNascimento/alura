package br.com.alura.bytebank.testes

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaTransferivel

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = ContaTransferivel.ContaPoupanca(Cliente(nome = "João", cpf = "123.456.789-00", senha = 1002), 1002)
    contaJoao.titular.nome = "João"
    var contaMaria =
        ContaTransferivel.ContaCorrente(Cliente(nome = "Maria", cpf = "120.400.709-00", senha = 1003), 1003)
    contaMaria.titular.nome = "Maria"
    contaJoao.titular.nome = "João"

    println("titular conta joao: ${contaJoao.titular.nome}")
    println("titular conta maria: ${contaMaria.titular.nome}")

    println(contaJoao)
    println(contaMaria)
}
