import java.net.URI
import com.sun.net.httpserver.HttpExchange

class BootstrapNavbar(val brand : String, val links : List<URI>) {

    private fun boucle(): String {
        return links.joinToString("\n") { link ->
            """
        <li>
            <a href="$link">${link.path}</a>
        </li>
        """.trimIndent()
        }
    }

    fun render():String {
    return """
        <nav>
            <div>
                <a href=${links[0]}>
                    <span>$brand</span>
                </a>
                <div>
                    <ul>
                        ${boucle()}
                    </ul>
                </div>
            </div>
        </nav>
    """.trimIndent()
    }
}