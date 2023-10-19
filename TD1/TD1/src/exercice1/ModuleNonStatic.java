package exercice1;

public class ModuleNonStatic {

    public enum EvaluationType {
        QCM,
        projet,
        questionsSyntheses
    }

    private String name;
    private int creationYear;
    private String diplomaName;
    private String teacherName;
    private EvaluationType evaluationType;
    private boolean catchUp;


    public ModuleNonStatic(String name, int creationYear, String diplomaName, String teacherName, EvaluationType evaluationType, boolean catchUp) {
        this.name = name;
        this.creationYear = creationYear;
        this.diplomaName = diplomaName;
        this.teacherName = teacherName;
        this.evaluationType = evaluationType;
        this.catchUp = catchUp;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreationYear() {
        return this.creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getDiplomaName() {
        return this.diplomaName;
    }

    public void setDiplomaName(String diplomaName) {
        this.diplomaName = diplomaName;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public EvaluationType getEvaluationType() {
        return this.evaluationType;
    }

    public void setEvaluationType(EvaluationType evaluationType) {
        this.evaluationType = evaluationType;
    }

    public boolean isCatchUp() {
        return this.catchUp;
    }

    public boolean getCatchUp() {
        return this.catchUp;
    }

    public void setCatchUp(boolean catchUp) {
        this.catchUp = catchUp;
    }
}