public class Flights {
    public static Flight[] flight = new Flight[30];
    public static int n;


    public static void setFlight(Flight sampleflight){
        Flights.flight[Flights.n]=sampleflight;
        n++;
    }
}
