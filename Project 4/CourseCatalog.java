import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CourseCatalog {
    private List<AvailableCourse<String,Course>> catalog;

    /*
     * @param catalog - list of available courses in the catalog
     */

    public CourseCatalog() {
        this.catalog = new ArrayList<AvailableCourse<String,Course>>();
    }

    public void add(String crn, Course course) {

        if (this.catalog.size() > 0) {
            for (AvailableCourse<String,Course> courses: this.catalog) {
                if (courses.getKey().equals(crn)) {
                    throw new CourseCatalogException(crn, course);
                }
            }
        }
        catalog.add(new AvailableCourse<String, Course>(crn, course));

    }
    /*
     * @return newCourses list - returns a new list of courses that are linked to the search terms
     */
    public List<AvailableCourse<String, Course>> search(CourseSearcher searchable) {
        List<AvailableCourse<String,Course>> newCourses = new ArrayList<AvailableCourse<String,Course>>();
        for (AvailableCourse<String, Course> courses : this.catalog) {
            if (searchable.matches(courses) == true) {
                newCourses.add(courses);

            }
        }
        return newCourses;

    }
    /*
     * @return - returns catalog list
     */

    public List<AvailableCourse<String, Course>> getCatalog() {
        return this.catalog;
    }

    public void sort() {
        Collections.sort(this.catalog);
    }
}
