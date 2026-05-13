import java.awt.Desktop
import java.net.URI
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

fun main() {
    val serveur = HttpServer.create(InetSocketAddress(8080), 0)

    val navaccueil = BootstrapNavbar(
        "Accueil",
        listOf(URI("http://localhost:8080/About"), URI("http://localhost:8080/Contact"))
    )
    val footer = BootstrapFooter("Site par Adrien CAZE des SIO 12")
    val cards = BootstrapContainer(
        "Exemple",
        listOf(
            BootstrapCard("Carte 1", "Ceci est la carte 1"),
            BootstrapCard("Carte 2", "Ceci est la carte 2"),
            BootstrapCard("Carte 3", "Ceci est la carte 3"),
            BootstrapCard("Carte 4", "Ceci est la carte 4"),
            BootstrapCard("Carte 5", "Ceci est la carte 5"),
            BootstrapCard("Carte 6", "Ceci est la carte 6")
        )
    )

    serveur.createContext("/") { exchange ->
        val accueil = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Accueil</title>
                    ${cssStyles()}
                </head>
                <body>
                    ${navaccueil.render()}
                    <div class="hero">
                        <h1>Hello World !</h1>
                        <p>Bienvenue sur mon site créé en Kotlin</p>
                    </div>
                    ${cards.render()}
                    ${footer.render()}
                </body>
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200, accueil.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(accueil.toByteArray())
        os.close()
    }

    val navabout = BootstrapNavbar(
        "About",
        listOf(URI("http://localhost:8080/"), URI("http://localhost:8080/Contact"))
    )
    val aboutCard = BootstrapContainer(
        "À propos",
        listOf(
            BootstrapCard(
                "C'est quoi ?",
                "Ce site est une démonstration qui répond à la question : est-il possible de créer un site web en Kotlin ?"
            )
            ,BootstrapCard("Réponse :","C'est possible")
        )
    )

    serveur.createContext("/About") { exchange ->
        val about = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>About</title>
                    ${cssStyles()}
                </head>
                <body>
                    ${navabout.render()}
                    <div class="hero">
                        <h1>À propos</h1>
                        <p>En savoir plus sur ce projet</p>
                    </div>
                    ${aboutCard.render()}
                    ${footer.render()}
                </body>
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200, about.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(about.toByteArray())
        os.close()
    }

    val navcontact = BootstrapNavbar(
        "Contact",
        listOf(URI("http://localhost:8080/"), URI("http://localhost:8080/About"))
    )

    serveur.createContext("/Contact") { exchange ->
        val contact = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Contact</title>
                    ${cssStyles()}
                </head>
                <body>
                    ${navcontact.render()}
                    <div class="hero">
                        <h1>Contact</h1>
                        <p>Contactez moi !</p>
                    </div>
                    <section class="contact-section">
                        <div class="contact-card">
                            <form action="http://localhost:8080/404" method="POST">
                                <div class="form-group">
                                    <label for="name">Nom complet</label>
                                    <input id="name" name="name" type="text" placeholder="Jean Dupont" required>
                                </div>
                                <div class="form-group">
                                    <label for="email">Adresse email</label>
                                    <input id="email" name="email" type="email" placeholder="jean@exemple.fr" required>
                                </div>
                                <div class="form-group">
                                    <label for="phone">Numéro de téléphone</label>
                                    <input id="phone" name="phone" type="text" placeholder="+33 6 00 00 00 00" required>
                                </div>
                                <div class="form-group">
                                    <label for="message">Message</label>
                                    <textarea id="message" name="message" placeholder="Votre message..." required></textarea>
                                </div>
                                <button class="btn-contact" type="submit">Envoyer</button>
                            </form>
                        </div>
                    </section>
                    ${footer.render()}
                </body>
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200, contact.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(contact.toByteArray())
        os.close()
    }

    val navquatrecent = BootstrapNavbar(
        "404",
        listOf(URI("http://localhost:8080/"), URI("http://localhost:8080/About"), URI("http://localhost:8080/Contact"))
    )

    serveur.createContext("/404") { exchange ->
        val erreur = """
            <!DOCTYPE html>
            <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>404</title>
                    ${cssStyles()}
                </head>
                <body>
                    ${navquatrecent.render()}
                    <div class="hero">
                        <h1>Erreur : 404</h1>
                        <p>Veuillez nous excuser pour cette interuption, nous travaillons actuellement à régler votre problème.</p>
                    </div>
                    ${footer.render()}
                </body>
            </html>
        """.trimIndent()
        exchange.sendResponseHeaders(200, erreur.toByteArray().size.toLong())
        val os = exchange.responseBody
        os.write(erreur.toByteArray())
        os.close()
    }


    serveur.start()
    if (Desktop.isDesktopSupported()) {
        Desktop.getDesktop().browse(URI("http://localhost:8080/"))
    }
}