/**
 * This class demonstrates various functionalities of an amusement park ride system.
 */
public class AssignmentTwo {
    /**
     * Main method to execute the different parts of the assignment.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        AssignmentTwo test = new AssignmentTwo();
        test.partThree();
        test.partFourA();
        test.partFourB();
        test.partFive();
        test.partSix();
        test.partSeven();
    }

    /**
     * Demonstrates adding visitors to the ride queue, removing a visitor,
     * and printing the current queue.
     */
    public void partThree(){
        Employee employee = new Employee("John", 30, "aaaa", "E1", "Ride Operator");
        Ride ride = new Ride("Roller Coaster", 3, employee, 1);

        Visitor visitor1 = new Visitor("Alice", 25, "bbbb", "V1", "Regular");
        Visitor visitor2 = new Visitor("Bob", 30, "cccc", "V2", "VIP");
        Visitor visitor3 = new Visitor("Charlie", 20, "dddd", "V3", "Family");
        Visitor visitor4 = new Visitor("Diana", 28, "eeee", "V4", "Regular");
        Visitor visitor5 = new Visitor("Eve", 22, "ffff", "V5", "Regular");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        ride.removeVisitorFromQueue();

        ride.printQueue();
    }

    /**
     * Demonstrates adding visitors to the ride history, checking a visitor's ride status,
     * counting visitors, and printing the ride history.
     */
    public void partFourA(){
        Employee employee = new Employee("John", 30, "aaaa", "E1", "Ride Operator");
        Ride ride = new Ride("Roller Coaster", 3, employee, 1);

        Visitor visitor1 = new Visitor("Alice", 25, "bbbb", "V1", "Regular");
        Visitor visitor2 = new Visitor("Bob", 30, "cccc", "V2", "VIP");
        Visitor visitor3 = new Visitor("Charlie", 20, "dddd", "V3", "Family");
        Visitor visitor4 = new Visitor("Diana", 28, "eeee", "V4", "Regular");
        Visitor visitor5 = new Visitor("Eve", 22, "ffff", "V5", "Regular");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        boolean visited = ride.checkVisitorFromHistory(visitor1);  // true
        System.out.println("visited: " + visited);

        System.out.println("Number of visitors who have taken the ride: " + ride.numberOfVisitors());

        ride.printRideHistory();
    }

    /**
     * Demonstrates adding visitors to the ride history, sorting them using a comparator,
     * and printing the ride history before and after sorting.
     */
    public void partFourB(){
        Employee employee = new Employee("John", 30, "aaaa", "E1", "Ride Operator");
        Ride ride = new Ride("Roller Coaster", 3, employee, 1);

        Visitor visitor1 = new Visitor("Alice", 25, "bbbb", "V3", "Regular");
        Visitor visitor2 = new Visitor("Bob", 30, "cccc", "V1", "VIP");
        Visitor visitor3 = new Visitor("Charlie", 20, "dddd", "V2", "Family");
        Visitor visitor4 = new Visitor("Diana", 28, "eeee", "V5", "Regular");
        Visitor visitor5 = new Visitor("Eve", 22, "ffff", "V4", "Regular");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        ride.printRideHistory();

        ride.sortVisitors(new VisitorComparator());

        ride.printRideHistory();
    }

    /**
     * Demonstrates managing the ride queue when its capacity is reached,
     * running one cycle, and observing changes in queue and ride history.
     */
    public void partFive(){
        Employee employee = new Employee("John", 30, "aaaa", "E1", "Ride Operator");
        Ride ride = new Ride("Roller Coaster", 3, employee, 3);

        Visitor visitor1 = new Visitor("One", 25, "bbbb", "V1", "Regular");
        Visitor visitor2 = new Visitor("Two", 30, "cccc", "V2", "VIP");
        Visitor visitor3 = new Visitor("Three", 20, "dddd", "V3", "Family");
        Visitor visitor4 = new Visitor("Four", 28, "eeee", "V4", "Regular");
        Visitor visitor5 = new Visitor("Five", 22, "ffff", "V5", "Regular");
        Visitor visitor6 = new Visitor("Six", 25, "bbbb", "V6", "Regular");
        Visitor visitor7 = new Visitor("Seven", 30, "cccc", "V7", "VIP");
        Visitor visitor8 = new Visitor("Eight", 20, "dddd", "V8", "Family");
        Visitor visitor9 = new Visitor("Nine", 28, "eeee", "V9", "Regular");
        Visitor visitor10 = new Visitor("Ten", 22, "ffff", "V10", "Regular");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);
        ride.addVisitorToQueue(visitor6);
        ride.addVisitorToQueue(visitor7);
        ride.addVisitorToQueue(visitor8);
        ride.addVisitorToQueue(visitor9);
        ride.addVisitorToQueue(visitor10);

        ride.printQueue();

        ride.runOneCycle();

        ride.printQueue();

        ride.printRideHistory();
    }

    /**
     * Demonstrates exporting the ride history to a CSV file.
     */
    public void partSix(){
        Employee employee = new Employee("John", 30, "aaaa", "E1", "Ride Operator");
        Ride ride = new Ride("Roller Coaster", 3, employee, 3);

        Visitor visitor1 = new Visitor("One", 25, "bbbb", "V1", "Regular");
        Visitor visitor2 = new Visitor("Two", 30, "cccc", "V2", "VIP");
        Visitor visitor3 = new Visitor("Three", 20, "dddd", "V3", "Family");
        Visitor visitor4 = new Visitor("Four", 28, "eeee", "V4", "Regular");
        Visitor visitor5 = new Visitor("Five", 22, "ffff", "V5", "Regular");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        ride.exportRideHistory("history.csv");
    }

    /**
     * Demonstrates importing the ride history from a CSV file,
     * counting visitors, and printing the imported ride history.
     */
    public void partSeven(){
        Employee employee = new Employee("John", 30, "aaaa", "E1", "Ride Operator");
        Ride ride = new Ride("Roller Coaster", 3, employee, 3);
        ride.importRideHistory("history.csv");

        System.out.println("Number of visitors who have taken the ride: " + ride.numberOfVisitors());

        ride.printRideHistory();
    }
}
