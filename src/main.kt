import java.awt.Desktop
import java.net.URI

fun main() {
    if (Desktop.isDesktopSupported()) {
        val desktop = Desktop.getDesktop()
        desktop.browse(URI.create("http://www.youtube.com"))
    }
}