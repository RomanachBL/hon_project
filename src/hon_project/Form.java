package hon_project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Form {
	
	// Left -> On initialise les zones de textes et leurs labels
    private JPanel left = new JPanel();
	private JLabel label_1 = new JLabel("Lieu : ");
	private JTextField jtf_1 = new JTextField();
	private JLabel label_2 = new JLabel("Distance (km) : ");
	private JTextField jtf_2 = new JTextField();
	private JLabel label_3 = new JLabel("Prix de l'essence (€/L) : ");
	private JTextField jtf_3 = new JTextField();
	private JLabel label_4 = new JLabel("Consommation (L/100) : ");
	private JTextField jtf_4 = new JTextField();
	  
	// Right _> La zone résultat
    private JPanel right = new JPanel();
	private JLabel res = new JLabel();
	private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00"); //Pour sortir un chiffre dans setText
	
	// Getters & Setters
	public JPanel getLeft() {
		return left;
	}
	public void setLeft(JPanel left) {
		this.left = left;
	}
	public JPanel getRight() {
		return right;
	}
	public void setRight(JPanel right) {
		this.right = right;
	}


	public Form() {
    	
// ***************** La zone de texte **********************************
        Font police = new Font("Arial", Font.BOLD, 14);
        // 1er
        jtf_1.setFont(police);
        jtf_1.setPreferredSize(new Dimension(200, 40));
        left.add(label_1);
        left.add(jtf_1);
        // 2e
        jtf_2.setFont(police);
        jtf_2.setPreferredSize(new Dimension(200, 40));
        left.add(label_2);
        left.add(jtf_2);
        // 3e
        jtf_3.setFont(police);
        jtf_3.setPreferredSize(new Dimension(200, 40));
        left.add(label_3);
        left.add(jtf_3);  
        // 4e
        jtf_4.setFont(police);
        jtf_4.setPreferredSize(new Dimension(200, 40));
        left.add(label_4);
        left.add(jtf_4);       
        
//***************** Zone resultats ***************************************
        right.add(res);

// ***************** Le bouton *******************************************

        JButton btn = new JButton("Valider");
        
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

     	
	}
}
