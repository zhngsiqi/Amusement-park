/**
 * The Employee class represents an employee, extending the Person class.
 */
public class Employee extends Person {
    private String employeeId;
    private String position;

    /**
     * Default constructor that initializes the employee's details to default values.
     */
    public Employee() {
        super();
        this.employeeId = "";
        this.position = "";
    }

    /**
     * Constructor that initializes an employee's details with the provided values.
     *
     * @param name The name of the employee
     * @param age The age of the employee
     * @param address The address of the employee
     * @param employeeId The employee's unique ID
     * @param position The position/job title of the employee
     */
    public Employee(String name, int age, String address, String employeeId, String position) {
        super(name, age, address);
        this.employeeId = employeeId;
        this.position = position;
    }

    /**
     * Gets the employee's ID.
     *
     * @return The employee's ID
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee's ID.
     *
     * @param employeeId The employee's ID to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the employee's position/job title.
     *
     * @return The employee's position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the employee's position/job title.
     *
     * @param position The position to set for the employee
     */
    public void setPosition(String position) {
        this.position = position;
    }
}
