package exercice1;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Exercice1NonStatic {

    ArrayList<ModuleNonStatic> array;

    public class Treatments1 implements Consumer<ModuleNonStatic> {

        @Override
        public void accept(ModuleNonStatic module) {
            System.out.println(String.format("Nom du Module : %s\nDate de création initiale : %d ", module.getDiplomaName(), module.getCreationYear()));
            module.setCreationYear(module.getCreationYear()+1);
            System.out.println(String.format("Nom du Module : %s\nDate de création modifiée : %d ", module.getDiplomaName() , module.getCreationYear()));
            System.out.println("---------------------------------");
        }
    }

    public class Treatments2 implements Consumer<ModuleNonStatic> {

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
    }

    public class Treatments3 implements Consumer<ModuleNonStatic> {

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
    }

    public Exercice1NonStatic(ArrayList<ModuleNonStatic> array) {
        this.array = array;
    }

    public static void main(String[] argv) throws Exception {
        Exercice1NonStatic e = new Exercice1NonStatic(new ArrayList<ModuleNonStatic>());
        e.array.add(new ModuleNonStatic("Java", 1999, "Java Certification", "Lahire", ModuleNonStatic.EvaluationType.QCM, false));
        e.array.add(new ModuleNonStatic("Ocaml", 2010, "Ocaml Certification", "Lozes", ModuleNonStatic.EvaluationType.QCM, true));
        e.array.add(new ModuleNonStatic("Racket", 2004, "Racket Certification", "Roy", ModuleNonStatic.EvaluationType.questionsSyntheses, true));
        e.array.add(new ModuleNonStatic("Scala", 2004, "Racket Certification", "Dupont", ModuleNonStatic.EvaluationType.QCM, true));
        System.out.println("Treatment 1");
        e.array.forEach(e.new Treatments1());
        System.out.println("=====================================================");
        System.out.println("Treatment 2");
        e.array.forEach(e.new Treatments2());
        System.out.println("=====================================================");
        System.out.println("Treatment 3");
        e.array.forEach(e.new Treatments3());
        System.out.println("=====================================================");
    }

}
