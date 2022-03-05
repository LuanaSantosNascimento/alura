package br.com.alura.bytebank.testes

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.Endereco

fun testaAny() {
    imprime(Unit)
    imprime("")
    imprime(3 + 2.0)
    imprime(1.567 - 0.34567)
    imprime(Endereco())
    imprime("Hey there !\n I'm Studyind")
    imprime(2)
    imprime(true)

    val teste = imprime(Cliente(nome = "", cpf = "", senha = 1))
    println(teste)

    val endereco = Endereco(
        bairro = "Amoreiras",
        logradouro = "Rua Vergueiros",
        cidade = "Amoras",
        estado = "São Paulo",
        numero = 102,
        cep = "12789-098"
    )
    val endereco2 = Endereco(
        bairro = "Taubaté",
        logradouro = "Rua Vergueiros",
        cidade = "Amoras",
        estado = "São Paulo",
        numero = 102,
        cep = "12789-098"
    )
    println(endereco.toString())
    println(endereco.equals(endereco2))
    println(endereco.hashCode())
    println(endereco2.hashCode())
    println("${endereco.javaClass}@${Integer.toHexString(endereco.hashCode())}")

    val qualquer = Any()
    println(qualquer)
    println(qualquer.equals(endereco))
    println(qualquer.hashCode())
    imprime(qualquer)

    //testaFuncionarios()
}

fun imprime(any: Any): Any{
    println(any)
    return any
}