import java.util.Comparator;

/**
 * Comparator implementation for comparing Visitor objects.
 * The comparison is primarily based on the Visitor ID. If the Visitor IDs
 * are identical, it falls back to comparing the Visitor names.
 */
public class VisitorComparator implements Comparator<Visitor> {
    /**
     * Compares two Visitor objects based on their Visitor ID and name.
     *
     * @param v1 The first Visitor object to compare.
     * @param v2 The second Visitor object to compare.
     * @return A negative integer, zero, or a positive integer as the first
     * Visitor is less than, equal to, or greater than the second Visitor.
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int result = v1.getVisitorId().compareTo(v2.getVisitorId());
        if (result == 0) {
            return v1.getName().compareTo(v2.getName());
        }
        return result;
    }
}
