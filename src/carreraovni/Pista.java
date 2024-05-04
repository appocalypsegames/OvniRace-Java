package carreraovni;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author eduar
 */
public class Pista extends JLabel{

    public Pista(int circuito) {
        URL url;
        ImageIcon imagen;
        switch(circuito){
            case 0:
                url = this.getClass().getResource("/Imagenes/pista.png");
                imagen = new ImageIcon(url);
                this.setIcon(imagen);
                break;
            case 1:
                url = this.getClass().getResource("/Imagenes/pista1.png");
                imagen = new ImageIcon(url);
                this.setIcon(imagen);
                break;
            case 2:
                url = this.getClass().getResource("/Imagenes/fondo.jpg");
                imagen = new ImageIcon(url);
                this.setIcon(imagen);
                break;
            default:
                break;
        }
    }
}