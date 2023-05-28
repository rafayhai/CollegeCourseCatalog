import java.util.ArrayList;
import java.util.Collection;

public class CourseSearcher implements Searchable {
    private Collection<String> searchTerms; //arraylist
    /*
     * @param searchTerms - collection representing searchTerms of an available course
     */

    public CourseSearcher(Collection<String> searchTerms) {
        this.searchTerms = searchTerms;
    }
    /*
     * @return true - if the course includes the search terms
     * @return false - if course does not include the search terms
     */

    @Override
    public boolean matches(AvailableCourse<String, Course> other) {
        String courseToString = other.getValue().toString();
        ArrayList<String> newSearchTerms = (ArrayList<String>) this.searchTerms;
        for (String terms : newSearchTerms) {
            if (courseToString.indexOf(terms) != -1)
                return true;
        }
        return false;
    }
}
