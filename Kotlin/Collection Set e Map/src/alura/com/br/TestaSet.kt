package alura.com.br

fun testaSet() {
    val assistiramCursoAndroid: MutableSet<String> = mutableSetOf("Alex", "Maria", "Felipe", "Guilherme")
    val assistiramCursoKotlin: MutableSet<String> = mutableSetOf("Alex", "Paulo", "Felipe")
//    val  assistiramAmbos = assistiramCursoAndroid + assistiramCursoKotlin
    val assistiramAmbos = mutableSetOf<String>()
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    assistiramAmbos.add("Ana")
    assistiramAmbos.add("Ana")
    assistiramAmbos.add("Guilherme")

    println("Assistiram ambos: $assistiramAmbos")
    println()
    println("Assistiram curso android + kotlin: ${assistiramCursoAndroid + assistiramCursoKotlin}")
    println("Assistiram curso android union kotlin: ${assistiramCursoAndroid union assistiramCursoKotlin}")
    println()
    println("Assistiram curso android - kotlin: ${assistiramCursoAndroid - assistiramCursoKotlin}")
    println("Assistiram curso android subtract kotlin: ${assistiramCursoAndroid subtract assistiramCursoKotlin}")
    println()
    println("Assistiram curso android intersect kotlin: ${assistiramCursoAndroid intersect assistiramCursoKotlin}")

    val assistiramList = assistiramAmbos.toMutableList()
    assistiramList.add("Alex")
    println(assistiramList)
    println(assistiramList.toSet())
}