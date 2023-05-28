import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
    /*
    * Course class sets up fields required for all inherited classes
    * and implements toString that gives the detail about the course
    */

public abstract class Course implements Comparable<Course> {
    private String crn;

    private String title;
    private Set<String> levels;

     /*
     * @param crn - crn of course
     * @param title - title of course
     * @param levels - presents level of course
     */

    public Course(String crn, String title, Set<String> levels) throws LectureCourseException {
        if (levels != null && levels.size() != 0 && !levels.contains(null)) {
            for (String levels1 : levels) {
                if (levels1.equals("Graduate") || levels1.equals("Undergraduate") || levels1.equals("Non-Degree")) {
                    continue;
                }
                else {
                    throw new LectureCourseException("levels");

                }
            }
            this.levels = levels;
        }
        else {
            throw new LectureCourseException("levels");
        }
        if (crn != null) {
            this.crn = crn;
        }
        else {
            throw new LectureCourseException("crn");
        }
        if (title != null) {
            if (title.length() > 15 && title.length() < 40) {
                this.title = title;
            }
            else {
                throw new LectureCourseException("title");
            }
        }
        else {
            throw new LectureCourseException("title");
        }

    }
    /*
     * @return - returns crn string
     */
    public final String getCrn() {
        return this.crn;
    }
    /*
     * @return - returns title of course
     */
    public final String getTitle() {
        return this.title;
    }
    /*
     * @return - returns levels of course
     */
    public final Set getLevels() {
        return this.levels;
    }
    /*
    @return true if current course and other course have the same CRN
    @false if other course and current do not have matching CRNs or the other course is not a course
     */
    public boolean equals(Object object) {
        Course course = (Course) object;

        if (this.compareTo(course) == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public String getType() {
        return this.getType();
    }
    /*
    * @return returns an int value representing whether or not two courses have identical crn
     */
    @Override
    public int compareTo(Course otherCourse) {
        return this.crn.compareTo(otherCourse.getCrn());

    }
     /*
     * @return returns string representation of course details
     */
    public String toString() {
        return "type: " + this.getType() + ", CRN: " + this.crn + ", title: " + this.title
                + ", levels: " + Arrays.deepToString(this.levels.toArray());
    }



}
