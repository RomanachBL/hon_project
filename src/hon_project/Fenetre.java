package hon_project;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

    public Fenetre(){

        this.setTitle("Ma première fenêtre Java");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
/*
        //Instanciation d'un objet JPanel
        JPanel pan = new JPanel();
        //Définition de sa couleur de fond
        pan.setBackground(Color.GREEN);
        //On prévient notre JFrame que notre JPanel sera son contentPane
        this.setContentPane(pan);
*/
        // Le panneau
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Panneau());

        this.setVisible(true);

    }

}