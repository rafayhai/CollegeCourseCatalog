public class LectureCourseException extends Exception {
    private String fieldName;

    /*
     * @param fieldName - represents the name of the field that caused the exception
     */
    public LectureCourseException(String fieldName) {
        super("an argument has null or illegal value");
        this.fieldName = fieldName;

    }
    /*
     * @return - returns the fieldName
     */

    public String getFieldName() {
        return this.fieldName;
    }
}
