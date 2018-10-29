package hon_project;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g){
    	Font font = new Font("Courier", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.DARK_GRAY);          
        g.drawString("Honoraires :", 20, 40); 

        try {
        	
            Image img = ImageIO.read(new File ("img/2695.png"));
            
            //On met l'image au milieu avec Graphics2D
            Graphics2D g2d = (Graphics2D) g;
            int x = (this.getWidth() - img.getWidth(null)) / 2;
            int y = (this.getHeight() - img.getHeight(null)) / 2;
            
            //On met l'opacity
            float opacity = 0.3f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            
            //Et on l'affiche
            g2d.drawImage(img, x, y, null);

            
          } catch (IOException e) {
            e.printStackTrace();
          }     
    }

}