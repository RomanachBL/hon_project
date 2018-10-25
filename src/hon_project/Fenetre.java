package hon_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame {
	
    private JPanel panneau = new Panneau();
	
	// On initialise les zones de textes et leurs labels	  
	private JLabel label_1 = new JLabel("Lieu : ");
	private JTextField jtf_1 = new JTextField();
	private JLabel label_2 = new JLabel("Distance (km) : ");
	private JTextField jtf_2 = new JTextField();
	private JLabel label_3 = new JLabel("Prix de l'essence (€/L) : ");
	private JTextField jtf_3 = new JTextField();
	private JLabel label_4 = new JLabel("Consommation (L/100) : ");
	private JTextField jtf_4 = new JTextField();
	  
	// On initialise le bouton de validation
	private JButton btn = new JButton("Valider");
	
	// La zone résultat
	private JLabel res = new JLabel();
	private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00"); //Pour sortir un chiffre dans setText
	
    public Fenetre(){
    	// Juste pour récupérer la dimension de l'écran
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	// --------> La fenetre
        this.setTitle("Ma fenêtre Java");
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // --------> La zone de texte
        JPanel left = new JPanel();
        Font police = new Font("Arial", Font.BOLD, 14);
        // Pierre
        jtf_1.setFont(police);
        jtf_1.setPreferredSize(new Dimension(200, 40));
        left.add(label_1);
        left.add(jtf_1);
        // Paul
        jtf_2.setFont(police);
        jtf_2.setPreferredSize(new Dimension(200, 40));
        left.add(label_2);
        left.add(jtf_2);
        // Jacques
        jtf_3.setFont(police);
        jtf_3.setPreferredSize(new Dimension(200, 40));
        left.add(label_3);
        left.add(jtf_3);  
        // azerty
        jtf_4.setFont(police);
        jtf_4.setPreferredSize(new Dimension(200, 40));
        left.add(label_4);
        left.add(jtf_4);
        
        //Zone res
        JPanel right = new JPanel();
        right.add(res);

        // -------> Le bouton
        			// L'action du bouton
        btn.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) { 
        		double x, y, z;
        		x = Double.valueOf(jtf_2.getText()); // dist
        		y = Double.valueOf(jtf_3.getText()); // Essence
        		z = Double.valueOf(jtf_4.getText()); // Consommation
        	    //System.out.println(x+y+z);
        	    
        	    res.setText("Le trajet pour aller à/chez " + jtf_1.getText() + " me coute " + DECIMAL_FORMAT.format(y*((x)/(100/z))) + " € l'aller et " + DECIMAL_FORMAT.format(y*((x+x)/(100/z))) + " € aller/retour");
        	} 
        });
        
        left.add(btn);
        
        // #########################  Partie placement / Layout !  ###################################
        
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
        
        // ######################################## END ##############################################
        
        // -------> On 'add' dans le container 
        container.add(panneau);  
        container.add(left, new Integer(1));  
        container.add(right, new Integer(1));
        
        // Affichons
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(container);
        this.setVisible(true);

    }

}
          
