import java.io.*;
import java.util.*;

/**
 * Represents an amusement park ride with visitor queue management, history tracking,
 * and import/export functionality.
 */
public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    /**
     * Default constructor initializing the ride with default values.
     */
    public Ride() {
        this.rideName = "";
        this.capacity = 0;
        this.operator = null;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 1;
        this.numOfCycles = 0;
    }

    /**
     * Constructor to create a ride with specified properties.
     *
     * @param rideName The name of the ride.
     * @param capacity The capacity of the ride.
     * @param operator The operator assigned to the ride.
     * @param maxRider The maximum number of riders per cycle.
     */
    public Ride(String rideName, int capacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    /**
     * Gets the name of the ride.
     *
     * @return The name of the ride.
     */
    public String getRideName() {
        return rideName;
    }

    /**
     * Sets the name of the ride.
     *
     * @param rideName The name to set for the ride.
     */
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    /**
     * Gets the capacity of the ride.
     *
     * @return The ride capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the ride.
     *
     * @param capacity The capacity to set.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets the operator assigned to the ride.
     *
     * @return The ride operator.
     */
    public Employee getOperator() {
        return operator;
    }

    /**
     * Sets the operator for the ride.
     *
     * @param operator The operator to assign.
     */
    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    /**
     * Gets the maximum number of riders allowed per cycle.
     *
     * @return The maximum riders per cycle.
     */
    public int getMaxRider() {
        return maxRider;
    }

    /**
     * Sets the maximum number of riders per cycle.
     * Ensures the value is at least 1.
     *
     * @param maxRider The maximum riders to set.
     */
    public void setMaxRider(int maxRider) {
        if (maxRider > 0) {
            this.maxRider = maxRider;
        } else {
            System.out.println("Maximum riders must be at least 1.");
        }
    }

    /**
     * Gets the total number of cycles the ride has run.
     *
     * @return The number of cycles run.
     */
    public int getNumOfCycles() {
        return numOfCycles;
    }

    /**
     * Adds a visitor to the ride's queue.
     *
     * @param visitor The visitor to add to the queue.
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            visitorQueue.offer(visitor);
            System.out.println(visitor.getName() + " has been added to the queue for " + rideName + ".");
        } else {
            System.out.println("Visitor is null.");
        }
    }

    /**
     * Removes the next visitor from the queue.
     */
    @Override
    public void removeVisitorFromQueue() {
        Visitor visitor = visitorQueue.poll();
        if (visitor != null) {
            System.out.println(visitor.getName() + " has been removed from the queue for " + rideName + ".");
        } else {
            System.out.println("Queue is empty.");
        }
    }

    /**
     * Prints the current visitors in the queue.
     */
    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Visitors in the queue for " + rideName + ":");
            for (Visitor visitor : visitorQueue) {
                System.out.println(visitor.getName());
            }
        }
    }

    /**
     * Runs one ride cycle, allowing a maximum number of riders.
     */
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Ride cannot run. No operator assigned.");
            return;
        }

        if (visitorQueue.isEmpty()) {
            System.out.println("Ride cannot run. No visitors in the queue.");
            return;
        }

        int count = Math.min(maxRider, visitorQueue.size());
        System.out.println("Starting ride cycle with " + count + " visitor(s).");

        for (int i = 0; i < count; i++) {
            Visitor visitor = visitorQueue.poll();
            if (visitor != null) {
                rideHistory.add(visitor);
            }
        }

        numOfCycles++;
        System.out.println("Ride cycle completed. Total cycles run: " + numOfCycles);
    }

    /**
     * Adds a visitor to the ride history.
     *
     * @param visitor The visitor to add to the history.
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " has been added to the ride history.");
        } else {
            System.out.println("Visitor is null.");
        }
    }

    /**
     * Checks if a visitor is in the ride's history.
     *
     * @param visitor The visitor to check.
     * @return true if the visitor is in the history; false otherwise.
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Visitor is null.");
            return false;
        }

        if (findVisitorInHistory(visitor.getVisitorId()) != null) {
            System.out.println("Visitor " + visitor.getName() + " has taken the ride.");
            return true;
        } else {
            System.out.println("Visitor " + visitor.getName() + " has not taken the ride.");
            return false;
        }
    }

    private Visitor findVisitorInHistory(String visitorId) {
        for (Visitor visitor : rideHistory) {
            if (visitor.getVisitorId().equals(visitorId)) {
                return visitor;
            }
        }
        return null;
    }

    /**
     * Gets the total number of visitors who have taken the ride.
     *
     * @return The number of visitors in the ride history.
     */
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    /**
     * Prints the history of all visitors who have taken the ride.
     */
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet.");
        } else {
            System.out.println("Visitors who have taken the ride:");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor.getName());
            }
        }
    }

    /**
     * Sorts the visitors in the ride history using a custom comparator.
     *
     * @param comparator The comparator to use for sorting.
     */
    public void sortVisitors(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
    }

    /**
     * Exports the ride history to a file.
     *
     * @param fileName The name of the file to export the history to.
     */
    public void exportRideHistory(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            if (rideHistory.isEmpty()) {
                System.out.println("No visitors in the ride history to export.");
                return;
            }

            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                writer.write(String.format("%s,%d,%s,%s,%s",
                        visitor.getName(), visitor.getAge(), visitor.getAddress(),
                        visitor.getVisitorId(), visitor.getTicketType()));
                writer.newLine();
                writer.flush();
            }
            writer.close();
            System.out.println("Ride history successfully exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Imports ride history from a file.
     *
     * @param fileName The name of the file to import the history from.
     */
    public void importRideHistory(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] visitorData = line.split(",");
                if (visitorData.length == 5) {
                    String name = visitorData[0];
                    int age = Integer.parseInt(visitorData[1]);
                    String address = visitorData[2];
                    String id = visitorData[3];
                    String ticketType = visitorData[4];

                    Visitor visitor = new Visitor(name, age, address, id, ticketType);
                    rideHistory.add(visitor);
                }
            }
            System.out.println("Ride history successfully imported from " + fileName);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
