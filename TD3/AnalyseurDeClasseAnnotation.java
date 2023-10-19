import java.lang.reflect.*;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

import java.io.*;
import java.lang.annotation.*;

public class AnalyseurDeClasseAnnotation {

  public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
    // R�cup�ration d'un objet de type Class correspondant au nom pass� en param�tres
    Class cl = getClasse(nomClasse);

    afficheClassAnnotation(cl);

    afficheEnTeteClasse(cl);

    // System.out.println();
    // afficheInnerClasses(cl);

    // System.out.println();
    // afficheAttributs(cl);

    // System.out.println();
    // afficheConstructeurs(cl);

    // System.out.println();
    // afficheMethodes(cl);

    // // L'accolade fermante de fin de classe !
    // System.out.println("}");
  }


  /** Retourne la classe dont le nom est pass� en param�tre */
  public static Class getClasse(String nomClasse) throws ClassNotFoundException {
    return Class.forName(nomClasse);
  }

  public static void afficheClassAnnotation(Class cl) {
    Annotation[] annotations = cl.getAnnotations();
    // A[] annotations2 = cl.getAnnotationsByType(cl);

    System.out.println("Annotation 1 :");
    System.out.println(" implements " + Arrays.toString(annotations));

    System.out.println("Annotation 2 :");
    // System.out.println(" implements " + Arrays.toString(annotations2));
  }

  /** Cette m�thode affiche par ex "public class C1 extends C2 implements I1, I2 {" */
  public static void afficheEnTeteClasse(Class cl) {

    //  Affichage du modifier et du nom de la classe
    int modifier = cl.getModifiers();
    System.out.print(Modifier.toString(modifier));
    System.out.print(" " + cl.getName());

   // R�cup�ration de la superclasse si elle existe (null si cl est le type Object)
    Class supercl = cl.getSuperclass();

    // On ecrit le "extends " que si la superclasse est non nulle et diff�rente de Object
    if((supercl != null) & (supercl != Object.class)) {
      System.out.print(" extends " + supercl.getCanonicalName());
    }

    // Affichage des interfaces que la classe implemente
    Class[] interfaces = cl.getInterfaces();
    System.out.print(" implements ");
    for(int i = 0; i<interfaces.length; i++) {
      System.out.print(interfaces[i].getCanonicalName() + " ");
    }
    System.out.print(" {\n");
  }

 public static void afficheInnerClasses(Class cl) throws ClassNotFoundException {
    Class[] innerClasses = cl.getDeclaredClasses();
    for(int i = 0; i<innerClasses.length; i++){
      analyseClasse(innerClasses[i].getName());
    }
  }

  public static void afficheAttributs(Class cl) {
    Field[] fields = cl.getDeclaredFields();
    for (int i = 0; i < fields.length; i++) {
      System.out.print(Modifier.toString(fields[i].getModifiers()) + " ");
      System.out.print(fields[i].getType().getCanonicalName() + " ");
      System.out.println(fields[i].getName() + ";");
    }
  }

  public static void afficheConstructeurs(Class cl) {
    Constructor[] constructors = cl.getDeclaredConstructors();
    for(int i = 0; i<constructors.length; i++){
		  System.out.print(Modifier.toString(constructors[i].getModifiers()) + " ");
		  System.out.print(cl.getCanonicalName());
      System.out.print("(");
      Parameter[] params = constructors[i].getParameters();
      for(int j = 0; j<params.length; j++) {
        System.out.print(params[j].getType().getCanonicalName() + " " +params[j].getName()+", ");
      }
      System.out.println(");");
    }
  }

  public static void afficheMethodes(Class cl) {
    Method[] methods = cl.getDeclaredMethods();
    for(int i = 0; i<methods.length; i++){
      System.out.print(Modifier.toString(methods[i].getModifiers()) + " ");
      System.out.print(methods[i].getReturnType().getCanonicalName() + " ");
      System.out.print(methods[i].getName());
      System.out.print("(");
      Parameter[] params = methods[i].getParameters();
      for(int j = 0; j<params.length; j++) {
        System.out.print(params[j].getType().getCanonicalName() + " " +params[j].getName()+", ");
      }
      System.out.println(");");
    }
     System.out.println("{}");
  }

/* Facultatif au moins dans un premier temps */
/* tester le programme en passant un nom de classe complet en param�tre 
     Modifier la m�thode "main" en cons�quence
*/
 public static String litChaineAuClavier() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return br.readLine();
  }

  public static void main(String[] args) {
    boolean ok = false;

    while(!ok) {
      try {
        System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
        String nomClasse = litChaineAuClavier();

       analyseClasse(nomClasse);
        ok = true;
      } catch(ClassNotFoundException e) {
        System.out.println("Classe non trouvée.");
      }catch(IOException e) {
        System.out.println("Erreur d'E/S!");
      }
    }
  }
}