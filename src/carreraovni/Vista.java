package carreraovni;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author eduar
 */
public class Vista extends JFrame{
    Controlador c;
    private JLabel cont,cont2,title,timer;
    private JButton btn1,btn2,btn3,btn4,btn5;
    private Ovni ovni,ovni2;
    private Pista p,f1,f2;
    private int numerovista;
    BarraMenu barraMenu;
    Vista(Controlador c)  {
        this.c=c;
        
        //propiedades ventana
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setBounds(0, 0, 1400, 1000);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
        this.addKeyListener(c);
        
        //creamos la interfaz inical
        interfazInicial();
    }
    
    /**
     * vista menú selección número de jugadores
     */
    public void interfazInicial() { 
    
        numerovista=0;
        //title
        title = new JLabel();
        title.setText("RUN, MARTIAN!");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Serif", Font.BOLD, 100));
        title.setBounds(280, 50, 800, 200);
        this.add(title);
        
        barraMenu=new BarraMenu(0,this);
        this.setJMenuBar(barraMenu);
        
        btn1=new JButton("1 Player");
        btn2=new JButton("2 Player");
        btn1.setFont(new Font("Serif", Font.PLAIN, 50));
        btn2.setFont(new Font("Serif", Font.PLAIN, 50));
        btn1.setBackground(Color.BLACK);
        btn2.setBackground(Color.BLACK);
        btn1.setOpaque(true);
        btn2.setOpaque(true);
        btn1.setForeground(Color.WHITE);
        btn2.setForeground(Color.WHITE);
        btn1.setBounds(100, 250, 400, 200);
        btn2.setBounds(800, 250, 400, 200);
        btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    c.setNumPlayer(1);
                    menuPista();
                }
        });
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    c.setNumPlayer(2);
                    menuPista();
                }
        });
        this.add(btn1);
        this.add(btn2);
        
        //aniado fondo
        f1=new Pista(2);
        f1.setBounds(0, 0, 1365, 740);
        this.add(f1);
    }
    
    /**
     * vista menú selección pista
     */
    public void menuPista(){
        
        
        f1.setVisible(false);
        btn1.setVisible(false);
        btn2.setVisible(false);
        
        numerovista=2;
        
        barraMenu=new BarraMenu(1,this);
        this.setJMenuBar(barraMenu);
        
        btn3=new JButton("Rectangle Circuit");
        btn4=new JButton("Circle Circuit");
        btn3.setFont(new Font("Serif", Font.PLAIN, 40));
        btn4.setFont(new Font("Serif", Font.PLAIN, 40));
        btn3.setBackground(Color.BLACK);
        btn4.setBackground(Color.BLACK);
        btn3.setOpaque(true);
        btn4.setOpaque(true);
        btn3.setForeground(Color.WHITE);
        btn4.setForeground(Color.WHITE);
        btn3.setBounds(100, 250, 400, 200);
        btn4.setBounds(800, 250, 400, 200);
        btn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    c.setCircuito(0);
                    switch(c.getNumPlayer()){
                        case 1:
                            game();
                            break;
                        case 2:
                            game2();
                            break;
                        default:
                            break;
                    }
                }
        });
            btn4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   c.setCircuito(1);
                   switch(c.getNumPlayer()){
                        case 1:
                            game();
                            break;
                        case 2:
                            game2();
                            break;
                        default:
                            break;
                    }
                }
        });
        this.add(btn3);
        this.add(btn4);
        
        //aniado fondo
        f2=new Pista(2);
        f2.setBounds(0, 0, 1365, 740);
        this.add(f2);
    }
    
    /**
     * vista juego 1 player
     */
    public void game(){
        if(numerovista!=3){
            title.setVisible(false);
            this.remove(title);
            f2.setVisible(false);
            this.remove(f1);
            this.remove(f2);
            btn3.setVisible(false);
            btn4.setVisible(false);
            this.remove(btn1);
            this.remove(btn2);
            this.remove(btn3);
            this.remove(btn4);
        }else{
            removeElements1();
        }
            
            barraMenu=new BarraMenu(2,this);
            this.setJMenuBar(barraMenu);

            //boton vuelta a menu
            btn5=new JButton("Menu");
            btn5.setFont(new Font("Serif", Font.PLAIN, 10));
            btn5.setBackground(Color.BLACK);
            btn5.setOpaque(true);
            btn5.setForeground(Color.WHITE);
            btn5.setBounds(10, 10, 75, 75);
            btn5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        interfazInicial();
                        c.setNumPlayer(0);
                        c.setCircuito(-1);
                        removeElements1();
                    }
            });
            this.add(btn5);

            this.requestFocus();//devuelve el foco al jframe para el keyListener

            c.setNewGame();

            //aniado timer
            timer = new JLabel();
            timer.setText("60");
            timer.setForeground(Color.WHITE);
            timer.setFont(new Font("Serif", Font.BOLD, 50));
            timer.setBounds(10, 100, 50, 50);
            this.add(timer);
            
            //aniado contador
            cont = new JLabel();
            cont.setText("0");
            cont.setForeground(Color.WHITE);
            cont.setFont(new Font("Serif", Font.BOLD, 100));
            switch(c.getCircuito()){
                case 0:
                    cont.setBounds(650, 350, 100, 100);
                    break;
                case 1:
                    cont.setBounds(650, 325, 100, 100);
                    break;
                default:
                    break;
            }
            this.add(cont);

            //aniado ovni
            ovni = new Ovni(1);
            switch(c.getCircuito()){
                case 0:
                    ovni.setX(160);
                    ovni.setY(400);
                    ovni.setBounds(ovni.getX(), ovni.getY(), 75, 75);
                    c.setCircuito(0);
                    break;
                case 1:
                    ovni.setX(360);
                    ovni.setY(420);
                    ovni.setBounds(ovni.getX(), ovni.getY(), 75, 75);
                    c.setCircuito(1);
                    break;
            }
            c.setOvni(ovni);
            this.add(ovni);

            //aniado pista
            p=new Pista(c.getCircuito());
            p.setBounds(0, 0, 1365, 740);
            this.add(p);
        
        numerovista=3;
    }
    
    /**
     * eliminar elementos game 1 player
     */
    public void removeElements1(){
        timer.setVisible(false);
        ovni.setVisible(false);
        p.setVisible(false);
        cont.setVisible(false);
        btn5.setVisible(false);
        this.remove(timer);
        this.remove(ovni);
        this.remove(p);
        this.remove(cont);
        this.remove(btn5);
    }
    
    /**
     * vista juego 2 player
     */
    public void game2(){
        
        if(numerovista!=3){
            title.setVisible(false);
            this.remove(title);
            f2.setVisible(false);
            this.remove(f1);
            this.remove(f2);
            btn3.setVisible(false);
            btn4.setVisible(false);
            this.remove(btn1);
            this.remove(btn2);
            this.remove(btn3);
            this.remove(btn4);
        }else{
            removeElements2();
        }
            barraMenu=new BarraMenu(2,this);
            this.setJMenuBar(barraMenu);

            //boton vuelta a menu
            btn5=new JButton("Menu");
            btn5.setFont(new Font("Serif", Font.PLAIN, 10));
            btn5.setBackground(Color.BLACK);
            btn5.setForeground(Color.WHITE);
            btn5.setBounds(10, 10, 75, 75);
            btn5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        interfazInicial();
                        c.setNumPlayer(0);
                        c.setCircuito(-1);
                        removeElements2();
                    }
            });
            this.add(btn5);

            this.requestFocus();//devuelve el foco al jframe para el keyListener


            c.setNewGame();

            //aniado contador jug1
            cont = new JLabel();
            cont.setText("0");
            cont.setForeground(Color.WHITE);
            cont.setFont(new Font("Serif", Font.BOLD, 100));
            switch(c.getCircuito()){
                case 0:
                    cont.setBounds(575, 350, 100, 100);
                    break;
                case 1:
                    cont.setBounds(575, 325, 100, 100);
                    break;
                default:
                    break;
            }
            this.add(cont);

            //aniado contador jug2
            cont2 = new JLabel();
            cont2.setText("0");
            cont2.setForeground(Color.WHITE);
            cont2.setFont(new Font("Serif", Font.BOLD, 100));
            switch(c.getCircuito()){
                case 0:
                    cont2.setBounds(750, 350, 100, 100);
                    break;
                case 1:
                    cont2.setBounds(750, 325, 100, 100);
                    break;
                default:
                    break;
            }
            this.add(cont2);

            //aniado ovni 1
            ovni = new Ovni(1);
            switch(c.getCircuito()){
                case 0:
                    if(c.getNumPlayer()==1){
                        ovni.setX(160);
                        ovni.setY(400);
                    }else{
                        ovni.setX(100);
                        ovni.setY(400);
                    }
                    ovni.setBounds(ovni.getX(), ovni.getY(), 75, 75);
                    c.setCircuito(0);
                    break;
                case 1:
                    if(c.getNumPlayer()==1){
                        ovni.setX(360);
                        ovni.setY(420);
                    }else{
                        ovni.setX(340);
                        ovni.setY(420);
                    }
                    ovni.setBounds(ovni.getX(), ovni.getY(), 75, 75);
                    c.setCircuito(1);
                    break;
            }
            c.setOvni(ovni);
            this.add(ovni);

            if(c.getNumPlayer()==2){
                //aniado ovni 2
                ovni2 = new Ovni(2);
                switch(c.getCircuito()){
                    case 0:
                        ovni2.setX(200);
                        ovni2.setY(470);
                        ovni2.setBounds(ovni2.getX(), ovni2.getY(), 75, 75);
                        c.setCircuito(0);
                        break;
                    case 1:
                        ovni2.setX(410);
                        ovni2.setY(460);
                        ovni2.setBounds(ovni2.getX(), ovni2.getY(), 75, 75);
                        c.setCircuito(1);
                        break;
                }
                c.setOvni2(ovni2);
                this.add(ovni2);
            }
            //aniado pista
            p=new Pista(c.getCircuito());
            p.setBounds(0, 0, 1365, 740);
            this.add(p);
            numerovista=3;
    }
    
    /**
     * eliminar elementos game 2 player
     */
    public void removeElements2(){
        ovni.setVisible(false);
        ovni2.setVisible(false);
        p.setVisible(false);
        cont.setVisible(false);
        cont2.setVisible(false);
        btn5.setVisible(false);
        this.remove(ovni);
        this.remove(ovni2);
        this.remove(p);
        this.remove(cont);
        this.remove(cont2);
        this.remove(btn5);
    }
    
    /**
     * actualizar contador 1
     * @param c 
     */
    public void actualizarContador(String c){
        cont.setText(c);
    }
    
    /**
     * actualizar contador 2
     * @param c 
     */
    public void actualizarContador2(String c){
        cont2.setText(c);
    }
    
    /**
     * actualizar timer
     * @param c 
     */
    public void actualizarTimer(String c){
        timer.setText(c);
    }
}
