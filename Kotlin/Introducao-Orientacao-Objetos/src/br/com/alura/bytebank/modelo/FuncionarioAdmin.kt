package br.com.alura.bytebank.modelo

abstract class FuncionarioAdmin(
     nome: String,
     cpf: String,
     salario: Double,
    protected val senha: Int): Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
    ), Autenticavel {

    override fun autentica(senha: Int):Boolean{
        if(this.senha == senha)
            return true

        return false
    }

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