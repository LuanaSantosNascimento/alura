package alura.com.br

fun TestaMap() {
    val pedidos = mutableMapOf(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 50.0
    )
//    val valorPedido = pedidos.getValue(5)
//    println(valorPedido)

    val mensagem: Double? = pedidos.getOrElse(0, { 0.0 })
    println(mensagem)

    println(pedidos.getOrDefault(1, -1.0))
    println(pedidos.getOrDefault(0, -1.0))

    println(pedidos.keys)

    for (numero in pedidos.keys) {
        println("Pedido: $numero")
    }
    println(pedidos.values)

    for (valor in pedidos.values) {
        println("Valor: $valor")
    }

    val pedidosFiltrados = pedidos.filter { (numero, valor) ->
        numero % 2 == 0 && valor > 50.0
    }

    println(pedidosFiltrados)

    pedidos.filterValues { valor -> valor > 70.0 }
    pedidos.filterKeys { numero -> numero % 2 == 0 }
}

fun testaMap(pedidos: MutableMap<Int, Double>) {
    println(pedidos)

    val pedido = pedidos[3]
    pedido?.let {
        println("Pedido: $it")
    }

    for (p: Map.Entry<Int, Double> in pedidos) {
        println("Número: ${p.key}")
        println("Valor: ${p.value}")
    }

    //Inserindo um novo elemento

    pedidos[4] = 70.0
    println(pedidos)
    pedidos.put(5, 80.0)
    println(pedidos)
    pedidos[1] = 100.0
    println(pedidos)
    pedidos.putIfAbsent(6, 200.0)
    println(pedidos)
    pedidos.putIfAbsent(6, 300.0)
    println(pedidos)
    pedidos.remove(2)
    pedidos.remove(3, 100.0) //Sobrecarga para remover um objeto idêntico: de indice 3 e valor 100.0
    println(pedidos)

    /*
    * Em casos em que a performance importa utilize o Pair()*/
}