package br.com.alura.bytebank.modelo

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int,
    val plr: Double
) : FuncionarioAdmin(nome = nome, cpf = cpf, salario = salario, senha = senha){

    override fun getBonificacao(): Double = salario + plr

    /*
        Linha 7 -> apresenta um construtor primário
        Construtor secundário:

        class br.com.alura.bytebank.modelo.Gerente : Funcionário {
            val senha: Int

            constructor(
                nome: String,
                cpf: String,
                salario: Double,
                senha: Int
            ): super(
                nome = nome,
                cpf = cpf,
                salario = salario
            ){ this.senha = senha }
         }

         Casos em que o construtor não é personalizado:

         open class Animal {}

         class Gato : Animal(){}

         Construtor secundário:

         class Gato : Animal {
            constructor() : super()
          }
     */
}