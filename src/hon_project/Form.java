package hon_project;


import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


public class Form {
	private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("##,##00.00");
	
	// Left -> On initialise les zones de textes et leurs labels
    private JPanel left = new JPanel();
    private JPanel patients = new JPanel();
    
    
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
	private JLabel label_jfd = new JLabel("Dimanche / Jour feri� : ");
	private JCheckBox cb_jfd = new JCheckBox();
	private JLabel label_nuit = new JLabel("Nuit : ");
	private JCheckBox cb_nuit = new JCheckBox();
	private JLabel label_file = new JLabel("Nom du fichier : ");
	private JTextField jtf_file = new JTextField();
	
	private JLabel label_parc = new JLabel();
    public JFileChooser fc = new JFileChooser();
    
    private JLabel label_patients = new JLabel("Patient :");
	private JComboBox combo_patients = new JComboBox();	

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
	public JPanel getPat() {
		return patients;
	}
	public void setPat(JPanel patients) {
		this.patients = patients;
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	public Form() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		// ***************** La zone du form **********************************
		left.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0,0,20,30);
		c.anchor = GridBagConstraints.WEST;
		
        Font police = new Font("Arial", Font.BOLD, 14);
        Font police_label = new Font("Times New Roman", Font.CENTER_BASELINE, 15);
        // NOM
        jtf_nom.setFont(police);
        label_nom.setFont(police_label);
        jtf_nom.setPreferredSize(new Dimension(200, 20));
        c.gridx = 0;
        c.gridy = 0;
        left.add(label_nom, c);
        c.gridx = 1;
        c.gridy = 0;
        left.add(jtf_nom, c);
        
        // IFA
        label_ifa.setFont(police_label);
        c.gridx = 0;
        c.gridy = 1;
        left.add(label_ifa, c);
        c.gridx = 1;
        c.gridy = 1;
        left.add(cb_ifa, c);
              
        // KM
        label_km.setFont(police_label);
        jtf_km.setFont(police);
        jtf_km.setPreferredSize(new Dimension(140, 20));    
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
        c.gridx = 0;
        c.gridy = 2;
        left.add(label_km,c);
        c.gridx = 1;
        c.gridy = 2;
        left.add(jtf_km,c);  
    
        // AMI 1
        label_ami.setFont(police_label);
        combo_ami.setPreferredSize(new Dimension(140, 20));
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
        combo_ami.setPreferredSize(new Dimension(140, 20));
        c.gridx = 0;
        c.gridy = 3;
        left.add(label_ami,c);
        c.gridx = 1;
        c.gridy = 3;
        left.add(combo_ami,c);
        
        // AMI 2
        label_ami2.setFont(police_label);
        combo_ami2.setPreferredSize(new Dimension(140, 20));
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
        combo_ami2.setPreferredSize(new Dimension(140, 20));
        
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
        
        c.gridx = 0;
        c.gridy = 4;
        left.add(label_ami2,c);
        c.gridx = 1;
        c.gridy = 4;
        left.add(combo_ami2,c);
        
        // AIS
        label_ais.setFont(police_label);
        combo_ais.setPreferredSize(new Dimension(140, 20));
        combo_ais.addItem("0");
        combo_ais.addItem("1");
        combo_ais.addItem("2");
        combo_ais.addItem("3");
        combo_ais.addItem("4");
        combo_ais.setPreferredSize(new Dimension(140, 20));
        
        c.gridx = 0;
        c.gridy = 5;
        left.add(label_ais,c);
        c.gridx = 1;
        c.gridy = 5;
        left.add(combo_ais,c);
        
        // MAU
        label_mau.setFont(police_label);
        c.gridx = 0;
        c.gridy = 6;
        left.add(label_mau,c);
        c.gridx = 1;
        c.gridy = 6;
        left.add(cb_mau,c);
        
        // MCI
        label_mci.setFont(police_label);
        c.gridx = 0;
        c.gridy = 7;
        left.add(label_mci,c);
        c.gridx = 1;
        c.gridy = 7;
        left.add(cb_mci,c);
        
        //D, JF
        label_jfd.setFont(police_label);
        c.gridx = 0;
        c.gridy = 8;
        left.add(label_jfd,c);
        c.gridx = 1;
        c.gridy = 8;
        left.add(cb_jfd,c);
        
        // Nuit
        label_nuit.setFont(police_label);
        c.gridx = 0;
        c.gridy = 9;
        left.add(label_nuit,c);
        c.gridx = 1;
        c.gridy = 9;
        left.add(cb_nuit,c);
        
        // Parcourir

        c.insets = new Insets(40,0,20,30);
        JButton parc = new JButton ("Parcourir ..");
        parc.setPreferredSize(new Dimension(120, 30)); 
       
        parc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

		        fc.setCurrentDirectory(new java.io.File("C:/"));
		        fc.setDialogTitle("S�lectionnez un fichier !");
		        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        if (fc.showOpenDialog(parc) == JFileChooser.APPROVE_OPTION) {
		        	
		        	Color col = new Color(0, 150, 0);
					Font police_parc2 = new Font("Arial", Font.ITALIC + Font.BOLD, 14);
			        label_parc.setFont(police_parc2);
			        label_parc.setForeground(col);
			        
		        }
		        System.out.println(fc.getSelectedFile().getName());
		        label_parc.setText("\\"+fc.getSelectedFile().getName());
				
			} 
        
        });


        c.gridx = 0;
        c.gridy = 10;
        left.add(parc,c);
        Font police_parc1 = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
        label_parc.setPreferredSize(new Dimension(120, 30));
        label_parc.setText("Aucun dossier ...");
        label_parc.setForeground(Color.RED);
        label_parc.setFont(police_parc1);
        c.gridx = 1;
        c.gridy = 10;
        left.add(label_parc,c);
        
        // File
        c.insets = new Insets(0,0,20,30);
        label_file.setFont(police_label);
        jtf_file.setFont(police);
        jtf_file.setPreferredSize(new Dimension(140, 20));    
        
        c.gridx = 0;
        c.gridy = 11;
        left.add(label_file,c);
        c.gridx = 1;
        c.gridy = 11;
        left.add(jtf_file,c);  

        
        // Les patients habituelles
        patients.setLayout(new GridBagLayout());
		GridBagConstraints p = new GridBagConstraints();
		p.insets = new Insets(0,0,0,30);
		p.anchor = GridBagConstraints.WEST;
        
        label_patients.setFont(police_label);
        combo_patients.setPreferredSize(new Dimension(200, 20));
        combo_patients.addItem(" ... ");
        combo_patients.addItem("KUBARYNKA Celina");
        combo_patients.addItem("MATUSIAK Liliane");
        combo_patients.addItem("DE GRANDE Genevieve");
        combo_patients.addItem("FRAMBERY Marcelle");
        combo_patients.addItem("BASTET Elen");
        combo_patients.addItem("BOUILLON Christophe");
        combo_patients.addItem("COURANT Christian");
        combo_patients.addItem("DO ESPIRITO SANTO Nelson");
        combo_patients.addItem("FEUARDENT Paule");
        combo_patients.addItem("GALLOIS Jean");
        combo_patients.addItem("MATUSIAK Edmond");
        combo_patients.addItem("MEYNARD Maud");
        combo_patients.addItem("PARAIN Catherine");
        combo_patients.addItem("PICQUET Francis");
        combo_patients.addItem("STROZYNSKI Raymond");
        combo_patients.addItem("KAJOULIS Elisabeth");
        combo_patients.addItem("AVENU Anne Marie");
        combo_patients.addItem("LEGRAND Serge");
        combo_patients.addItem("OLIVIER Rene");
        combo_patients.addItem("BECKER Jocelyne");

        p.gridx = 0;
        p.gridy = 0;
        patients.add(label_patients,p);
        p.gridx = 1;
        p.gridy = 0;
        patients.add(combo_patients,p);
        
        
        
        combo_patients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	if(combo_patients.getSelectedItem().equals(" ... ")) {
            		jtf_nom.setText("");
                	cb_ifa.setSelected(false);
                	jtf_km.setText("");
                	combo_ami.setSelectedItem("0");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);
                } 
            	else if(combo_patients.getSelectedItem().equals("KUBARYNKA Celina")) {
            		jtf_nom.setText("KUBARYNKA Cel.");
                	cb_ifa.setSelected(true);
                	combo_ais.setSelectedItem("3");	
                	
                	jtf_km.setText("");
                	combo_ami.setSelectedItem("0");
                	combo_ami2.setSelectedItem("0");	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);
                }
            	else if(combo_patients.getSelectedItem().equals("MATUSIAK Liliane")) {
            		jtf_nom.setText("MATUSIAK Lil.");
                	cb_ifa.setSelected(true);
                	combo_ais.setSelectedItem("3");	
                	
                	jtf_km.setText("");
                	combo_ami.setSelectedItem("0");
                	combo_ami2.setSelectedItem("0");	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);
                }
            	else if(combo_patients.getSelectedItem().equals("DE GRANDE Genevieve")) {
            		jtf_nom.setText("DE GRANDE Gene.");
                	cb_ifa.setSelected(true);
                	jtf_km.setText("10");
                	combo_ami.setSelectedItem("1.5");
                	combo_ais.setSelectedItem("3");
                	cb_mau.setSelected(true);
                	
                	combo_ami2.setSelectedItem("0");	
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);
                }
            	else if(combo_patients.getSelectedItem().equals("FRAMBERY Marcelle")) {
            		jtf_nom.setText("FRAMBERY Marc.");
                	cb_ifa.setSelected(true);
                	jtf_km.setText("10");
                	combo_ami.setSelectedItem("2");
                	
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);
                }
            	else if(combo_patients.getSelectedItem().equals("BASTET Elen")) {
            		jtf_nom.setText("BASTET Elen");
                	cb_ifa.setSelected(true);
                	combo_ami.setSelectedItem("1");
                	cb_mau.setSelected(true);
                	
                	jtf_km.setText("");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);
                }
            	else if(combo_patients.getSelectedItem().equals("BOUILLON Christophe")) {
            		jtf_nom.setText("BOUILLON Chri.");
                	cb_ifa.setSelected(true);
                	combo_ami.setSelectedItem("2");
                	combo_ami2.setSelectedItem("1.5");
                	cb_mau.setSelected(true);
                	
                	jtf_km.setText("");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);
                }
            	else if(combo_patients.getSelectedItem().equals("COURANT Christian")) {
            		jtf_nom.setText("COURANT Chri.");
                	cb_ifa.setSelected(true);
                	combo_ais.setSelectedItem("3");
                	
                	jtf_km.setText("");
                	combo_ami.setSelectedItem("0");
                	combo_ami2.setSelectedItem("0");	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("DO ESPIRITO SANTO Nelson")) {
            		jtf_nom.setText("DO ESPIRITO SA.");
                	cb_ifa.setSelected(true);
                	combo_ami.setSelectedItem("4");
                	cb_mci.setSelected(true);
                	
                	jtf_km.setText("");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mau.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("FEUARDENT Paule")) {
            		jtf_nom.setText("FEUARDENT Pau.");
                	cb_ifa.setSelected(true);
                	combo_ais.setSelectedItem("3");

                	jtf_km.setText("");
                	combo_ami.setSelectedItem("0");
                	combo_ami2.setSelectedItem("0"); 	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("GALLOIS Jean")) {
            		jtf_nom.setText("GALLOIS Jean");
                	cb_ifa.setSelected(true);
                	combo_ami.setSelectedItem("1");
                	cb_mau.setSelected(true);
                	
                	jtf_km.setText("");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("MATUSIAK Edmond")) {
            		jtf_nom.setText("MATUSIAK Edm.");
                	cb_ifa.setSelected(true);
                	combo_ais.setSelectedItem("3");
                	
                	jtf_km.setText("");
                	combo_ami.setSelectedItem("0");
                	combo_ami2.setSelectedItem("0");	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("MEYNARD Maud")) {
            		jtf_nom.setText("MEYNARD Maud");
                	cb_ifa.setSelected(true);
                	combo_ami.setSelectedItem("2");
                	
                	jtf_km.setText("");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("PARAIN Catherine")) {
            		jtf_nom.setText("PARAIN Cath.");
                	cb_ifa.setSelected(true);
                	combo_ami.setSelectedItem("2");
                	
                	jtf_km.setText("");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("PICQUET Francis")) {
            		jtf_nom.setText("PICQUET Fran.");
                	cb_ifa.setSelected(true);
                	jtf_km.setText("22");
                	combo_ami.setSelectedItem("4");
                	cb_mci.setSelected(true);
                	
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mau.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("STROZYNSKI Raymond")) {
            		jtf_nom.setText("STROZYNSKI Ray.");
                	cb_ifa.setSelected(true);
                	combo_ais.setSelectedItem("3");
                	
                	jtf_km.setText("");
                	combo_ami.setSelectedItem("0");
                	combo_ami2.setSelectedItem("0"); 	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);
                	
                }
            	else if(combo_patients.getSelectedItem().equals("KAJOULIS Elisabeth")) {
            		jtf_nom.setText("KAJOULIS Eli.");
                	cb_ifa.setSelected(true);
                	combo_ami.setSelectedItem("1.5");
                	cb_mau.setSelected(true);
                	
                	jtf_km.setText("");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("AVENU Anne Marie")) {
            		jtf_nom.setText("AVENU Anne Ma.");
                	cb_ifa.setSelected(true);
                	combo_ami.setSelectedItem("4");
                	cb_mci.setSelected(true);
                	
                	jtf_km.setText("");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mau.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("LEGRAND Serge")) {
            		jtf_nom.setText("LEGRAND Serge");
                	cb_ifa.setSelected(true);
                	combo_ami.setSelectedItem("1.5");
                	cb_mau.setSelected(true);
                	
                	jtf_km.setText("");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("OLIVIER Rene")) {
            		jtf_nom.setText("OLIVIER Rene");
                	cb_ifa.setSelected(true);
                	combo_ais.setSelectedItem("4");
                	
                	jtf_km.setText("");
                	combo_ami.setSelectedItem("0");
                	combo_ami2.setSelectedItem("0");	
                	cb_mau.setSelected(false);
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            	else if(combo_patients.getSelectedItem().equals("BECKER Jocelyne")) {
            		jtf_nom.setText("BECKER Joc.");
                	combo_ami.setSelectedItem("1");
                	cb_mau.setSelected(true);
                	
                	cb_ifa.setSelected(false);
                	jtf_km.setText("");
                	combo_ami2.setSelectedItem("0");
                	combo_ais.setSelectedItem("0"); 	
                	cb_mci.setSelected(false);
                	cb_jfd.setSelected(false);
                	cb_nuit.setSelected(false);

                }
            }
        });
        
        
        
        
        
        
        
        
        
        
        // ***************** Le bouton *******************************************
        JButton btn = new JButton("Valider");  
        c.insets = new Insets(30,0,0,30);
        c.anchor = GridBagConstraints.CENTER;
        btn.setPreferredSize(new Dimension(140, 40)); 
        c.gridx = 0;
        c.gridy = 12;
        c.gridwidth = 2;
        left.add(btn,c);
        
        
        
        
        
        btn.addActionListener(new ActionListener() { 
        	private BufferedReader br;

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

        		// Le calcul de la ligne
        		double calc = (ifa+(0.35*ik)+((3.15*ami1)-(((3.15*ami1)*5)/100))+(3.15*ami2)+((2.65*ais)-(((2.65*ais)*5)/100))+mau+mci+jfd+nuit);

        		
        		
        		
        		
        		
        		
        		// ###############################################################################################################################
        		// ############################################ Ecriture dans le fichier texte ###################################################
        		// ###############################################################################################################################
        		
        		
        		
        		File f = new File(fc.getSelectedFile().getAbsolutePath()+"\\"+jtf_file.getText()+".xls");
        		if(!f.isFile()) { 
        			System.out.println("Le fichier n'existe PAS");
        			
        			try {
        				HSSFWorkbook wb = new HSSFWorkbook();
        				HSSFSheet sheet = wb.createSheet("Honoraires");
        				
        				// ######### La ligne de titres
        				
        				HSSFRow row_ti = sheet.createRow(0);
        				HSSFCellStyle cellStyle_titre;
        				
        				cellStyle_titre = wb.createCellStyle();
    	                cellStyle_titre.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    	                cellStyle_titre.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    	                cellStyle_titre.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
    	                cellStyle_titre.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
    	                cellStyle_titre.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
    	                cellStyle_titre.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
    	                cellStyle_titre.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
    	                cellStyle_titre.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        				
        				HSSFCell cell_ti = null;
    	                cell_ti = row_ti.createCell((short)0, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("NOM")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                cell_ti = row_ti.createCell((short)1, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("IFA")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                cell_ti = row_ti.createCell((short)2, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("IK")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                cell_ti = row_ti.createCell((short)3, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("AMI1 | AMI2")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                cell_ti = row_ti.createCell((short)4, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("AIS")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                cell_ti = row_ti.createCell((short)5, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("MAU")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                cell_ti = row_ti.createCell((short)6, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("MCI")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                cell_ti = row_ti.createCell((short)7, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("D/JF")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                cell_ti = row_ti.createCell((short)8, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("Nuit")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                cell_ti = row_ti.createCell((short)9, HSSFCell.CELL_TYPE_STRING);
    	                cell_ti.setCellValue(new HSSFRichTextString("�")); 
    	                cell_ti.setCellStyle(cellStyle_titre);
    	                
    	                
    	                
    	                // ########## Le reste #########################
    	                
    	                HSSFRow row = sheet.createRow(1);
    	                
    	                HSSFCellStyle cellStyle;
        				cellStyle = wb.createCellStyle();
    	                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    	                cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    	                cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
    	                
    	                HSSFCell cell = null;
    	                cell = row.createCell((short)0, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(name)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)1, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(ifa_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)2);
        				cell.setCellValue(0.35*ik);
    	                cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
    	                cell.setCellStyle(cellStyle);
    	                
    	                double ami11 = (3.15*ami1)-(((3.15*ami1)*5)/100);
    	                double ami22 = 3.15*ami2;
    	        		final NumberFormat instance = NumberFormat.getNumberInstance();
    	        		instance.setMaximumFractionDigits(2);
    	        		String str_ami1=instance.format(ami11); 
    	        		String str_ami2=instance.format(ami22);
    	                
    	                cell = row.createCell((short)3, HSSFCell.CELL_TYPE_STRING);
        				cell.setCellValue(str_ami1+" | "+str_ami2);
    	                cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)4);
        				cell.setCellValue((2.65*ais)-(((2.65*ais)*5)/100));
    	                cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)5, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(mau_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)6, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(mci_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)7, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(jfd_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)8, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(nuit_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	          /*      
    	                cellStyle = wb.createCellStyle();
    	                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    	                cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    	                cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
    	                cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    	         */       
    	                cell = row.createCell((short)9);
        				cell.setCellValue(calc);
        				cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
    	                cell.setCellStyle(cellStyle);
    	                
    	                
    	             // Ligne resultat total
       	                
       	                HSSFCell cell_final = null;
       	                HSSFRow row_final = sheet.createRow(2);
       	                cell_final = row_final.createCell((short)9);
       	                cell_final.setCellType(HSSFCell.CELL_TYPE_FORMULA);
       	                cell_final.setCellFormula("SUM(INDIRECT(\"J2:J\" & ROW()-1))");
       	                cell_final.setCellStyle(cellStyle);
       	                

       	                HSSFCell cell_final_ti = null;
       	                cell_final_ti = row_final.createCell((short)8, HSSFCell.CELL_TYPE_STRING);
       	                cell_final_ti.setCellValue(new HSSFRichTextString("Total =")); 
       	                cell_final_ti.setCellStyle(cellStyle);

    	                
    	                sheet.setColumnWidth((short)0, (short) (18*255));
    	                sheet.setColumnWidth((short)1, (short) (7*255));
    	                sheet.setColumnWidth((short)2, (short) (7*255));
    	                sheet.setColumnWidth((short)3, (short) (12*255));
    	                sheet.setColumnWidth((short)4, (short) (7*255));
    	                sheet.setColumnWidth((short)5, (short) (7*255));
    	                sheet.setColumnWidth((short)6, (short) (7*255));
    	                sheet.setColumnWidth((short)7, (short) (7*255));
    	                sheet.setColumnWidth((short)8, (short) (7*255));
    	                sheet.setColumnWidth((short)9, (short) (9*255));
    	                
    	                row_ti.setHeight((short)600);
    	                row.setHeight((short)450);
    	                row_final.setHeight((short)450);
        				
        				FileOutputStream fileOut;
        				fileOut = new FileOutputStream(fc.getSelectedFile().getAbsolutePath()+"\\"+jtf_file.getText()+".xls");
        				//fileOut = new FileOutputStream("C:\\Users\\Romain\\Documents\\Prog\\"+jtf_file.getText()+".xls");
		                wb.write(fileOut);
		                fileOut.close();
                
        			} catch (IOException e) {
        				e.printStackTrace();
        				
        			}	
        		} else {
        			System.out.println("Le fichier existe");	
        			
        			try {
        				FileInputStream inp = new FileInputStream(fc.getSelectedFile().getAbsolutePath()+"\\"+jtf_file.getText()+".xls");
        				HSSFWorkbook wb = new HSSFWorkbook(inp);
        				HSSFSheet sheet = wb.getSheetAt(0);
        				
        				HSSFRow row; 
        				HSSFCell cell;

        				Iterator rowit = sheet.rowIterator();
        				int cpt = 1;
        				while (rowit.hasNext()) {
        					row=(HSSFRow) rowit.next();
        					cpt++;
        				}
        				System.out.println("Nous �crivons � la ligne num�ro "+(cpt-1));

        				row = sheet.createRow(cpt-2); // -2 pour écraser le res_final
        				
        				HSSFCellStyle cellStyle;
        				cellStyle = wb.createCellStyle();
    	                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    	                cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    	                cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
    	                
    	                cell = row.createCell((short)0, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(name)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)1, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(ifa_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)2);
        				cell.setCellValue(0.35*ik);
    	                cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
    	                cell.setCellStyle(cellStyle);
    	                
    	                double ami11 = (3.15*ami1)-(((3.15*ami1)*5)/100);
    	                double ami22 = 3.15*ami2;
    	        		final NumberFormat instance = NumberFormat.getNumberInstance();
    	        		instance.setMaximumFractionDigits(2);
    	        		String str_ami1=instance.format(ami11); 
    	        		String str_ami2=instance.format(ami22);
    	                
    	                cell = row.createCell((short)3, HSSFCell.CELL_TYPE_STRING);
        				cell.setCellValue(str_ami1+" | "+str_ami2);
    	                cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)4);
        				cell.setCellValue((2.65*ais)-(((2.65*ais)*5)/100));
    	                cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)5, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(mau_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)6, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(mci_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)7, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(jfd_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	                cell = row.createCell((short)8, HSSFCell.CELL_TYPE_STRING);
    	                cell.setCellValue(new HSSFRichTextString(nuit_n)); 
    	                cell.setCellStyle(cellStyle);
    	                
    	            /*    
    	                cellStyle = wb.createCellStyle();
    	                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    	                cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    	                cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    	                cellStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
    	                cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    	           */     
    	                cell = row.createCell((short)9);
        				cell.setCellValue(calc);
        				cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
    	                cell.setCellStyle(cellStyle);
    	                
    	                // Ligne resultat total
    	                
    	                HSSFCell cell_final = null;
    	                HSSFRow row_final = sheet.createRow(cpt-1);
    	                cell_final = row_final.createCell((short)9);
    	                cell_final.setCellType(HSSFCell.CELL_TYPE_FORMULA);
    	                cell_final.setCellFormula("SUM(INDIRECT(\"J2:J\" & ROW()-1))");
    	                cell_final.setCellStyle(cellStyle);
    	                
    	                HSSFCell cell_final_ti = null;
    	                cell_final_ti = row_final.createCell((short)8, HSSFCell.CELL_TYPE_STRING);
    	                cell_final_ti.setCellValue(new HSSFRichTextString("Total")); 
    	                cell_final_ti.setCellStyle(cellStyle);
    	                
    	                
    	                row.setHeight((short)450);
    	                row_final.setHeight((short)330);
    	                
    	                
    	                FileOutputStream fileOut;
                    	fileOut = new FileOutputStream(fc.getSelectedFile().getAbsolutePath()+"\\"+jtf_file.getText()+".xls");
                        wb.write(fileOut);
                        fileOut.close();
                        
        			} catch (IOException e) {
        				e.printStackTrace();
        				JOptionPane.showMessageDialog(null, "Peux-tu fermer ton Excel stp ! Sinon tu ne peux pas le modifier :S");
        			}
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
        	
        		
        		if (jtf_file.getText().length() == 0) {
        			JOptionPane.showMessageDialog(null,"Erreur : Pas de nom de fichier :(");
        		}

        	
        	} 
        });
        
	}
}





/*        		
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
    		fich.write("           |     |     |      |      |     |     |     |        |      ||       \n");
    		fich.write("    NOM    | IFA | IK  | AMI1 | AMI2 | AIS | MAU | MCI | Dim.JF | NUIT || Total \n");
    		fich.write("           |     |     |      |      |     |     |     |        |      ||       \n");
    		fich.write("--------------------------------------------------------------------------------\n");
    	}
    	
    	// On gère le nombre de caractères des variables
    	//String.format("%-10s", name);
    	
        // 2) Utilisation de l'objet
    	fich.write("           |     |     |      |      |     |     |     |        |      ||       \n");
    	fich.write(String.format("%-11.10s", name)+"| "+ifa_n+" |"+DECIMAL_FORMAT.format(0.35*ik)+"|"+DECIMAL_FORMAT.format(3.15*ami1)+" |"+DECIMAL_FORMAT.format(3.15*ami2)+" |"+DECIMAL_FORMAT.format(2.65*ais)+"| "+mau_n+" | "+mci_n+" |  "+jfd_n+"   | "+nuit_n+"  ||"+res+"€\n");
    	fich.write("           |     |     |      |      |     |     |     |        |      ||       \n");
		fich.write("--------------------------------------------------------------------------------\n");
        //fich.write(name+" -> IFA : "+ifa_n+"("+ifa+") ; IK : "+ik+"("+DECIMAL_FORMAT.format(0.35*ik)+") ; AMI 1 : "+ami1+"("+DECIMAL_FORMAT.format(3.15*ami1)+") ; AMI 2 : "+ami2+"("+DECIMAL_FORMAT.format(3.15*ami2)+") ; AMI 1 : "+ais+"("+DECIMAL_FORMAT.format(2.65*ais)+") ; MAU : "+mau_n+"("+mau+") ; MCI : "+mci_n+"("+mci+") ; Dim. Ferié : "+jfd_n+"("+jfd+") ; Nuit : "+nuit_n+"("+nuit+") || Total = "+total+" €\n\r");
//#########
		FileReader fr = new FileReader(file);
		br = new BufferedReader(fr);
		
		int compt=0;
		String line=null;
		while((line=br.readLine())!=null){
		   StringTokenizer st=new StringTokenizer(line);
		   while(st.hasMoreTokens()){
		      if(st.nextToken().equals("->")){
		         compt++;
		      }
		   }
		}
		System.out.println("Le mot a été trouvé "+compt+" fois.\r");
//########
//#### Trouver le moyen de modifier le total !!!!!! ( JSON ? Fichier txt ? SharedPref? )     /!\/!\/!\/!\/!\/!\/!\/!\/!\/!\
		double total = 0;
		total += calc;
		fich.write("-> Res = "+total+" €\n");

    	

    } finally {
        // 3) Libération de la ressource exploitée par l'objet
        fich.close();  
    }

 
  
} catch (IOException e) {
    e.printStackTrace();
}
*/    