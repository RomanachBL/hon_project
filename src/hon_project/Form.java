package hon_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
	private JTextField jtf_km = new JTextField();

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
	private JLabel label_file = new JLabel("Nom du fichier : ");
	private JTextField jtf_file = new JTextField();
	

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
        combo_ami.setPreferredSize(new Dimension(100, 15));
        left.add(label_ami);
        left.add(combo_ami);
        
        // AMI 2
        combo_ami2.setPreferredSize(new Dimension(100, 15));
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
        combo_ami2.setPreferredSize(new Dimension(100, 15));
        
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
        combo_ais.setPreferredSize(new Dimension(100, 15));
        combo_ais.addItem("0");
        combo_ais.addItem("1");
        combo_ais.addItem("2");
        combo_ais.addItem("3");
        combo_ais.addItem("4");
        combo_ais.setPreferredSize(new Dimension(100, 15));
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
        
     // KM
        jtf_file.setFont(police);
        jtf_file.setPreferredSize(new Dimension(100, 15));    
        
        left.add(label_file);
        left.add(jtf_file);  
        
        
        //***************** Resultats ***************************************
        
        

        // ***************** Le bouton *******************************************

        JButton btn = new JButton("Valider");
                    
        btn.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent event) { 
        		
        		//Récupération des variables
        		String name = jtf_nom.getText();
        		
        		String ifa_n;
        		double ifa = 0; 
        		if(cb_ifa.isSelected()) {ifa = 2.5; ifa_n = "oui"; }else{ ifa = 0; ifa_n = "non"; }

        		double ik = 0; 
        		if(jtf_km.getText().equals("")){ 
        			ik = 0; 
        		}else{
        			ik = Double.valueOf(jtf_km.getText()); 
        		}
        		
				double ami1 = Double.valueOf(combo_ami.getSelectedItem().toString());
        		double ami2 = Double.valueOf(combo_ami2.getSelectedItem().toString());
        		double ais = Double.valueOf(combo_ais.getSelectedItem().toString());
        		String mau_n;
        		double mau = 0; if(cb_mau.isSelected()){ mau = 1.35; mau_n = "oui"; }else{ mau = 0; mau_n = "non"; }
        		String mci_n;
        		double mci = 0;	if(cb_mci.isSelected()){ mci = 5; mci_n = "oui"; }else{ mci = 0; mci_n = "non"; }
        		String jfd_n;
        		double jfd = 0; if(cb_jfd.isSelected()){ jfd = 8.5; jfd_n = "oui"; }else{ jfd = 0; jfd_n = "non"; }
        		String nuit_n;
        		double nuit = 0; if(cb_nuit.isSelected()){ nuit = 9.15; nuit_n = "oui"; }else{ nuit = 0; nuit_n = "non"; }

        		// Le calcul
        		double calc = (ifa+(0.35*ik)+(3.15*ami1)+(3.15*ami2)+(2.65*ais)+mau+mci+jfd+nuit);
        		final NumberFormat instance = NumberFormat.getNumberInstance();
        		instance.setMaximumFractionDigits(2);
        		String total=instance.format(calc); 
        		
        		// Et on affiche dans le terminal ... pour l'instant :)       		
        		//System.out.println("Total pour  +name+ ->  +(ifa+(0.35*ik)+(3.15*ami1)+(3.15*ami2)+(2.65*ais)+mau+mci+jfd+nuit)+  €");
        		//System.out.println("-----------------------------------------------------------------------------------------------");
        		System.out.println("Total pour "+name+" -> "+total+" €");
        		
        		// ############## Ecriture dans le fichier texte ################
        		
        		try {
                    String myFile = jtf_file.getText()+".txt";
        			File file = new File (myFile);
        			
        			PrintWriter fich;
        			
                    // 1) Instanciation de l'objet
                    fich = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                  
                    System.out.println("Fichier texte créé !\n\r");
                    
                    try {

                    	// =============> On affiche l'en-tête s'il n'y est pas 
                    	if (file.length() == 0) {
                    		fich.write("           |     |    |      |      |     |     |     |         |      ||       \n");
                    		fich.write("    NOM    | IFA | IK | AMI1 | AMI2 | AIS | MAU | MCI | Dim. JF | NUIT || Total \n");
                    		fich.write("           |     |    |      |      |     |     |     |         |      ||       \n");
                    		fich.write("--------------------------------------------------------------------------------\n");
                    	}
                    	
                    	// On gère le nombre de caractères des variables
                    	//String.format("%-10s", name);
                    	
                        // 2) Utilisation de l'objet
                    	fich.write("           |     |    |      |      |     |     |     |         |      ||       \n");
                    	fich.write(" "+String.format("%-10s", name)+"| "+ifa_n+" |"+DECIMAL_FORMAT.format(0.35*ik)+"| "+DECIMAL_FORMAT.format(3.15*ami1)+" | "+DECIMAL_FORMAT.format(3.15*ami2)+" |"+DECIMAL_FORMAT.format(2.65*ais)+" | "+mau_n+" | "+mci_n+" |   "+jfd_n+"   | "+nuit_n+"  || "+total+"\n");
                    	fich.write("           |     |    |      |      |     |     |     |         |      ||       \n");
                		fich.write("--------------------------------------------------------------------------------\n");
                        //fich.write(name+" -> IFA : "+ifa_n+"("+ifa+") ; IK : "+ik+"("+DECIMAL_FORMAT.format(0.35*ik)+") ; AMI 1 : "+ami1+"("+DECIMAL_FORMAT.format(3.15*ami1)+") ; AMI 2 : "+ami2+"("+DECIMAL_FORMAT.format(3.15*ami2)+") ; AMI 1 : "+ais+"("+DECIMAL_FORMAT.format(2.65*ais)+") ; MAU : "+mau_n+"("+mau+") ; MCI : "+mci_n+"("+mci+") ; Dim. Ferié : "+jfd_n+"("+jfd+") ; Nuit : "+nuit_n+"("+nuit+") || Total = "+total+" €\n\r");
                      
                    } finally {
                      
                        // 3) Libération de la ressource exploitée par l'objet
                        fich.close();
                      
                    }
                  
        		} catch (IOException e) {
                    e.printStackTrace();
        		}
        	    
        		// ############## Fin Ecriture !!!!!! ################ 
        		
        		// On réinitialise les champs
        		jtf_nom.setText("");
        		jtf_km.setText("");
        		cb_ifa.setSelected(false);
        		cb_mau.setSelected(false);
        		cb_mci.setSelected(false);
        		cb_jfd.setSelected(false);
        		cb_nuit.setSelected(false);
        		combo_ami.setSelectedIndex(0);
        		combo_ami2.setSelectedIndex(0);
        		combo_ais.setSelectedIndex(0);
        	
        	} 
        });
        
        left.add(btn);
	}
}
