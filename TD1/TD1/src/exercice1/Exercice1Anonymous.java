package exercice1;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Exercice1Anonymous {

    ArrayList<ModuleNonStatic> array;

    public void run() {

    
        Consumer<ModuleNonStatic> treatment1 = new Consumer<>() {
            @Override
            public void accept(ModuleNonStatic module) {
                System.out.println(String.format("Nom du Module : %s\nDate de création initiale : %d ", module.getDiplomaName(), module.getCreationYear()));
                module.setCreationYear(module.getCreationYear()+1);
                System.out.println(String.format("Nom du Module : %s\nDate de création modifiée : %d ", module.getDiplomaName() , module.getCreationYear()));
                System.out.println("---------------------------------");
            }
        };

        Consumer<ModuleNonStatic> treatment2 = new Consumer<>() {
            @Override
            public void accept(ModuleNonStatic module) {
                System.out.println(String.format("Nom du Module : %s\nNom enseignant : %s\nDate de création initiale : %d ", module.getDiplomaName(), module.getTeacherName(), module.getCreationYear()));
                if(module.getTeacherName() == "Dupont") {
                    module.setCreationYear(module.getCreationYear()+1);
                } else {
                    System.out.println("Pas de modifications");
                }
                System.out.println(String.format("Nom du Module : %s\nNom enseignant : %s\nDate de création modifiée : %d ", module.getDiplomaName(), module.getTeacherName(), module.getCreationYear()));
                System.out.println("---------------------------------");
            }
        };

        Consumer<ModuleNonStatic> treatment3 = new Consumer<>() {
            @Override
            public void accept(ModuleNonStatic module) {
                System.out.println(String.format("Nom du Module : %s\nType de controle : %s\nRattrapage : %s ", module.getDiplomaName(), module.getEvaluationType().toString(), module.getCatchUp()));
                if(module.getEvaluationType() == ModuleNonStatic.EvaluationType.QCM) {
                    module.setCatchUp(false);
                } else {
                    System.out.println("Pas de modification");
                }
                System.out.println(String.format("Nom du Module : %s\nType de controle : %s\nRattrapage modifié : %s ", module.getDiplomaName(), module.getEvaluationType().toString(), module.getCatchUp()));
                System.out.println("---------------------------------");
            }
        };
        System.out.println("Treatment 1");
        array.forEach(treatment1);
        System.out.println("=====================================================");
        System.out.println("Treatment 2");
        array.forEach(treatment2);
        System.out.println("=====================================================");
        System.out.println("Treatment 3");
        array.forEach(treatment3);
        System.out.println("=====================================================");
    };

    public Exercice1Anonymous(ArrayList<ModuleNonStatic> array) {
        this.array = array;
    }

    public static void main(String[] argv) throws Exception {
        Exercice1Anonymous e = new Exercice1Anonymous(new ArrayList<ModuleNonStatic>());
        e.array.add(new ModuleNonStatic("Java", 1999, "Java Certification", "Lahire", ModuleNonStatic.EvaluationType.QCM, false));
        e.array.add(new ModuleNonStatic("Ocaml", 2010, "Ocaml Certification", "Lozes", ModuleNonStatic.EvaluationType.QCM, true));
        e.array.add(new ModuleNonStatic("Racket", 2004, "Racket Certification", "Roy", ModuleNonStatic.EvaluationType.questionsSyntheses, true));
        e.array.add(new ModuleNonStatic("Scala", 2004, "Racket Certification", "Dupont", ModuleNonStatic.EvaluationType.QCM, true));
        e.run();
    }
}