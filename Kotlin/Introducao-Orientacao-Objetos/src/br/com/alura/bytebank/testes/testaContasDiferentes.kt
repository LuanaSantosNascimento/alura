package br.com.alura.bytebank.testes

import br.com.alura.bytebank.modelo.*

internal fun testaContasDiferentes() {
    val alex = Analista(nome = "Guilherme", cpf = "111.111.111.-11", salario = 2000.0)
    val contaCorrente = ContaTransferivel.ContaCorrente(
        titular = Cliente(
            nome = "Alex",
            cpf = "111.111.444-44",
            senha = 1001,
            endereco = Endereco(logradouro = "Rua Vergueiro")
        ), numero = 1000
    )

    println("Nome: ${alex.nome}")
    println("CPF: ${alex.cpf}")
    println("Salário: ${alex.salario}")
    println("Bonificação: ${alex.getBonificacao()}")
    println("Endereço: ${contaCorrente.titular.endereco.logradouro}")

    val fran = Gerente(nome = "Fran", cpf = "222.222.222-22", salario = 3000.0, senha = 1234)
    val contaPoupanca = ContaTransferivel.ContaPoupanca(
        titular = Cliente(nome = "Fran", cpf = "222.222.555-55", senha = 2002), numero = 1001
    )

    println()
    println("Nome: ${fran.nome}")
    println("CPF: ${fran.cpf}")
    println("Salário: ${fran.salario}")
    println("Bonificação: ${fran.getBonificacao()}")

    //Depósitos
    contaCorrente.deposita(1000.0)
    contaPoupanca.deposita(1000.0)
    println("Saldo conta corrente (Alex): ${contaCorrente.saldo}")
    println("Saldo conta poupança (Fran): ${contaPoupanca.saldo}")

    //Saques
    contaCorrente.saca(100.0)
    contaPoupanca.saca(100.0)
    println("Saldo conta corrente (Alex) após saque: ${contaCorrente.saldo}")
    println("Saldo conta poupança (Fran) após saque: ${contaPoupanca.saldo}")

    //Transferência Alex
    contaCorrente.transfere(200.0, contaPoupanca, 1)
    println("Saldo conta corrente (Alex) após transferência efetuada: ${contaCorrente.saldo}")
    println("Saldo conta poupança (Fran)após transferência recebida: ${contaPoupanca.saldo}")

    //Transferência Alex
    contaPoupanca.transfere(150.0, contaCorrente, 2)
    println("Saldo conta poupança (Fran) após transferência efetuada: ${contaPoupanca.saldo}")
    println("Saldo conta corrente (Alex) após transferência recebida: ${contaCorrente.saldo}")

    //br.com.alura.bytebank.modelo.Conta Salario
    println()
    val rafa = Cliente(nome = "Rafa", cpf = "555.555.555-55", senha = 5000)
    val contaSalario =
        ContaSalario(titular = Cliente(nome = "Rafa", cpf = "555.555.666-66", senha = 10004), numero = 1005)

    println("Nome: ${rafa.nome}")
    println("CPF: ${rafa.cpf}")

    contaPoupanca.transfere(150.0, contaSalario, 3)
    println("Saldo conta poupança (Fran) após transferência efetuada: ${contaPoupanca.saldo}")
    println("Saldo conta salário (Rafa) após transferência recebida: ${contaSalario.saldo}")

    contaSalario.deposita(1000.0)
    println("Saldo conta salário (Rafa) após depósito: ${contaSalario.saldo}")

    contaSalario.saca(100.0)
    println("Saldo conta salário (Rafa) após saque: ${contaSalario.saldo}")
}