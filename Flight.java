public class Flight {
    /**
     * Flight features
     */
    private String origin;
    private String destination;
    private String time;
    private int price;
    private int seats;
    private String flightID;
    private String date;

    //-------------------------------------------------------

    /**
     * constructor to make a flight
     * @param flightID
     * @param origin
     * @param destination
     * @param date
     * @param time
     * @param price
     * @param seats
     */
    public Flight(String flightID,String origin ,String destination ,String date,String time ,int price ,int seats)
    {
        this.flightID=flightID;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seats = seats;
    }

    //-------------------------------------------------------

    /**
     * Getter and setters
     */

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
