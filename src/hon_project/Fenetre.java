package hon_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame {
	
	  //On initialise les zones de textes et leurs labels
	  private JPanel container = new JPanel();
	  private JLabel label_1 = new JLabel("Pierre : ");
	  private JTextField jtf_1 = new JTextField();
	  private JLabel label_2 = new JLabel("Paul : ");
	  private JTextField jtf_2 = new JTextField();
	  private JLabel label_3 = new JLabel("Jacques : ");
	  private JTextField jtf_3 = new JTextField();
	
    public Fenetre(){

    	// La fenetre
        this.setTitle("Ma fenêtre Java");
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // La zone de texte
        JPanel top = new JPanel();
        Font police = new Font("Arial", Font.BOLD, 14);
        // Pierre
        jtf_1.setFont(police);
        jtf_1.setPreferredSize(new Dimension(150, 30));
        top.add(label_1);
        top.add(jtf_1);
 /*       // Paul
        jtf_2.setFont(police);
        jtf_2.setPreferredSize(new Dimension(150, 30));
        top.add(label_2);
        top.add(jtf_2);
        //Jacques
        jtf_3.setFont(police);
        jtf_3.setPreferredSize(new Dimension(150, 30));
        top.add(label_3);
        top.add(jtf_3);
*/        
        // Les add 
        //container.setLayout(new GridLayout(2,0));
        container.add(new Panneau());  
        container.add(top);  
        
        // Affichons
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(container);
        this.setVisible(true);

    }

}
          
