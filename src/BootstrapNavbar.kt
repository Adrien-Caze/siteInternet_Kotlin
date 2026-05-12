import java.net.URI
import com.sun.net.httpserver.HttpExchange

class BootstrapNavbar(val brand : String, val links : List<URI>) {

    private fun accueil(link: URI): String {
        return if (link.path == "/") {
            "Accueil"
        } else {
            link.path.trimStart('/').replaceFirstChar { it.uppercase() }
        }
    }

    private fun boucle(): String {
        return links.joinToString("\n") { link ->
            """
        <li>
            <a href="$link">${accueil(link)}</a>
        </li>
        """.trimIndent()
        }
    }

    fun render():String {
    return """
        <nav>
            <div class="nav-inner">
                <a class="nav-logo" href="http://localhost:8080/">
                    <span>$brand</span>
                </a>
                <div>
                    <ul class="nav-links">
                        ${boucle()}
                    </ul>
                </div>
            </div>
        </nav>
    """.trimIndent()
    }
}