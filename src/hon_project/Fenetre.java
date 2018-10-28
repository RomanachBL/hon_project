package hon_project;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
    private JPanel panneau = new Panneau();
    private Form form = new Form();
    
    JPanel left = form.getLeft();
    JPanel right = form.getRight();
    
    public Fenetre(){
    	
		// Juste pour récupérer la dimension de l'écran
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	// ***************** Fenetre *******************************************
        this.setTitle("Ma fenêtre Java");
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
     // ################  Partie placement / Layout !  #########################

		// On initialise le container principal
        JLayeredPane container = new JLayeredPane();

		// On donne les dimensions etc .. de panneau et left
        panneau.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
        left.setBounds(50, 100, 350, 200);  

		// On dit que left sera un GridLayout
        GridLayout grid = new GridLayout(5, 0);
        left.setLayout(grid);
        grid.setVgap(20);

		// Zone res
        right.setBounds(0, 100, (int) dim.getWidth(), 50); 
        //right.setLayout(grid);

     	// ############################# END #######################################
     	

        // ***************** On 'add' tout dans le container  **********************
        container.add(panneau);  
        container.add(left, new Integer(1));
        container.add(right, new Integer(1));
        
        // *************************************************************************
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(container);
        this.setVisible(true);

    }

}
          
