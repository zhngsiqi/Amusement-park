/**
 * The RideInterface defines the contract for a ride system,
 * specifying the required operations for managing visitors in a queue
 * and keeping track of the ride history.
 */
public interface RideInterface {
    /**
     * Adds a visitor to the queue.
     *
     * @param visitor The visitor to be added to the queue
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Removes the first visitor from the queue.
     * If the queue is empty, an appropriate message should be printed.
     */
    void removeVisitorFromQueue();

    /**
     * Prints all visitors currently in the queue.
     * The implementation should provide a user-friendly representation of the queue.
     */
    void printQueue();

    /**
     * Runs one cycle of the ride.
     * Visitors are removed from the queue and added to the ride history based on the ride's capacity.
     */
    void runOneCycle();

    /**
     * Adds a visitor to the ride history.
     *
     * @param visitor The visitor to be added to the ride history
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Checks if a specific visitor is present in the ride history.
     *
     * @param visitor The visitor to check
     * @return true if the visitor is in the ride history; false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Returns the total number of visitors in the ride history.
     *
     * @return The total number of visitors
     */
    int numberOfVisitors();

    /**
     * Prints the ride history, detailing all visitors who have taken the ride.
     * The implementation must use an Iterator for traversing the collection.
     */
    void printRideHistory();
}
