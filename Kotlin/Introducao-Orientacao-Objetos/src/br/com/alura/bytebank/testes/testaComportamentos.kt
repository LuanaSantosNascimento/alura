package br.com.alura.bytebank.testes

import br.com.alura.bytebank.exceptions.FalhaDeAutenticacaoException
import br.com.alura.bytebank.exceptions.SaldoInsuficienteException
import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaTransferivel

fun testaComportamentos() {
    val alex = Cliente(nome = "Alex", cpf = "111.111.111-11", senha = 1001)
    val contaAlex = ContaTransferivel.ContaCorrente(titular = alex, numero = 1000)
    contaAlex.deposita(200.0)

    val fran = Cliente(nome = "Fran", cpf = "222.222.222-22", senha = 2002)
    val contaFran = ContaTransferivel.ContaPoupanca(numero = 1001, titular = fran)
    contaFran.deposita(300.0)

    println(contaFran.titular.nome)
    println(contaFran.numero)
    println(contaFran.saldo)

    println(contaAlex.titular.nome)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println("depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)

    println("depositando na conta da Fran")
    contaFran.deposita(70.0)
    println(contaFran.saldo)

    println("sacando na conta do Alex")
    contaAlex.saca(250.0)
    println(contaAlex.saldo)

    println("sacando na conta da Fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)

    println("saque em excesso na conta do Alex")
    contaAlex.saca(100.0)
    println(contaAlex.saldo)

    println("saque em excesso na conta da Fran")
    contaFran.saca(500.0)
    println(contaFran.saldo)

    println("Transferência da conta da Fran para o Alex")

    try {
        contaFran.transfere(destino = contaAlex, valor = 100.0, senha = 202)
        println("Transferência sucedida")
    } catch(ex: SaldoInsuficienteException) {
        println("Falha na transferência")
        ex.printStackTrace()
        println("ex.message")
        println(ex.message)
    } catch (ex: FalhaDeAutenticacaoException){
        println("Falha na autenticação")
        ex.printStackTrace()
    }catch (ex: Exception){
        println("Entrou na Exception")
        ex.printStackTrace()
    }

    println(contaAlex.saldo)
    println(contaFran.saldo)
}