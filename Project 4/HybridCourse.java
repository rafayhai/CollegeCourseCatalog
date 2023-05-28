import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class HybridCourse extends LectureCourse {
    public HybridCourse(String crn, String title, Set<String> levels, String instructor,
                        int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
        super(crn,title,levels,instructor,credit,meetDays,gtas);
    }
    /*
     * @return - returns "Hybrid" to represent hybrid classes
     */
    public String getType() {
        return "Hybrid";
    }
}
