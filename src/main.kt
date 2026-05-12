import java.awt.Desktop
import java.net.URI
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

fun main() {
    val serveur = HttpServer.create(InetSocketAddress(8080),0)

    val navaccueil = BootstrapNavbar("Accueil", listOf<URI>(URI("http://localhost:8080/About"),URI("http://localhost:8080/Contact")))
    val footer = BootstrapFooter("Site par Adrien CAZE des SIO 12")
    val cards = BootstrapContainer("Exemple",listOf<BootstrapCard>(BootstrapCard("Carte 1","Ceci est la carte 1"),BootstrapCard("Carte 2","Ceci est la carte 2"),BootstrapCard("Carte 3","Ceci est la carte 3")))

    serveur.createContext("/"){ exchange ->
        val accueil = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <title>Accueil</title>
                    ${cssStyles()}
                </head>
                <body>
                    ${navaccueil.render()}
                    <div class="hero">
                        <h1>Hello World !</h1>
                        <p>Bienvenue sur mon site créé en Kotlin</p>
                        ${cards.render()}
                    </div>
                </body>
                ${footer.render()}
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200,accueil.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(accueil.toByteArray())
        os.close()
    }
    val navabout = BootstrapNavbar("About", listOf<URI>(URI("http://localhost:8080/"),URI("http://localhost:8080/Contact")))
    val aboutCard = BootstrapContainer("A propos", listOf<BootstrapCard>(BootstrapCard("C'est quoi ?","Ce site est une démonstration qui répond a la question : Es-il possible de créé un site web en Kotlin ?")))
    serveur.createContext("/About"){ exchange ->
        val about = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <title>About</title>
                    ${cssStyles()}
                </head>
                <body>
                    ${navabout.render()}
                    <div class="hero">
                            <h1>Hello World !</h1>
                            <p>Bienvenue sur mon site créé en Kotlin</p>
                            ${aboutCard.render()}
                    </div>
                </body>
                ${footer.render()}
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200,about.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(about.toByteArray())
        os.close()
    }
    val navcontact = BootstrapNavbar("Contact",listOf<URI>(URI("http://localhost:8080/"),URI("http://localhost:8080/About")))
    serveur.createContext("/Contact"){ exchange ->
        val contact = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <title>Contact</title>
                    ${cssStyles()}
                </head>
                <body>
                    ${navcontact.render()}
                    <div class="hero">
                        <h1>Hello World !</h1>
                        <p>Bienvenue sur mon site créé en Kotlin</p>
                    </div>
                </body>
                ${footer.render()}
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
        desktop.browse(URI("http://localhost:8080/"))
    }
}