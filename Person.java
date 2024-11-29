/**
 * The Person class represents an individual with basic personal information
 * such as name, age, and address.
 */
public abstract class Person {
    private String name;
    private int age;
    private String address;

    /**
     * Default constructor that initializes the person's details to default values.
     */
    public Person() {
        this.name = "";
        this.age = 0;
        this.address = "";
    }

    /**
     * Constructor that initializes a person's details with the provided values.
     *
     * @param name The name of the person
     * @param age The age of the person
     * @param address The address of the person
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the person.
     *
     * @return The age of the person
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age The age of the person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the address of the person.
     *
     * @return The address of the person
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the person.
     *
     * @param address The address of the person
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
