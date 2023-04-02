public class Ticket {
    /**
     * feature
     */
    private String flightId ;
    private String origin ;
    private String destination ;
    private String date ;
    private String time;
    private int price;
    private String passangerName;
    private String ticketId ;

    //--------------------------------------------------------------------------------constructor

    /**
     * constructor to make a new Ticket
     * @param flightId
     * @param origin
     * @param destination
     * @param date
     * @param time
     * @param price
     * @param passangerName
     * @param ticketId
     */
    public Ticket(String flightId , String origin , String destination , String date , String time , int price , String passangerName , String ticketId)
    {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date =date;
        this.time = time;
        this.price = price;
        this.passangerName = passangerName;
        this.ticketId = ticketId;
    }


    //-------------------------------------------------------------------------------

    /**
     *Setters & Getters
     */
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPassangerName() {
        return passangerName;
    }

    public void setPassangerName(String passangerName) {
        this.passangerName = passangerName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
