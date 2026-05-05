import java.awt.Desktop
import java.net.URI
import com.sun.net.httpserver.HttpServer
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpExchange
import java.net.InetSocketAddress

fun main() {
    val serveur = HttpServer.create(InetSocketAddress(8080),0)
    serveur.createContext("/Accueil"){ exchange ->
        val reponse = """
            <!DOCTYPE html>
            <html lang="fr">
                <h1>Hello World !<!h1>
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200,reponse.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(reponse.toByteArray())
        os.close()
    }
    /*serveur.executor = null*/
    serveur.start()
    println("http://localhost:8080/Accueil")
}