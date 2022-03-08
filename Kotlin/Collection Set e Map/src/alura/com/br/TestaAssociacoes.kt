package alura.com.br

fun TestaAssociacoes() {
    val pedidos = listOf(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(4, 70.0)
    )

    println(pedidos)
//    val pedidosMapeados: Map<Int, Pedido> = pedidos.associate { pedido: Pedido ->
//        Pair(pedido.numero, pedido)
//        pedido.numero to pedido
//    }

    val pedidosMapeados: Map<Int, Pedido> = pedidos.associateBy { pedido ->
        pedido.numero
    }
    println(pedidosMapeados)
    println(pedidosMapeados[1])

    val pedidosFreteGratis: Map<Pedido, Boolean> = pedidos.associateWith { pedido ->
        pedido.valor > 50.0
    }

    println(pedidosFreteGratis)
    println(pedidosFreteGratis[Pedido(numero = 1, valor = 20.0)])

//    val mapas: Map<Boolean, Pedido> = pedidos.associateBy { pedido ->
//        pedido.valor > 50.0
//    }
//
//    println(mapas)

    val pedidosFreteGratisAgrupado: Map<Boolean, List<Pedido>> = pedidos.groupBy { pedido: Pedido ->
        pedido.valor > 50.0
    }

    println(pedidosFreteGratisAgrupado)
    println()
    println(pedidosFreteGratisAgrupado[false])

    val nomes = listOf(
        "Alex",
        "Ana",
        "Felipe",
        "Giovanna",
        "Letícia",
        "Júlia",
        "Guilherme",
        "Gabriela",
        "Luna"
    )

    val agenda = nomes.groupBy { nome ->
        nome.first()
    }

    println(nomes)
    println(agenda)
    println(agenda['A'])
}

data class Pedido(val numero: Int, val valor: Double)