class BootstrapFooter(val texte : String){

    fun render():String{
        return """
           <footer>
    <div class="footer-inner">
      <div>
        <p class="footer-brand">$texte</p>
      </div>
      <div class="footer-col">
        <h4>Navigation</h4>
        <ul>
          <li><a href="http://localhost:8080/">Accueil</a></li>
          <li><a href="http://localhost:8080/About">À propos</a></li>
          <li><a href="http://localhost:8080/Contact">Contact</a></li>
        </ul>
      </div>
      <div class="footer-col">
        <h4>Contact</h4>
        <ul>
          <li><a href="https://adrien-caze.github.io/">Mon Portfolio</a></li>
          <li><a href="www.linkedin.com/in/adrien-cazé-214">LinkedIn</a></li>
          <li><a href="https://github.com/Adrien-Caze">GitHub</a></li>
        </ul>
      </div>
    </div>
    <div class="footer-bottom">
      © 2026 Site Kotlin — Tous droits réservés
    </div>
  </footer>
                
    """.trimIndent()
    }
}