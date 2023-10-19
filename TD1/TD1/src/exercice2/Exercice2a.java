/* Philippe Lahire 
 * M1 MIAGE
 */

package exercice2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import exercice1.ModuleNonStatic;

public class Exercice2a extends JDialog {

    ArrayList<ModuleNonStatic> array;

    public Exercice2a(ArrayList<ModuleNonStatic> array) {
        this.array = array;
    }
	
	JTextArea tableauAffichage;

	private void initInterface() {
	
		this.setLayout(new FlowLayout());

        JButton b1 = new JButton("Treatment 1");
        JButton b2 = new JButton("Treatment 2");
        JButton b3 = new JButton("Treatment 3");

        b1.setBounds(20 , 20 , 100 , 30);
        b2.setBounds(130 , 20 , 100 , 30);
        b3.setBounds(240 , 20 , 100 , 30);

		tableauAffichage = new JTextArea("Affichage des messages");
		tableauAffichage.setSize(400,400);    
		tableauAffichage.setLineWrap(true);
		tableauAffichage.setEditable(false);
		tableauAffichage.setVisible(true);
        
		JScrollPane scroll = new JScrollPane (tableauAffichage);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JFrame frame = new JFrame ("Exercice 2");
		frame.setSize(500,500);
		frame.setResizable(false);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        frame.add(scroll);

		this.pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);

        Consumer<ModuleNonStatic> treatment1 = (ModuleNonStatic module) -> {
            System.out.println(String.format("Nom du Module : %s\nDate de création initiale : %d ", module.getDiplomaName(), module.getCreationYear()));
            module.setCreationYear(module.getCreationYear()+1);
            System.out.println(String.format("Nom du Module : %s\nDate de création modifiée : %d ", module.getDiplomaName() , module.getCreationYear()));
            System.out.println("---------------------------------");
        };
        Consumer<ModuleNonStatic> treatment2 = (ModuleNonStatic module) -> {
            System.out.println(String.format("Nom du Module : %s\nNom enseignant : %s\nDate de création initiale : %d ", module.getDiplomaName(), module.getTeacherName(), module.getCreationYear()));
            if(module.getTeacherName() == "Dupont") {
                module.setCreationYear(module.getCreationYear()+1);
            } else {
                System.out.println("Pas de modifications");
            }
            System.out.println(String.format("Nom du Module : %s\nNom enseignant : %s\nDate de création modifiée : %d ", module.getDiplomaName(), module.getTeacherName(), module.getCreationYear()));
            System.out.println("---------------------------------");
        };
        Consumer<ModuleNonStatic> treatment3 = (ModuleNonStatic module) -> {
            System.out.println(String.format("Nom du Module : %s\nType de controle : %s\nRattrapage : %s ", module.getDiplomaName(), module.getEvaluationType().toString(), module.getCatchUp()));
            if(module.getEvaluationType() == ModuleNonStatic.EvaluationType.QCM) {
                module.setCatchUp(false);
            } else {
                System.out.println("Pas de modification");
            }
            System.out.println(String.format("Nom du Module : %s\nType de controle : %s\nRattrapage modifié : %s ", module.getDiplomaName(), module.getEvaluationType().toString(), module.getCatchUp()));
            System.out.println("---------------------------------");
        };

        b1.addActionListener(event -> array.forEach(treatment1));
        b2.addActionListener(event -> array.forEach(treatment2));
        b3.addActionListener(event -> array.forEach(treatment3));
	};

	public static void main(String[] args) {
		Exercice2a e = new Exercice2a(new ArrayList<ModuleNonStatic>());
        e.array.add(new ModuleNonStatic("Java", 1999, "Java Certification", "Lahire", ModuleNonStatic.EvaluationType.QCM, false));
        e.array.add(new ModuleNonStatic("Ocaml", 2010, "Ocaml Certification", "Lozes", ModuleNonStatic.EvaluationType.QCM, true));
        e.array.add(new ModuleNonStatic("Racket", 2004, "Racket Certification", "Roy", ModuleNonStatic.EvaluationType.questionsSyntheses, true));
        e.array.add(new ModuleNonStatic("Scala", 2004, "Racket Certification", "Dupont", ModuleNonStatic.EvaluationType.QCM, true));
        e.initInterface();
	}

}