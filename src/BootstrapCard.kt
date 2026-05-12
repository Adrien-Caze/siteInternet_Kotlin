class BootstrapCard(val titre : String, val contenu : String){

    fun render():String{
        return """
            <div class="card">
                <h3>$titre</h3>
                <p>$contenu</p>
            </div>
        """
    }
}
