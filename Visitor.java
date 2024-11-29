/**
 * The Visitor class represents a visitor and extends the Person class.
 */
public class Visitor extends Person {
    private String visitorId;
    private String ticketType;

    /**
     * Default constructor that initializes the visitor's details to default values.
     */
    public Visitor() {
        super();
        this.visitorId = "";
        this.ticketType = "";
    }

    /**
     * Constructor that initializes a visitor's details with the provided values.
     *
     * @param name The name of the visitor
     * @param age The age of the visitor
     * @param address The address of the visitor
     * @param visitorId The visitor's unique ID
     * @param ticketType The type of ticket held by the visitor
     */
    public Visitor(String name, int age, String address, String visitorId, String ticketType) {
        super(name, age, address);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
    }

    /**
     * Gets the unique ID of the visitor.
     *
     * @return The visitor's ID
     */
    public String getVisitorId() {
        return visitorId;
    }

    /**
     * Sets the unique ID of the visitor.
     *
     * @param visitorId The visitor's ID to set
     */
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    /**
     * Gets the type of ticket held by the visitor.
     *
     * @return The ticket type of the visitor
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * Sets the type of ticket held by the visitor.
     *
     * @param ticketType The ticket type to set for the visitor
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
