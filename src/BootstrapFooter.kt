class BootstrapFooter(val texte : String){

    fun render():String{
        return """
           <footer>
                <center>
                    $texte <br>
                    <a href="http://localhost:8080/Contact">Contact</a>
                </center>
           </footer>
                
    """.trimIndent()
    }
}