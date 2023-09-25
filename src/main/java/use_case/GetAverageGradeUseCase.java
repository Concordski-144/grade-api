package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team myTeam = gradeDB.getMyTeam();
        String[] members = myTeam.getMembers();
        float totalGrades = 0;
        for (String member : members) {
            totalGrades += gradeDB.getGrade(member, course).getGrade();
        }
        return (totalGrades / members.length);
    }
}
