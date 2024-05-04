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

import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author eduar
 */
public class BarraMenu extends JMenuBar {

    JMenu menu,menu2;
    JMenuItem menuItemSalir,menuItemOne,menuItemTwo,menuItemThree,menuItemGenerarPDF;
    Vista v;
    ControladorMenu cm;
    public BarraMenu(int estado,Vista v) {
        this.v=v;
        cm=new ControladorMenu(v);
        switch(estado){
            case 0:
                menu = new JMenu("File");
                menu2 = new JMenu("Game");
                menuItemSalir = new JMenuItem("Exit");
                menuItemSalir.setAccelerator(KeyStroke.getKeyStroke('0', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menu.add(menuItemSalir);
                menuItemSalir.addActionListener(cm);
                menuItemOne = new JMenuItem("1 Player"); 
                menuItemTwo = new JMenuItem("2 Player");
                menuItemOne.setAccelerator(KeyStroke.getKeyStroke('1', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menuItemTwo.setAccelerator(KeyStroke.getKeyStroke('2', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menuItemOne.addActionListener(cm);
                menuItemTwo.addActionListener(cm);
                menu2.add(menuItemOne);
                menu2.add(menuItemTwo);
                this.add(menu);   
                this.add(menu2);
                break;
            case 1:
                menu = new JMenu("File");
                menu2 = new JMenu("Game");
                menuItemSalir = new JMenuItem("Exit");
                menuItemSalir.setAccelerator(KeyStroke.getKeyStroke('0', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menu.add(menuItemSalir);
                menuItemSalir.addActionListener(cm);
                menuItemOne = new JMenuItem("Rectangle Circuit"); 
                menuItemTwo = new JMenuItem("Circle Circuit");
                menuItemOne.setAccelerator(KeyStroke.getKeyStroke('1', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menuItemTwo.setAccelerator(KeyStroke.getKeyStroke('2', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menuItemOne.addActionListener(cm);
                menuItemTwo.addActionListener(cm);
                menu2.add(menuItemOne);
                menu2.add(menuItemTwo);
                this.add(menu);   
                this.add(menu2);
                break;
            case 2:
                menu = new JMenu("File");
                menu2 = new JMenu("Game");
                
                menuItemSalir = new JMenuItem("Exit");
                menuItemSalir.setAccelerator(KeyStroke.getKeyStroke('0', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menuItemSalir.addActionListener(cm);
                menu.add(menuItemSalir);
                
                menuItemGenerarPDF = new JMenuItem("Generate PDF");
                menuItemGenerarPDF.setAccelerator(KeyStroke.getKeyStroke('4', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menuItemGenerarPDF.addActionListener(cm);
                menuItemGenerarPDF.setVisible(false);
                menu.add(menuItemGenerarPDF);
                
                
                menuItemOne = new JMenuItem("Pause"); 
                menuItemOne.setAccelerator(KeyStroke.getKeyStroke('1', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menuItemOne.addActionListener(cm);
                menuItemTwo = new JMenuItem("Menu"); 
                menuItemTwo.setAccelerator(KeyStroke.getKeyStroke('2', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menuItemTwo.addActionListener(cm);
                menuItemTwo.setVisible(false);
                menuItemThree = new JMenuItem("New Game"); 
                menuItemThree.setAccelerator(KeyStroke.getKeyStroke('3', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                menuItemThree.addActionListener(cm);
                menuItemThree.setVisible(false);
                menu2.add(menuItemOne);
                menu2.add(menuItemTwo);
                menu2.add(menuItemThree);
                this.add(menu);   
                this.add(menu2);
                break;
            default:
                break;
        }
        
    }
    public void setVisibleItemsGameOver(){
        menuItemTwo.setVisible(true);
        menuItemThree.setVisible(true);
        menuItemGenerarPDF.setVisible(true);
    }
}
