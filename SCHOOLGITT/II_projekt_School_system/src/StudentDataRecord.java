import java.util.List;
import java.util.Map;

public record StudentDataRecord(
        String id,
        String name,
        Map<Subject, List<Grade>> subjectAndGradeMap,
        boolean isAbsent,
        int numberOfAbsences

)
{


    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Map<Subject, List<Grade>> subjectAndGradeMap() {
        return subjectAndGradeMap;
    }

    @Override
    public boolean isAbsent() {
        return isAbsent;
    }

    @Override
    public int numberOfAbsences() {
        return numberOfAbsences;
    }


}
