public class Flights {
    /**
     * a list of 30 different flight
     */
    public static Flight[] flight = new Flight[30];


    /**
     * n is a label used to show how many element does list have
     */
    public static int n;
//-----------------------------------------------------------------------------------

    /**
     * a function to set a new flight info at flights list
     * @param sampleFlight
     */
    public static void setFlight(Flight sampleFlight){
        Flights.flight[Flights.n]=sampleFlight;
        n++;
    }
}
