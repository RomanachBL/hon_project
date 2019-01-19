package hon_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panneau = new Panneau();
    private Form form = new Form();
    
    
    // On récupère 'Left' et 'Right' grâce aux getters de la classe 'Form'
    JPanel left = form.getLeft();
    JPanel patients = form.getPat();
    
    public Fenetre(){
    	
		// Juste pour récupérer la dimension de l'écran (on l'utilise plus tard)
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	
    	// ***************** Fenetre *******************************************  
    	
        this.setTitle("Calculi");
        this.pack();
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setSize(800, 600);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // ################  Partie placement / Layout !  #########################

		// On initialise le container principal
        JLayeredPane container = new JLayeredPane();

		// On donne les dimensions de 'panneau', 'left' et 'right'
        panneau.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
        left.setBounds(100, 150, 450, 615); 
        patients.setBounds(700, 150, 300, 25); 


     	// ############################# END #######################################
     	

        // ***************** On 'add' tout dans le container  **********************
        container.add(panneau);  
        container.add(left, new Integer(1));
        container.add(patients, new Integer(1));
        
        // *************************************************************************
        
        this.setContentPane(container);
        this.setVisible(true);

    }

}
          
