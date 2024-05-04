package carreraovni;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author eduar
 */
public class Ovni extends JLabel{
    private int x, y;

    public Ovni(int jug) {
        URL url;
        ImageIcon imagen;
        switch(jug){
            case 1:
                url = this.getClass().getResource("/Imagenes/ovni.png");
                imagen = new ImageIcon(url);
                this.setIcon(imagen);
                break;
            case 2:
                url = this.getClass().getResource("/Imagenes/ovni2.png");
                imagen = new ImageIcon(url);
                this.setIcon(imagen);
                break;
            default:
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setDestroyed() {
        URL ur;
        ImageIcon img;
        ur = this.getClass().getResource("/Imagenes/ovnidestroyed.png");
        img = new ImageIcon(ur);
        this.setIcon(img);
    }
    
    public void setWin() {
        URL ur;
        ImageIcon img;
        ur = this.getClass().getResource("/Imagenes/ovniwin.png");
        img = new ImageIcon(ur);
        this.setIcon(img);
    }
}