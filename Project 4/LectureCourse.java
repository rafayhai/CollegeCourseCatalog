import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
public abstract class LectureCourse extends Course {
    private String instructor;
    private int credit;
    private Set<MeetDay> meetDays;
    private Collection<String> gtas;

     /*
     @param instructor - string representing instructor of course
     @param credit - number representing credits of course
     @param meetDays - set representing days of meet for course
     @param gtas - collection representing all GTA's for the course
     */

    public LectureCourse(String crn, String title, Set<String> levels, String instructor,
        int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
        super(crn, title, levels);
            if (instructor != null) {
                this.instructor = instructor;
            }
        else {
            throw new LectureCourseException("instructor");
        }
        this.credit = credit;
        if (meetDays != null && meetDays.size() != 0 && !meetDays.contains(null)) {
            if (meetDays.size() <= 2) {
                this.meetDays = meetDays;
            }
            else {
                throw new LectureCourseException("meetDays");
            }
        }
        else {
            throw new LectureCourseException("meetDays");
        }
        if (gtas != null && gtas.size() != 0 && !gtas.contains(null)) {
            this.gtas = gtas;
        }
        else {
            throw new LectureCourseException("gtas");
        }
    }
    /*
     * @return - returns instructor for course
     */
    public final String getInstructor() {
        return this.instructor;
    }
    /*
     * @return - returns credit for course
     */

    public final int getCredit() {
        return this.credit;
    }
    /*
     * @return - returns meetdays for course
     */

    public final Set<MeetDay> getMeetDays() {
        return this.meetDays;
    }
    /*
     * @return - returns GTA's for course
     */

    public final Collection<String> getGtas() {
        return this.gtas;
    }
    /*
    * @return - string representation of course details
    */

    @Override
    public String toString() {

        return "instructor: " + this.instructor + ", credit: " + this.credit + ", meetDays: " + Arrays.deepToString(this.meetDays.toArray())
                + ", gtas: " + Arrays.deepToString(this.gtas.toArray()) + ", " + super.toString();

    }
    @Override
    public int compareTo(Course otherCourse) {
        if (this instanceof InPersonCourse && ( (otherCourse instanceof HybridCourse) || (otherCourse instanceof OnlineCourse)) )
        {
            return -1;

        }
        else if (otherCourse instanceof InPersonCourse && ( (this instanceof HybridCourse) || (this instanceof OnlineCourse)) )
        {
            return 1;

        }
        if (this instanceof HybridCourse && otherCourse instanceof OnlineCourse) {
            return -1;
        }
        else if (otherCourse instanceof HybridCourse && this instanceof OnlineCourse) {
            return 1;
        }
        if (this instanceof InPersonCourse && otherCourse instanceof InPersonCourse) {
            if (this.getTitle().equals(otherCourse.getTitle()) == false) {
                return this.getTitle().compareTo(otherCourse.getTitle());
            }
            else if (this.getCredit() != ((InPersonCourse) otherCourse).getCredit()) {
                Integer value1 = this.getCredit();
                Integer value2 = ((InPersonCourse) otherCourse).getCredit();
                return value1.compareTo(value2);
            }
            else {
                return 0;
            }

        }
        else if (this instanceof HybridCourse && otherCourse instanceof HybridCourse) {
            if (this.getTitle().equals(otherCourse.getTitle()) == false) {
                return this.getTitle().compareTo(otherCourse.getTitle());
            }
            else if (this.getCredit() != ((HybridCourse) otherCourse).getCredit()) {
                Integer value1 = this.getCredit();
                Integer value2 = ((HybridCourse) otherCourse).getCredit();
                return value1.compareTo(value2);
            }
            else {
                return 0;
            }
        }
        else if (this instanceof OnlineCourse && otherCourse instanceof OnlineCourse) {
            if (this.getTitle().equals(otherCourse.getTitle()) == false) {
                return this.getTitle().compareTo(otherCourse.getTitle());
            }
            else if (this.getMeetDays().size() != ((HybridCourse) otherCourse).getMeetDays().size()) {
                Integer value1 = this.getMeetDays().size();
                Integer value2 = ((HybridCourse) otherCourse).getMeetDays().size();
                return value1.compareTo(value2);
            }

        }
        return 0;
        //check the type using instanceof of the argument
        //then compare the appropriate strings using their own compareTo (class string implements compare to)
        //neg val indicates calling instance (this) comes first
        //pos val indicates calling instances comes second
        //0 indicates they have the same ordering
        //in person courses come before hybrid courses and hybrid courses come before Online courses
        //in person courses are sorted first by title, then by the number of credits
        //hybrid courses are sorted first by title, then by the number of credits
        //online courses are sorted first by title, then by number of meetdays

    }
}
