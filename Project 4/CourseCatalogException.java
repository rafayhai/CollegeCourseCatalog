public class CourseCatalogException extends IllegalStateException {
    private String crn;
    private Course course;

    /*
     * @param crn - represents the crn field that caused the exception
     * @param course - represents which course caused the exception
     */

    public CourseCatalogException(String crn, Course course) {
        super("The course's CRN is already in the catalog.");
        this.crn = crn;
        this.course = course;

    }
}
