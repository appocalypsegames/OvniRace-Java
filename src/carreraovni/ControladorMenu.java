/*
 * Copyright (C) 2018 eduar
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package carreraovni;

import com.itextpdf.text.DocumentException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduar
 */
public class ControladorMenu implements ActionListener{
    Vista v;
    public ControladorMenu(Vista v){
        this.v=v;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Exit":
                System.exit(0);
                break;
            case "1 Player":
                v.c.setNumPlayer(1);
                v.menuPista();
                break;
            case "2 Player":
                v.c.setNumPlayer(2);
                v.menuPista();
                break;
            case "Rectangle Circuit":
                v.c.setCircuito(0);
                switch(v.c.getNumPlayer()){
                        case 1:
                            v.game();
                            break;
                        case 2:
                            v.game2();
                            break;
                        default:
                            break;
                }
                break;
            case "Circle Circuit":
                v.c.setCircuito(1);
                switch(v.c.getNumPlayer()){
                        case 1:
                            v.game();
                            break;
                        case 2:
                            v.game2();
                            break;
                        default:
                            break;
                }
                break;
            case "Pause":
            case "Start":
                if(v.c.getPause()){
                    v.c.setPause(false);
                    v.barraMenu.menuItemOne.setText("Pause");
                }else{
                    v.c.setPause(true);
                    v.barraMenu.menuItemOne.setText("Start");
                }
                break;
            case "Menu":
                v.c.setCircuito(-1);
                switch(v.c.getNumPlayer()){
                    case 1:
                        v.removeElements1();
                        break;
                    case 2:
                        v.removeElements2();
                        break;
                    default:
                        break;
                }
                v.interfazInicial();
                v.c.setNumPlayer(0);
                break;
            case "New Game":
                switch(v.c.getNumPlayer()){
                    case 1:
                        v.game();
                        break;
                    case 2:
                        v.game2();
                        break;
                    default:
                        break;
                }
            case "Generate PDF":
            {
            try {
                v.c.createPDF();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            default:
                break;
        }
    }
    
}
