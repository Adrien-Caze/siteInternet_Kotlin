import java.awt.Desktop
import java.net.URI
import com.sun.net.httpserver.HttpServer
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpExchange
import java.net.InetSocketAddress

fun main() {
    val serveur = HttpServer.create(InetSocketAddress(8080),0)

    val navaccueil = BootstrapNavbar("Accueil", listOf<URI>(URI("http://localhost:8080/About"),URI("http://localhost:8080/Contact")))
    val footeraccueil = BootstrapFooter("Site par Adrien CAZE des SIO 12")

    serveur.createContext("/Accueil"){ exchange ->
        val accueil = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <title>Accueil</title>
                </head>
                <header>
                    ${navaccueil.render()}
                </header>
                <body>
                    <h1>Hello World !</h1>
                </body>
                ${footeraccueil.render()}
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200,accueil.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(accueil.toByteArray())
        os.close()
    }
    val navabout = BootstrapNavbar("About", listOf<URI>())
    val footerabout = BootstrapFooter("Site par Adrien CAZE des SIO 12")
    serveur.createContext("/About"){ exchange ->
        val about = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <title>About</title>
                </head>
                ${navabout.render()}
                <body>
                    <h1>Hello World !</h1>
                </body>
                ${footerabout.render()}
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200,about.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(about.toByteArray())
        os.close()
    }

    val footercontact = BootstrapFooter("Site par Adrien CAZE des SIO 12")
    serveur.createContext("/Contact"){ exchange ->
        val contact = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <title>Contact</title>
                </head>
                ${nav.render()}
                <body>
                    <h1>Hello World !</h1>
                </body>
                ${footercontact.render()}
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200,contact.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(contact.toByteArray())
        os.close()
    }

    /*serveur.executor = null*/
    serveur.start()
    if(Desktop.isDesktopSupported()){
        val desktop = Desktop.getDesktop()
        desktop.browse(URI("http://localhost:8080/Accueil"))
    }
}