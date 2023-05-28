import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class OnlineCourse extends LectureCourse  {
    public OnlineCourse(String crn, String title, Set<String> levels, String instructor,
                        int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
        super(crn,title,levels,instructor,credit,meetDays,gtas);
    }
    /*
     * @return - returns "online" to represent online classes
     */
    public String getType() {
        return "Online";
    }
}
