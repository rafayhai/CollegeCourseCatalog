public class AvailableCourse <K, V extends Comparable<V>> implements Comparable<AvailableCourse<K,V>>{

    private K key;
    private V value;
    /*
     * @param key - string representation of course, methods utilize it to hold the course CRN
     * @param value - representation of course, methods utilize it to hold the course itself
     */

    public AvailableCourse(K key, V value) {
        this.key = key;
        this.value = value;
    }
    /*
     * @return - returns key
     */

    public K getKey() {
        return this.key;
    }
    /*
     * @return - returns value
     */

    public V getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        //<?,?> represents unknown type
        //if the object is an instance of AvailableCourse, it will be type casted and
        //assigned to a variable representing an instance of AvailableCourse
        //the values will be compared and returns the boolean result
        if (obj instanceof AvailableCourse<?,?>) {
            AvailableCourse<?, ?> otherAvailableCourse = (AvailableCourse<?, ?>) obj;
            if (this.value.equals(otherAvailableCourse.value)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;

    }

    @Override
    public int compareTo(AvailableCourse<K, V> other) { //
        return this.value.compareTo(other.value);
    }
}
