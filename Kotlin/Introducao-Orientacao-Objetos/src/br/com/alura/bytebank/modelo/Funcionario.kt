package br.com.alura.bytebank.modelo

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double) {

    abstract fun getBonificacao(): Double

    /*
        'open' -> utilizado para "liberar a sobreescrita do método"

        As funções também podem ser escritas em uma linha, utilizando a variação do property
        open fun getBonificacao(): Double {
            return salario * 0.1
        }

        open val bonificacao: Double
        get() = salario * 0.1
     */
}