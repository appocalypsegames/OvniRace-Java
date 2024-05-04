
package carreraovni;

import com.itextpdf.text.DocumentException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author eduar
 */
public class Controlador implements KeyListener,ActionListener{
    private Vista v;
    private  Ovni ovni,ovni2;
    private int velocidad=10,velocidad2=10,cvelocidad=10,cvelocidad2=10,contador=0,contador2=0,numPlayer=1,circuito=-1,tiempoRestante=60,contTime=0;
    private boolean left=false,right=false,up=false,down=false,fin=false,vuelta=false,left2=false,right2=false,up2=false,down2=false,vuelta2=false,pause=false;
    
    public Controlador() {
        v = new Vista(this);
        new Timer(50, this).start();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(!pause){
         switch(ke.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=true;
                break;
            case KeyEvent.VK_UP:
                up=true;
                break;
            case KeyEvent.VK_RIGHT:
                right=true;
                break;
            case KeyEvent.VK_DOWN:
                down=true;
                break;
            case KeyEvent.VK_A:
                left2=true;
                break;
            case KeyEvent.VK_W:
                up2=true;
                break;
            case KeyEvent.VK_D:
                right2=true;
                break;
            case KeyEvent.VK_S:
                down2=true;
                break;
            default:
                break;
             
         }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(!pause){
         switch(ke.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=false;
                break;
            case KeyEvent.VK_UP:
                up=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false;
                break;
            case KeyEvent.VK_DOWN:
                down=false;
                break;
            case KeyEvent.VK_A:
                left2=false;
                break;
            case KeyEvent.VK_W:
                up2=false;
                break;
            case KeyEvent.VK_D:
                right2=false;
                break;
            case KeyEvent.VK_S:
                down2=false;
                break;
            default:
                break;
         }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(circuito!=-1){
            if(numPlayer==1&&!fin)contTime++;
            if(contTime==20&&numPlayer==1&&!fin){
                contTime=0;
                tiempoRestante--;
                if(tiempoRestante<=0){
                    tiempoRestante=0;
                    fin=true;
                    v.barraMenu.setVisibleItemsGameOver();
                }
                v.actualizarTimer(String.valueOf(tiempoRestante));
            }
        }
        if(circuito!=-1&&!pause&&!fin){
            try {
                if(!(tiempoRestante<=0&&numPlayer==1)){
                    moverOvni();
                    comprobarFin();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(pause){
            left=false;
            right=false;
            up=false;
            down=false;
            fin=false;
            left2=false;
            right2=false;
            up2=false;
            down2=false;
        }
        v.repaint();
    }
    
    /**
     * mover Ovni
     */
    private void moverOvni(){
        if(!fin){
            if(left)ovni.setX(ovni.getX()-velocidad);
            if(up)ovni.setY(ovni.getY()-velocidad);
            if(right)ovni.setX(ovni.getX()+velocidad);
            if(down)ovni.setY(ovni.getY()+velocidad);
            switch(circuito){
                case 0:
                    if(ovni.getY()<=340&&ovni.getX()<=250&&vuelta){//si se ha dado una vuelta completa
                        vuelta=false;
                        velocidad+=3;//incrementamos velocidad
                        cvelocidad=velocidad<10?10+contador*3:velocidad;
                        contador++;
                        if(numPlayer==2&&contador>=10){//si ha ganado la carrera
                            fin=true;
                            ovni.setWin();
                            v.barraMenu.setVisibleItemsGameOver();
                        }
                        v.actualizarContador(String.valueOf(contador));
                    }
                    if(ovni.getX()>=1000&&ovni.getY()>=310&&ovni.getY()<=410)vuelta=true;
                    break;
                case 1:
                    if(ovni.getY()<=350&&ovni.getX()<=390&&vuelta){//si se ha dado una vuelta completa
                        vuelta=false;
                        velocidad+=2;//incrementamos velocidad
                        cvelocidad=velocidad<10?10+contador*2:velocidad;
                        contador++;
                        if(numPlayer==2&&contador>=10){
                            fin=true;
                            ovni.setWin();
                            v.barraMenu.setVisibleItemsGameOver();
                        }
                        v.actualizarContador(String.valueOf(contador));
                    }
                    if(ovni.getX()>=840&&ovni.getY()>=310&&ovni.getY()<=410)vuelta=true;
                    break;
                default:
                    break;
            }
            
            if(numPlayer==2){
                if(left2)ovni2.setX(ovni2.getX()-velocidad2);
                if(up2)ovni2.setY(ovni2.getY()-velocidad2);
                if(right2)ovni2.setX(ovni2.getX()+velocidad2);
                if(down2)ovni2.setY(ovni2.getY()+velocidad2);
                switch(circuito){
                    case 0:
                        if(ovni2.getY()<=340&&ovni2.getX()<=250&&vuelta2){//si se ha dado una vuelta completa
                            vuelta2=false;
                            velocidad2+=3;//incrementamos velocidad
                            cvelocidad2=velocidad2<10?10+contador2*3:velocidad2;
                            contador2++;
                            if(contador2>=10){//si ha ganado la carrera
                                fin=true;
                                ovni2.setWin();
                                v.barraMenu.setVisibleItemsGameOver();
                            }
                            v.actualizarContador2(String.valueOf(contador2));
                        }
                        if(ovni2.getX()>=1000&&ovni2.getY()>=310&&ovni2.getY()<=410)vuelta2=true;
                        break;
                    case 1:
                        if(ovni2.getY()<=350&&ovni2.getX()<=390&&vuelta2){//si se ha dado una vuelta completa
                            vuelta2=false;
                            velocidad2+=2;//incrementamos velocidad
                            cvelocidad2=velocidad2<10?10+contador2*2:velocidad2;
                            contador2++;
                            if(contador2>=10){
                                fin=true;
                                ovni2.setWin();
                                v.barraMenu.setVisibleItemsGameOver();
                            }
                            v.actualizarContador2(String.valueOf(contador2));
                        }
                        if(ovni2.getX()>=840&&ovni2.getY()>=310&&ovni2.getY()<=410)vuelta2=true;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * comprobar salida del circuito
     */
    private void comprobarFin() throws FileNotFoundException, DocumentException {
            switch(circuito){
                 case 0:
                     if(ovni.getX()<70
                     ||ovni.getX()>1220
                     ||ovni.getY()<90
                     ||ovni.getY()>630
                     ||ovni.getX()>250&&ovni.getX()<1030&&ovni.getY()>200&&ovni.getY()<530){//si sale del circuito
                         if(numPlayer==1){
                             fin=true;
                             ovni.setDestroyed();
                             v.barraMenu.setVisibleItemsGameOver();
                         }else velocidad=3;
                     }else velocidad=cvelocidad;//si entra en el circuito
                    break;
                 case 1:
                     //circulo interior
                     boolean frenar=false;
                     double xDif = ovni.getX()+37.5 - 685;
                     double yDif = ovni.getY()+37.5 - 375;
                     double distancia = Math.sqrt((Math.pow(xDif, 2) + Math.pow(yDif, 2)));
                     boolean toca=distancia<225;
                     if(toca){
                         if(numPlayer==1){
                             fin=true;
                             ovni.setDestroyed();
                             v.barraMenu.setVisibleItemsGameOver();
                         }else frenar=true;
                     }
                     //circulo exterior
                     xDif = ovni.getX()+37.5 - 685;
                     yDif = ovni.getY()+37.5 - 375;
                     distancia = Math.sqrt((Math.pow(xDif, 2) + Math.pow(yDif, 2)));
                     toca=distancia>355;
                     if(toca){
                         frenar=true;
                         if(numPlayer==1){
                             fin=true;
                             ovni.setDestroyed();
                             v.barraMenu.setVisibleItemsGameOver();
                         }else frenar=true;
                     }
                     if(frenar)velocidad=3;
                     else velocidad=cvelocidad;
                    break;
                default:
                    break;
            }

            if(numPlayer==2){
                switch(circuito){
                     case 0:
                         if(ovni2.getX()<70
                         ||ovni2.getX()>1220
                         ||ovni2.getY()<90
                         ||ovni2.getY()>630
                         ||ovni2.getX()>250&&ovni2.getX()<1030&&ovni2.getY()>200&&ovni2.getY()<530)velocidad2=3;
                         else velocidad2=cvelocidad2;
                        break;
                     case 1:
                         boolean frenar=false;
                         //circulo interior
                         double xDif = ovni2.getX()+37.5 - 685;
                         double yDif = ovni2.getY()+37.5 - 375;
                         double distancia = Math.sqrt((Math.pow(xDif, 2) + Math.pow(yDif, 2)));
                         boolean toca=distancia<225;
                         if(toca) frenar=true;

                         //circulo exterior
                         xDif = ovni2.getX()+37.5 - 685;
                         yDif = ovni2.getY()+37.5 - 375;
                         distancia = Math.sqrt((Math.pow(xDif, 2) + Math.pow(yDif, 2)));
                         toca=distancia>355;
                         if(toca) frenar=true;

                         if(frenar)velocidad2=3;
                         else velocidad2=cvelocidad2;
                        break;
                     default:
                        break;
                }
            }
    }
    
    /**
     * setters and getters
     * @return 
     */
    public int getNumPlayer(){
        return numPlayer;
    }
    
    public void setNumPlayer(int numPlayer){
        this.numPlayer=numPlayer;
    }
    
    public int getCircuito(){
        return circuito;
    }
    
    public void setCircuito(int circuito) {
        this.circuito=circuito;
    }

    public void setOvni(Ovni ovni) {
        this.ovni=ovni;
    }
    
    public void setOvni2(Ovni ovni) {
        this.ovni2=ovni;
    }
    
    public void inicializarVuelta(){
        vuelta=false;
        vuelta2=false;
    }

    public void setNewGame() {
        contTime=0;
        tiempoRestante=60;
        fin=false;
        velocidad=10;
        velocidad2=10;
        cvelocidad=10;
        cvelocidad2=10;
        contador=0;
        contador2=0;
        left=false;
        right=false;
        up=false;
        down=false;
        fin=false;
        left2=false;
        right2=false;
        up2=false;
        down2=false;
        vuelta=false;
        vuelta2=false;
    }

    public void setPause(boolean b) {
        pause=b;
    }
    public boolean getPause(){
        return pause;
    }
    
    public int getContador(){
        return contador;
    }
    
    public int getContador2(){
        return contador2;
    }
    
    public String getTime() {
        return String.valueOf(tiempoRestante);
    }
    
    public void createPDF() throws FileNotFoundException, DocumentException{
        new CreatePDF(this);
    }

}
