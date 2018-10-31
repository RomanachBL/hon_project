package hon_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Form {
	private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");
	
	// Left -> On initialise les zones de textes et leurs labels
    private JPanel left = new JPanel();
	private JLabel label_nom = new JLabel("Nom : ");
	private JTextField jtf_nom = new JTextField();
	private JLabel label_ifa = new JLabel("IFA : ");
	private JCheckBox cb_ifa = new JCheckBox();
	private JLabel label_km = new JLabel("IK : ");
	private JFormattedTextField jtf_km = new JFormattedTextField(NumberFormat.getNumberInstance());
	
	private JLabel label_ami = new JLabel("AMI (1) :");
	private JComboBox combo_ami = new JComboBox();	
	private JLabel label_ami2 = new JLabel("AMI (2) :");
	private JComboBox combo_ami2 = new JComboBox();	
	private JLabel label_ais = new JLabel("AIS :");
	private JComboBox combo_ais = new JComboBox();	
	
	private JLabel label_mau = new JLabel("MAU : ");
	private JCheckBox cb_mau = new JCheckBox();
	private JLabel label_mci = new JLabel("MCI : ");
	private JCheckBox cb_mci = new JCheckBox();
	private JLabel label_jfd = new JLabel("Dimanche / Jour ferié : ");
	private JCheckBox cb_jfd = new JCheckBox();
	private JLabel label_nuit = new JLabel("Nuit : ");
	private JCheckBox cb_nuit = new JCheckBox();

	// Right _> La zone résultat
    //private JPanel right = new JPanel();
	//private JLabel res = new JLabel();
	//private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00"); //Pour sortir un chiffre dans setText
	
	// Getters & Setters
	public JPanel getLeft() {
		return left;
	}
	public void setLeft(JPanel left) {
		this.left = left;
	}
/*	public JPanel getRight() {
		return right;
	}
	public void setRight(JPanel right) {
		this.right = right;
	}
*/

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Form() {
    	
		// ***************** La zone du form **********************************
		
        Font police = new Font("Arial", Font.BOLD, 14);
        // NOM
        jtf_nom.setFont(police);
        jtf_nom.setPreferredSize(new Dimension(100, 40));
        left.add(label_nom);
        left.add(jtf_nom);
        
        // IFA
        left.add(label_ifa);
        left.add(cb_ifa);
              
        // KM
        jtf_km.setFont(police);
        jtf_km.setPreferredSize(new Dimension(100, 40));    
        jtf_km.disable();
        jtf_km.setBackground(Color.LIGHT_GRAY);
        label_km.setForeground(Color.LIGHT_GRAY);
        
        cb_ifa.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    jtf_km.enable();
                    jtf_km.setBackground(Color.WHITE);
                    label_km.setForeground(Color.BLACK);
                } else {
                	jtf_km.disable();
                	jtf_km.setBackground(Color.LIGHT_GRAY);
                	label_km.setForeground(Color.LIGHT_GRAY);
                };
            }
        });
        
        left.add(label_km);
        left.add(jtf_km);  
    
        // AMI 1
        combo_ami.setPreferredSize(new Dimension(100, 20));
        combo_ami.addItem("0");
        combo_ami.addItem("1");
        combo_ami.addItem("1.25");
        combo_ami.addItem("1.5");
        combo_ami.addItem("2");
        combo_ami.addItem("2.25");
        combo_ami.addItem("2.5");
        combo_ami.addItem("3");
        combo_ami.addItem("3.5");
        combo_ami.addItem("4");
        combo_ami.addItem("4.1");
        combo_ami.addItem("4.5");
        combo_ami.addItem("15");
        combo_ami.setPreferredSize(new Dimension(100, 20));
        left.add(label_ami);
        left.add(combo_ami);
        
        // AMI 2
        combo_ami2.setPreferredSize(new Dimension(100, 20));
        combo_ami2.addItem("0");
        combo_ami2.addItem("0.5");
        combo_ami2.addItem("0.625");
        combo_ami2.addItem("0.75");
        combo_ami2.addItem("1");
        combo_ami2.addItem("1.125");
        combo_ami2.addItem("1.25");
        combo_ami2.addItem("1.5");
        combo_ami2.addItem("1.75");
        combo_ami2.addItem("2");
        combo_ami2.addItem("2.05");
        combo_ami2.addItem("2.25");
        combo_ami2.addItem("7.5");
        combo_ami2.setPreferredSize(new Dimension(100, 20));
        
        combo_ami2.disable();
        combo_ami2.setBackground(Color.LIGHT_GRAY);
        label_ami2.setForeground(Color.LIGHT_GRAY);       
        
        combo_ami.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(combo_ami.getSelectedItem().equals("0")) {
                	combo_ami2.disable();
                    combo_ami2.setBackground(Color.LIGHT_GRAY);
                    label_ami2.setForeground(Color.LIGHT_GRAY);
                } else {
                	combo_ami2.enable();
                    combo_ami2.setBackground(Color.WHITE);
                    label_ami2.setForeground(Color.BLACK);
                }
            }
        });
        
        left.add(label_ami2);
        left.add(combo_ami2);
        
        // AIS
        combo_ais.setPreferredSize(new Dimension(100, 20));
        combo_ais.addItem("0");
        combo_ais.addItem("1");
        combo_ais.addItem("2");
        combo_ais.addItem("3");
        combo_ais.addItem("4");
        combo_ais.setPreferredSize(new Dimension(100, 20));
        left.add(label_ais);
        left.add(combo_ais);
        
        // MAU
        left.add(label_mau);
        left.add(cb_mau);
        
        // MCI
        left.add(label_mci);
        left.add(cb_mci);
        
        //D, JF
        left.add(label_jfd);
        left.add(cb_jfd);
        
        // Nuit
        left.add(label_nuit);
        left.add(cb_nuit);
        
        
        //***************** Resultats ***************************************
        
        

        // ***************** Le bouton *******************************************

        JButton btn = new JButton("Valider");
                    
        btn.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent event) { 
        		
        		//Récupération des variables
        		String name = jtf_nom.getText();
        		double ifa = 0; 
        		if(cb_ifa.isSelected()) {ifa = 2.5; }else{ ifa = 0; }

        		double ik = 0; 
        		if(jtf_km.getText().equals("")){ 
        			ik = 0; 
        		}else{
        			ik = Double.valueOf(jtf_km.getText()); 
        		}
        		
				double ami1 = Double.valueOf(combo_ami.getSelectedItem().toString());
        		double ami2 = Double.valueOf(combo_ami2.getSelectedItem().toString());
        		double ais = Double.valueOf(combo_ais.getSelectedItem().toString());
        		double mau = 0; if(cb_mau.isSelected()){ mau = 1.35; }else{ mau = 0; }
        		double mci = 0;	if(cb_mci.isSelected()){ mci = 5; }else{ mci = 0; }
        		double jfd = 0; if(cb_jfd.isSelected()){ jfd = 8.5; }else{ jfd = 0; }
        		double nuit = 0; if(cb_nuit.isSelected()){ nuit = 9.15; }else{ nuit = 0; }

        		// Le calcul
        		double calc = (ifa+(0.35*ik)+(3.15*ami1)+(3.15*ami2)+(2.65*ais)+mau+mci+jfd+nuit);
        		final NumberFormat instance = NumberFormat.getNumberInstance();
        		instance.setMaximumFractionDigits(2);
        		String s=instance.format(calc); 
        		
        		// Et on affiche dans le terminal ... pour l'instant :)       		
        		System.out.println("Total pour  +name+ ->  +(ifa+(0.35*ik)+(3.15*ami1)+(3.15*ami2)+(2.65*ais)+mau+mci+jfd+nuit)+  €");
        		System.out.println("-----------------------------------------------------------------------------------------------");
        		System.out.println("Total pour "+name+"-> "+s+" €");
	        		
        	} 
        });
        
        left.add(btn);
	}
}
