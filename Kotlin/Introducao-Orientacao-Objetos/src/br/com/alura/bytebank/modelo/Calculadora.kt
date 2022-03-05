package br.com.alura.bytebank.modelo

class Calculadora{

    var total: Double = 0.0
        private set

    fun registra(funcionario: Any) {
        if(funcionario is Funcionario){
            this.total += funcionario.getBonificacao()
        }
    }
}