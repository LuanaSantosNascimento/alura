package br.com.alura.bytebank.testes

import br.com.alura.bytebank.modelo.Analista
import br.com.alura.bytebank.modelo.Calculadora
import br.com.alura.bytebank.modelo.Diretor
import br.com.alura.bytebank.modelo.Gerente

fun testaFuncionarios() {
    val alex = Analista(nome = "Guilherme", cpf = "111.111.111.-11", salario = 2000.0)
    println("Nome: ${alex.nome}")
    println("CPF: ${alex.cpf}")
    println("Salário: ${alex.salario}")
    println("Bonificação: ${alex.getBonificacao()}")

    val fran = Gerente(nome = "Fran", cpf = "222.222.222-22", salario = 3000.0, senha = 1234)
    println("br.com.alura.bytebank.modelo.Gerente --------->")
    println("Nome: ${fran.nome}")
    println("CPF: ${fran.cpf}")
    println("Salário: ${fran.salario}")
    println("Bonificação: ${fran.getBonificacao()}")

    if(fran.autentica(1234)){
        print("Autenticou\n")
    }else{
        println("Deu ruim\n")
    }
    val julio = Diretor(nome = "Júlio", cpf = "333.333.333-33", salario = 4000.0, senha = 4567, plr = 250.0)
    println("br.com.alura.bytebank.modelo.Diretor --------->")
    println("Nome: ${julio.nome}")
    println("CPF: ${julio.cpf}")
    println("Salário: ${julio.salario}")
    println("PLR: ${julio.plr}")
    println("Bonificação: ${julio.getBonificacao()}")

    if(julio.autentica(4567)){
        print("Autenticou")
    }else{
        println("Deu ruim")
    }

    val maria = Analista(nome = "Maria", cpf = "444.444.444-44", salario = 4000.0)
    val calc = Calculadora()
    calc.registra(alex)
    calc.registra(julio)
    calc.registra(fran)
    calc.registra(maria)
    println("\n\nBonificação total: ${calc.total}")
}