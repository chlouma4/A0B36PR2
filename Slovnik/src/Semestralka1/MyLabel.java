/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semestralka1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author Marco
 */
public class MyLabel extends JLabel {
 private Gui gui;
 private int setGui;
    public MyLabel(final Gui gui, final int setGui){
        super();
        this.gui=gui;
        this.setGui=setGui;
        this.setVisible(true);
         this.addMouseListener(new MouseListener() {

             @Override
        public void mouseClicked(MouseEvent e) {    
            gui.setMyView(setGui);
        }

             @Override
        public void mousePressed(MouseEvent e) {
        }

             @Override
        public void mouseReleased(MouseEvent e) {
        }

             @Override
        public void mouseEntered(MouseEvent e) {
       setForeground(Color.white);
                 setFont(new Font(null,Font.BOLD,12));
          
        }

             @Override
        public void mouseExited(MouseEvent e) {
                 setForeground(Color.black);
            setFont(new Font(null,Font.PLAIN,11));
        }
    });                }

    
}
