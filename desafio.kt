// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)


enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int )

data class Formacao(val nome: String, val nivel: Nivel,var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }

    fun listarInscritos(): List<String> {
        return inscritos.map { it.nome }
    }

    fun removerConteudo(nome: String) {
        conteudos.removeAll { it.nome.equals(nome, ignoreCase = true) }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }
}

fun main() {
    val formacaoKotlin = Formacao("Formacao Kotlin Inicinte",Nivel.BASICO,mutableListOf(
        ConteudoEducacional("Introdução ao Kotlin", 60),
        ConteudoEducacional("Estruturas de Controle em Kotlin", 90)
    ))

    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    println("Inscritos na formação ${formacaoKotlin.nome}: ${formacaoKotlin.listarInscritos()}")

    formacaoKotlin.adicionarConteudo(ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 120))
    println("Conteúdos após adição: ${formacaoKotlin.conteudos}")

    formacaoKotlin.removerConteudo("Introdução ao Kotlin")
    println("Conteúdos após remoção: ${formacaoKotlin.conteudos}")

    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
