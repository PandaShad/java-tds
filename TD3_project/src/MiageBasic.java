import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE})
public @interface MiageBasic {
    public String nom() default "Bellet";
    public String prenom() default "Maxime";
    public int numeroAnnee() default 2022;
    public String module() default "Java";
    public int td() default 1;
}
