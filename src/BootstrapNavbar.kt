import java.net.URI

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

    fun render(): String {
        return """
        <nav>
            <div class="nav-inner">
                <a class="nav-logo" href="http://localhost:8080/">
                    <span>$brand</span>
                </a>
                <button class="nav-toggle" id="navToggle" aria-label="Ouvrir le menu" aria-expanded="false">
                    <span></span>
                    <span></span>
                    <span></span>
                </button>
                <div class="nav-menu" id="navMenu">
                    <ul class="nav-links">
                        ${boucle()}
                    </ul>
                </div>
            </div>
        </nav>
        <script>
            (function() {
                var toggle = document.getElementById('navToggle');
                var menu   = document.getElementById('navMenu');
                toggle.addEventListener('click', function() {
                    var isOpen = menu.classList.toggle('open');
                    toggle.classList.toggle('open', isOpen);
                    toggle.setAttribute('aria-expanded', String(isOpen));
                });
                // Ferme le menu si on clique en dehors
                document.addEventListener('click', function(e) {
                    if (!toggle.contains(e.target) && !menu.contains(e.target)) {
                        menu.classList.remove('open');
                        toggle.classList.remove('open');
                        toggle.setAttribute('aria-expanded', 'false');
                    }
                });
            })();
        </script>
        """.trimIndent()
    }
}