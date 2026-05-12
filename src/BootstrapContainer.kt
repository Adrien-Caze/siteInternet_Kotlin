class BootstrapContainer(val titre:String, val card: List<BootstrapCard>) {

    fun render(): String {
        val cardsHtml = card.joinToString("\n") { it.render() }
        return """
        <main class="container">
            <h2 class="section-title">$titre</h2>
            <div class="cards">
                $cardsHtml
            </div>
        </main>
    """.trimIndent()
    }
}