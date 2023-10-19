import java.beans.Transient;
import java.io.Serial;
import java.lang.annotation.Repeatable;

@Deprecated
public class AnnotedClass {
    private int i = 3;

    @Deprecated
    private int j = 4;

    @Deprecated
    public AnnotedClass() {
    }

    @Transient(true)
    public void testMethod(){
        System.out.println("Test");
    }

    @Transient(true)
    public void test2Method(){
        System.out.println("Test");
    }

    @MiageBasic
    public void test3Method(){
        System.out.println("Test");
    }

    @Deprecated
    public void test4Method(){
        System.out.println("Test");
    }
}
