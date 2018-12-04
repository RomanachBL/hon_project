package hon_project;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g){
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
        int height = dim.height;
        int width = dim.width;
        
    	Font font = new Font("Times New Roman", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.BLACK);          
        g.drawString("Honoraires :", 150, 100); 
        
    	
        Graphics2D g2d = (Graphics2D) g;
        
        Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.07f);
        g2d.setComposite(c);
        
        Font font2 = new Font("Times New Roman", Font.BOLD, 170);
        g2d.setFont(font2);
        g2d.setColor(Color.BLACK);   
        AffineTransform affinetransform = new AffineTransform();     
        FontRenderContext frc = new FontRenderContext(affinetransform,true,true); 
        int textwidth = (int)(font2.getStringBounds("CALCULI", frc).getWidth());
        //int textheight = (int)(font2.getStringBounds("CALCULI", frc).getHeight());
        //System.out.println(textwidth);
        g2d.drawString("CALCULI", (int) ((width - textwidth)/1.07), (int) (height/1.12));
        
        
         
        
      //  try {

          //  Image img = ImageIO.read(new File ("caducée_2.png"));
            
            //On met l'image au milieu avec Graphics2D

          //  int x = (this.getWidth() - img.getWidth(null)) / 2;
        //    int y = (this.getHeight() - img.getHeight(null)) / 2;
            

            
            //On met l'opacity
           // float opacity = 0.7f;
           // g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            
            //Et on l'affiche
         //   g2d.drawImage(img, x, y, null);

            
       //   } catch (IOException e) {
        //    e.printStackTrace();
        //  }     
    }

}