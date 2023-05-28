import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class InPersonCourse extends LectureCourse {
    public InPersonCourse(String crn, String title, Set<String> levels, String instructor,
                          int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
            super(crn, title, levels, instructor, credit, meetDays, gtas);

    }
    /*
     * @return - returns "In-Person" to represent in person classes
     */
    public String getType() {
        return "In-Person";
    }

}
