package alura.com.br

class BancoDeNomes {
    val nomes: Collection<String> get() = dados.toList() //Devolve uma cópia e não uma referência ao objeto original

    companion object {
        private val dados = mutableListOf<String>()
    }

    fun salva(nome: String) {
        dados.add(nome)
    }
}

fun testaCopia() {
    val banco = BancoDeNomes()
    // banco.salva("Paulo")
    val nomesSalvos: MutableCollection<String> = banco.nomes as MutableCollection<String>
    println(banco.nomes)
    println(BancoDeNomes().nomes)
    println(nomesSalvos)
}

fun testaColecoes() {
    //    val nomes: Collection<String> = listOf("Alex", "Fran", "Gui", "Maria", "Ana")
    val nomes: Collection<String> = mutableListOf("Alex", "Fran", "Gui", "Maria", "Ana")
//    nomes.add("Paulo")
//    nomes.remove("Ana")
    for (nome: String in nomes) {
        println(nome)
    }

    println(nomes)
    println("Tem o nome Alex? ${nomes.contains("Alex")}")
    println(nomes.size)
}