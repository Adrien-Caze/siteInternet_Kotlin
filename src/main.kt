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
                    <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-primary bg-gradient-primary-to-secondary text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                            <h1 class="fw-bolder">Contactez moi :</h1>
                            <p class="lead fw-normal text-muted mb-0">Travaillons Ensemble !</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <!-- * * * * * * * * * * * * * * *-->
                                <!-- * * SB Forms Contact Form * *-->
                                <!-- * * * * * * * * * * * * * * *-->
                                <!-- This form is pre-integrated with SB Forms.-->
                                <!-- To make this form functional, sign up at-->
                                <!-- https://startbootstrap.com/solution/contact-forms-->
                                <!-- to get an API token!-->
                                <form action="https://formspree.io/f/xvgdkbgb" method="POST">
    <div class="form-floating mb-3">
        <input class="form-control" name="name" type="text" placeholder="Nom" required>
        <label>Nom Complet</label>
    </div>

    <div class="form-floating mb-3">
        <input class="form-control" name="email" type="email" placeholder="email" required>
        <label>Adresse Email</label>
    </div>

    <div class="form-floating mb-3">
        <input class="form-control" name="phone" type="text" placeholder="Téléphone" required>
        <label>Numéro de téléphone</label>
    </div>

    <div class="form-floating mb-3">
        <textarea class="form-control" name="message" placeholder="Votre message" style="height: 10rem" required></textarea>
        <label>Message</label>
    </div>

    <button class="btn btn-primary btn-lg" type="submit">Envoyer</button>
</form>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
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