
import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

/**
 * This class is consist of functions used to make the program!
 */
public class ShowFunction {
    public static void optionMenu() {
        TextArt.cls();
        System.out.println(ColorFullTextsAndBackground.Backgroundcolor1+":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.print(ColorFullTextsAndBackground.WHITE_BOLD);
        TextArt.showAirlineReservationSystem();
        //System.out.println("               Airline Reservation System                  ");
        System.out.print(ColorFullTextsAndBackground.RESET);
        System.out.println(ColorFullTextsAndBackground.Backgroundcolor1+"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.print(ColorFullTextsAndBackground.BLUE_BOLD);
        System.out.println("                                              <1> SIGN IN                          ");
        System.out.print(ColorFullTextsAndBackground.RED_BOLD);
        System.out.println("                                              <2> SIGN UP                          ");
        System.out.print(ColorFullTextsAndBackground.RESET);
        System.out.println("...................................................................................................................................");
        System.out.print(">>"+ColorFullTextsAndBackground.RESET);
    }
//*********************************************************************************************

    /**
     * this function use for sign up !
     */
    public static void signUpSection(){

        while(true) {
            TextArt.cls();
            boolean valid = true;
            Scanner input = new Scanner(System.in);
            System.out.println("..............................................................");
            System.out.print(ColorFullTextsAndBackground.RED_BOLD);
            System.out.println("                            SIGN UP                           ");
            System.out.print(ColorFullTextsAndBackground.RESET);
            System.out.println("..............................................................");
            System.out.print("            input your " + ColorFullTextsAndBackground.CYAN_BOLD + "username:" + ColorFullTextsAndBackground.RESET);
            String user_name = input.next();
            if (user_name.length()<3)
            {
                System.out.println(ColorFullTextsAndBackground.RED_BOLD+"invalid username!!!"+ColorFullTextsAndBackground.RESET);
                System.out.println("your username should be at least 3 character. ");
                valid = false;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for(int i = 0 ; i < Users.n ; i++) {
                if (user_name.equals(Users.simpleUsers[i].getUserName()))
                {
                    System.out.println(ColorFullTextsAndBackground.RED_BOLD+"this username already exist! "+ColorFullTextsAndBackground.RESET);
                    System.out.println("please try again >>");
                    valid = false;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if(valid==false)
            {
                continue;
            }
            System.out.print("            input your " + ColorFullTextsAndBackground.CYAN_BOLD + "password:" + ColorFullTextsAndBackground.RESET);
            String user_pass = input.next();

            System.out.print("            input your " + ColorFullTextsAndBackground.CYAN_BOLD + "name:" + ColorFullTextsAndBackground.RESET);
            String name_of_user = input.next();


            SimpleUser simpleUser = new SimpleUser(user_name, user_pass, name_of_user);
            Users.setSimpleUser(simpleUser);
            System.out.println("..............................................................");
            System.out.print(ColorFullTextsAndBackground.GREEN);
            System.out.println("                    signed up successfully!                   ");
            System.out.print(ColorFullTextsAndBackground.RESET);
            System.out.println("..............................................................");
            break;

        }
        try {
            Thread.sleep(2300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//***********************************************************************************************

    /**
     * This function use to print the menu of admin
     */
    public static void adminMenuShow(){
        TextArt.cls();
        System.out.println("..............................................................");
        System.out.print(ColorFullTextsAndBackground.WHITE_BOLD);
        System.out.println("                       Admin Menu Option                      ");
        System.out.print(ColorFullTextsAndBackground.RESET);
        System.out.println("..............................................................");
        System.out.print(ColorFullTextsAndBackground.YELLOW);
        System.out.println("                          <1>Add                              ");
        System.out.print(ColorFullTextsAndBackground.CYAN);
        System.out.println("                         <2>Update                            ");
        System.out.print(ColorFullTextsAndBackground.RED);
        System.out.println("                         <3>remove                            ");
        System.out.print(ColorFullTextsAndBackground.PURPLE);
        System.out.println("                      <4>FlightSchedule                       ");
        System.out.print(ColorFullTextsAndBackground.RESET);
        System.out.println("                         <0>LogOut                            ");
        System.out.println("..............................................................");
        System.out.print(">>");
    }

//*******************************************************************************************

    /**
     * This function print the menu of simpleUsers!
     */
    public static void simpleUserSignInMenu()
    {
        TextArt.cls();
        System.out.println("..............................................................");
        System.out.print(ColorFullTextsAndBackground.WHITE_BOLD);
        System.out.println("                    Passenger Menu Option                     ");
        System.out.print(ColorFullTextsAndBackground.RESET);
        System.out.println("..............................................................");
        System.out.print(ColorFullTextsAndBackground.YELLOW);
        System.out.println("                     <1>Change Password                       ");
        System.out.print(ColorFullTextsAndBackground.CYAN);
        System.out.println("                   <2>Search Flight Ticket                    ");
        System.out.print(ColorFullTextsAndBackground.PURPLE);
        System.out.println("                      <3>Booking Ticket                       ");
        System.out.print(ColorFullTextsAndBackground.RED);
        System.out.println("                      <4>Booked Tickets                       ");
        System.out.print(ColorFullTextsAndBackground.BLUE);
        System.out.println("                    <5>Ticket Cancellation                    ");
        System.out.print(ColorFullTextsAndBackground.GREEN);
        System.out.println("                        <6>Add charge                         ");
        System.out.print(ColorFullTextsAndBackground.RESET);
        System.out.println("                         <0>Sign Out                          ");
        System.out.println("..............................................................");
        System.out.print(">>");

    }

//****************************************************************************************signInMenu(all)

    /**
     * This function use for sign in!
     */
    public static void signInMenu()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("username:");
        String user_name = input.next();
        System.out.print("password:");
        String user_pass = input.next();
        for (int i = 0; i < Users.n ; i++)
        {
            if (user_name.equals(Users.simpleUsers[i].getUserName())) {


                while (user_pass.equals(Users.simpleUsers[i].getUserPass())) {//simple user log in:
                    ShowFunction.simpleUserSignInMenu();
                    String command = input.next();
                    while(command.equals("1"))//change password
                    {
                        changePassword(Users.simpleUsers[i]);
                        break;
                    }
                    while(command.equals("2"))
                    {

                        filteringTheFlights();
                        break;
                    }
                    while(command.equals("3"))
                    {
                        showFlightCharts();
                        bookTicket(Users.simpleUsers[i]);
                        break;
                    }
                    while(command.equals("4"))
                    {
                        showBookedTicket(Users.simpleUsers[i]);
                        break;
                    }

                    while(command.equals("5"))//Ticket cancellation
                    {
                        ticketCancellation(Users.simpleUsers[i]);
                        break;
                    }

                    while (command.equals("6"))//add charge menu
                    {
                        ShowFunction.showAddChargeMenu(Users.simpleUsers[i]);
                        break;
                    }
                    if(command.equals("0"))
                    {
                        break;
                    }
                }
            }
            else if(user_name.equals("admin"))
            {
                while(user_pass.equals("admin"))//admin log in menu
                {
                    ShowFunction.adminMenuShow();
                    String command = input.next();
                    adminSignInMenu(command);
                    if(command.equals("0"))
                    {
                        break;
                    }
                }
            }
        }
    }


//**************************************************************************************

    /**
     * This function use for adding charge!
     * @param user the user which we want to add him charge!
     */
    public static void showAddChargeMenu(SimpleUser user)
    {
        TextArt.cls();
        Scanner input = new Scanner(System.in);

        System.out.println("..............................................................");
        System.out.print(ColorFullTextsAndBackground.GREEN_BOLD);
        System.out.println("                         ADD CHARGE MENU                      ");
        System.out.print(ColorFullTextsAndBackground.RESET);
        System.out.println("..............................................................");
        System.out.println("your current charge is " + ColorFullTextsAndBackground.WHITE_BOLD + user.getCharge() + ColorFullTextsAndBackground.RESET + " toman!");
        System.out.print("press enter to add charge... ");
        input.nextLine();
        while(true) {
            TextArt.cls();
            TextArt.paypal();
            System.out.print("please enter the value you want to charge :");
            System.out.print(">> ");
            user.setCharge((user.getCharge() + input.nextInt()));
            System.out.print("Card number :");
            String cardNumber = input.next();
            System.out.print("Expiration Date: ");
            String expiration = input.next();
            System.out.print("CSC: ");
            String CSC = input.next();
            if(cardNumber.length()==16 )
            {
                if(expiration.contains("/")){
                    if(CSC.length()>=4)
                    {
                        System.out.print("Connecting to payment gateway...");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    else {
                        System.out.println(ColorFullTextsAndBackground.RED+"invalid CSC!"+ColorFullTextsAndBackground.RESET);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        continue;
                    }
                }
                else{
                    System.out.println(ColorFullTextsAndBackground.RED+"invalid expiration date!"+ColorFullTextsAndBackground.RESET);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    continue;
                }
            }
            else {
                System.out.println(ColorFullTextsAndBackground.RED+"card number should be 16 character!"+ColorFullTextsAndBackground.RESET);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                continue;
            }
            System.out.println("..............................................................");
            System.out.println(ColorFullTextsAndBackground.GREEN_BOLD+"The operation done!"+ColorFullTextsAndBackground.RESET);
            System.out.println("\nyour current charge is " + ColorFullTextsAndBackground.WHITE_BOLD + user.getCharge() + ColorFullTextsAndBackground.RESET + " toman");
            System.out.println("..............................................................");
            break;
        }
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//******************************************************************************************

    /**
     *Function to change password!
     */
    public static void changePassword(SimpleUser user)
    {
        TextArt.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("..............................................................");
        System.out.println(ColorFullTextsAndBackground.YELLOW+"                        CHANGE PASSWORD!                      "+ColorFullTextsAndBackground.RESET);
        System.out.println("..............................................................");
        System.out.println(ColorFullTextsAndBackground.YELLOW+" Your current password is : '"+ColorFullTextsAndBackground.BLUE_UNDERLINED + user.getUserPass()+ColorFullTextsAndBackground.RESET+"'");
        System.out.print(" Enter your new password : ");
        user.setUserPass(input.next());
        System.out.println("Your password updated to '"+ColorFullTextsAndBackground.BLUE_UNDERLINED +user.getUserPass()+ColorFullTextsAndBackground.RESET+"'");
        System.out.println("..............................................................");
        try {
            Thread.sleep(2300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
//*******************************************************************************************

    /**
     * Function to add a flight info and make a new flight!
     */
    public static void showAddFlight(){

        Scanner input = new Scanner(System.in);

        while(true) {
            TextArt.cls();
            boolean valid=true;
            System.out.println("..............................................................");
            System.out.print(ColorFullTextsAndBackground.YELLOW_BOLD);
            System.out.println("                         ADD FLIGHT                           ");
            System.out.print(ColorFullTextsAndBackground.RESET);
            System.out.println("..............................................................");
            System.out.print(ColorFullTextsAndBackground.PURPLE);
            System.out.print("Enter flight ID :");
            String Id = input.next();
            for(int i = 0 ; i<Flights.n ; i++)
            {
                if(Id.equals(Flights.flight[i].getFlightID()))
                {
                    System.out.println("This flight ID already exist!");
                    System.out.println("Please change the ID and try again.");
                    valid = false;
                }

            }
            if(Id.length()<3){
                System.out.println("invalid flight ID !");
                valid = false;
            }
            if(valid==false)
            {
                continue;
            }

            System.out.print("Enter flight origin: ");
            String origin = input.next();
            System.out.print("Enter flight destination: ");
            String destination = input.next();
            System.out.print("Enter flight date: ");
            String date = input.next();
            System.out.print("Enter flight time: ");
            String time = input.next();
            System.out.print("Enter flight price: ");
            int price = input.nextInt();
            System.out.print("Enter flight seats: ");
            int seats = input.nextInt();


            Flight ticket = new Flight(Id, origin, destination, date, time, price, seats);
            Flights.setFlight(ticket);
            System.out.print(ColorFullTextsAndBackground.GREEN);
            System.out.println("                           DONE!                              ");
            System.out.println(ColorFullTextsAndBackground.RESET);
            System.out.println("..............................................................");
            break;
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


//**********************************************************************************************


//*****************************************************************************************

    /**
     * function to print the flight schedule!
     */
    public static void showFlightCharts(){
        Scanner input = new Scanner(System.in);
        TextArt.cls();
        System.out.println("                                            "+"__________________________________________________________");
        System.out.println("                                            "+ColorFullTextsAndBackground.PURPLE_BOLD+"                     FLIGHT SCHEDULE                      ");
        System.out.println("                                            "+ColorFullTextsAndBackground.RESET+ "__________________________________________________________");
        System.out.printf("| %-20s | %-20s | %-20s | %-15s | %-20s | %-20s | %-6s |\n","FLiGHT ID","ORIGIN","DESTINATION","DATE","TIME","price","SEAT");
        System.out.println("...............................................................................................................................................");
        for(int i = 0; i < Flights.n ; i++){
            System.out.printf("|"+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+ColorFullTextsAndBackground.CYAN+" %-20s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.GREEN+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s"+ColorFullTextsAndBackground.RESET+" |"+ColorFullTextsAndBackground.PURPLE+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s"+ColorFullTextsAndBackground.RESET+" |"+ColorFullTextsAndBackground.YELLOW+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-15s"+ColorFullTextsAndBackground.RESET+" | "+ColorFullTextsAndBackground.BLUE+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+"%-20s "+ColorFullTextsAndBackground.RESET+"| "+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+"%-20d "+ColorFullTextsAndBackground.RESET+"| "+ColorFullTextsAndBackground.RED+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+"%-6d "+ColorFullTextsAndBackground.RESET+"|\n",Flights.flight[i].getFlightID(),Flights.flight[i].getOrigin(),Flights.flight[i].getDestination(),Flights.flight[i].getDate(),Flights.flight[i].getTime(),Flights.flight[i].getPrice(),Flights.flight[i].getSeats());
            System.out.println("...............................................................................................................................................");

        }
        System.out.println("Press Enter to continue...");
        input.nextLine();
    }

//**************************************************************************************************

    /**
     * function to change information of a flight!
     */
    public static void showUpdateMenu(){
        TextArt.cls();
        showFlightCharts();
        Scanner input = new Scanner(System.in);
        System.out.println("..............................................................");
        System.out.println(ColorFullTextsAndBackground.CYAN+"                          UPDATE MENU                         "+ColorFullTextsAndBackground.RESET);
        System.out.println(".............................................................."+ColorFullTextsAndBackground.BLUE);
        for(int i =0;i<Flights.n;i++)
        {
            System.out.println("ID :"+Flights.flight[i].getFlightID());
        }
        System.out.println(ColorFullTextsAndBackground.RESET+"..............................................................");
        System.out.print("Enter the Id of flight you want to change:");
        String id = input.next();
        for(int i =0 ; i<Flights.n ; i++)
        {
            while(Flights.flight[i].getFlightID().equals(id))
            {
                if(Flights.flight[i].isAdminChangePermission()) {
                    System.out.println("which one you want to update?");
                    System.out.println(ColorFullTextsAndBackground.RED + "1-origin");
                    System.out.println(ColorFullTextsAndBackground.BLUE + "2-destination");
                    System.out.println(ColorFullTextsAndBackground.GREEN + "3-date");
                    System.out.println(ColorFullTextsAndBackground.CYAN + "4-time");
                    System.out.println(ColorFullTextsAndBackground.YELLOW + "5-price");
                    System.out.println(ColorFullTextsAndBackground.PURPLE + "6-seats");
                    System.out.println("0-LogOut");
                    System.out.print(">>");
                    String commandForUpdate = input.next();
                    while (commandForUpdate.equals("1")) {
                        System.out.print("input the new origin: ");
                        Flights.flight[i].setOrigin(input.next());
                        System.out.println("Updated successfully!");
                        break;
                    }
                    while (commandForUpdate.equals("2")) {
                        System.out.print("input the new destination: ");
                        Flights.flight[i].setDestination(input.next());
                        System.out.println("Updated successfully!");
                        break;
                    }
                    while (commandForUpdate.equals("3")) {
                        System.out.print("input the new date: ");
                        Flights.flight[i].setDate(input.next());
                        System.out.println("Updated successfully!");
                        break;
                    }
                    while (commandForUpdate.equals("4")) {
                        System.out.print("input the new time: ");
                        Flights.flight[i].setTime(input.next());
                        System.out.println("Updated successfully!");
                        break;
                    }
                    while (commandForUpdate.equals("5")) {
                        System.out.print("input the price : ");
                        Flights.flight[i].setPrice(input.nextInt());
                        System.out.println("Updated successfully!");
                        break;
                    }
                    while (commandForUpdate.equals("6")) {
                        System.out.print("input the new seats : ");
                        Flights.flight[i].setSeats(input.nextInt());
                        System.out.println("Updated successfully!");
                        break;
                    }
                    if (commandForUpdate.equals("0")) {
                        break;
                    }
                }
                else if(!Flights.flight[i].isAdminChangePermission()){
                    System.out.println("unable to change this flight because some user have already booked tickets!");
                    System.out.println("press enter to continue...");
                    input.nextLine();
                    break;
                }
            }
        }
        System.out.println("..............................................................");
    }


//******************************************************************************************

    /**
     * function to remove a flight from the schedule!
     */
    public static void showRemoveFlight(){
        Scanner input = new Scanner(System.in);
        while(true) {
            boolean removedSuccessfully = false;
            TextArt.cls();
            ShowFunction.showFlightCharts();
            System.out.println("..............................................................");
            System.out.println(ColorFullTextsAndBackground.RED_BOLD+"                        REMOVE FLIGHT                         ");
            System.out.println(ColorFullTextsAndBackground.RESET+".............................................................."+ColorFullTextsAndBackground.BLUE);
            for(int i =0;i<Flights.n;i++)
            {
                System.out.println("ID :"+Flights.flight[i].getFlightID());
            }
            System.out.print(ColorFullTextsAndBackground.RESET+"Enter the FLight ID you want to remove or 0 to return back: ");
            String removedId = input.next();
            if(removedId.equals("0"))
            {
                break;
            }
            for (int i = 0; i < Flights.n; i++) {
                if (Flights.flight[i].getFlightID().equals(removedId)) {

                    if(Flights.flight[i].isAdminChangePermission()) {
                        for (int j = i; j < Flights.n - 1; j++) {
                            Flights.flight[j] = Flights.flight[j + 1];
                        }
                        Flights.n = Flights.n - 1;
                        removedSuccessfully = true;
                        break;
                    }
                    else if (!Flights.flight[i].isAdminChangePermission()){
                        System.out.println(ColorFullTextsAndBackground.RED_BOLD+"unable to remove this flight because many users have already booked it!");
                        System.out.println(ColorFullTextsAndBackground.RESET+"press enter to continue...");
                        input.nextLine();
                        break;
                    }
                }
            }
            if(removedSuccessfully) {
                System.out.println("The flight " + removedId + "has been removed!");
            }
            System.out.println("press 0 to return to admin main menu");
            System.out.print(">>");
            String command = input.next();
            if(command.equals("0"))
            {
                break;
            }
        }
    }

//*********************************************************************************************

    /**
     * function that get admin command and show him the scope that he want!
     * @param command
     */
    public static void adminSignInMenu(String command)
    {
        while (command.equals("1"))//add flight menu
        {
            ShowFunction.showAddFlight();
            break;
        }
        while (command.equals("2"))
        {
            ShowFunction.showUpdateMenu();
            break;
        }
        while(command.equals("3"))
        {
            showRemoveFlight();
            break;
        }
        while(command.equals("4"))//show schedule menu
        {
            showFlightCharts();
            break;
        }
    }
//*************************************************************************************************************

    /**
     * function that get an integer number and make random String number!
     * @param l : The length of the String
     * @return a random String !
     */
    public static String uniqStringGenerator(int l)
    {
        String str1 = " ";
        String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
        Random rand = new Random();
        for(int i = 0 ; i < l ; i++)
        {
            str1 = str1 + alphabet.charAt(Math.abs(rand.nextInt())%35);
        }
        return str1;
    }

//**********************************************************************************************************

    /**
     * function for booking a ticket!
     * @param sample
     */
    public static void bookTicket(SimpleUser sample)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("..............................................................");
        System.out.print(ColorFullTextsAndBackground.YELLOW_BOLD);
        System.out.println("                       BOOKING TICKET                         ");
        System.out.print(ColorFullTextsAndBackground.RESET);
        System.out.println(".............................................................."+ColorFullTextsAndBackground.CYAN);
        for(int j =0;j<Flights.n;j++)
        {
            System.out.println("ID :"+Flights.flight[j].getFlightID());
        }
        System.out.println(ColorFullTextsAndBackground.RESET+"please Enter the ID of flight you want to buy: ");
        String flightId = input.next();
        for(int j =0 ; j <= Flights.n -1 ;j++)
        {
            if(Flights.flight[j].getFlightID().equals(flightId))
            {
                if(sample.getCharge() >= Flights.flight[j].getPrice()&& Flights.flight[j].getSeats()>=1) {
                    String flightID = Flights.flight[j].getFlightID();
                    String origin = Flights.flight[j].getOrigin();
                    String destination = Flights.flight[j].getDestination();
                    String date = Flights.flight[j].getDate();
                    String time = Flights.flight[j].getOrigin();
                    int price = Flights.flight[j].getPrice();
                    String passengerName = sample.getUsername();
                    String uniqTicketID = uniqStringGenerator(20);
                    Flights.flight[j].setSeats(Flights.flight[j].getSeats()-1);
                    sample.setCharge(sample.getCharge()-Flights.flight[j].getPrice());
                    Flights.flight[j].setAdminChangePermission(false);


                    Ticket ticket = new Ticket(flightID, origin, destination, date, time, price, passengerName, uniqTicketID);
                    sample.setTicket(ticket);
                    System.out.println(ColorFullTextsAndBackground.GREEN_BOLD+"booked successfully!"+ColorFullTextsAndBackground.RESET);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (sample.getCharge()<Flights.flight[j].getPrice()){
                    System.out.println("Not enough charge!");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(Flights.flight[j].getSeats()<1)
                {
                    System.out.println("doesn't have any empty seats!");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

//****************************************************************************************************************************

    /**
     * function that shows the user booked Tickets!
     * @param sample
     */
    public static void showBookedTicket(SimpleUser sample)
    {
        Scanner input = new Scanner(System.in);
        TextArt.cls();
        System.out.println("                                               .................................................................");
        System.out.println("                                               "+ColorFullTextsAndBackground.RED+"                            BOOKED TICKET "+ColorFullTextsAndBackground.RESET+"                       ");
        System.out.println("                                               .................................................................");
        System.out.printf("| %-20s | %-20s | %-20s | %-15s | %-20s | %-20s | %-22s |\n","FLiGHT ID","ORIGIN","DESTINATION","DATE","TIME","Price","TicketID");
        System.out.println(".................................................................................................................................................");
        for(int j =0 ; j < sample.k ; j++)
        {
            System.out.printf("|"+ColorFullTextsAndBackground.RED+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"| "+ColorFullTextsAndBackground.CYAN+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+"%-20s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.PURPLE+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.BLUE+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-15s "+ColorFullTextsAndBackground.RESET+"| "+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+"%-20s"+ColorFullTextsAndBackground.RESET+" |"+ColorFullTextsAndBackground.BROWN+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"| "+ColorFullTextsAndBackground.YELLOW+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+"%-22s"+ColorFullTextsAndBackground.RESET+" |\n",sample.userTicket[j].getFlightId(),sample.userTicket[j].getOrigin(),sample.userTicket[j].getDestination(),sample.userTicket[j].getDate(),sample.userTicket[j].getTime(),sample.userTicket[j].getPrice(),sample.userTicket[j].getTicketId());
            System.out.println(".................................................................................................................................................");
        }
        System.out.println("Press enter to continue...");
        input.nextLine();
    }

//***********************************************************************************************************************************************

    /**
     * Function that cancel a flight Ticket reservation!
     * @param sample
     */
    public static void ticketCancellation(SimpleUser sample)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("..............................................................");
        System.out.print(ColorFullTextsAndBackground.BLUE);
        System.out.println("                       TICKET CANCELLATION!                    ");
        System.out.print(ColorFullTextsAndBackground.RESET);
        System.out.println("..............................................................");
        showBookedTicket(sample);
        System.out.print("input the flightID of the Ticket which you want to cancel: ");
        String flightID = input.next();
        for(int j =0 ; j < sample.k ; j++)
        {
            if(sample.userTicket[j].getFlightId().equals(flightID))
            {
                sample.setCharge(sample.getCharge()+sample.userTicket[j].getPrice());
                for(int h = 0 ; h < Flights.n ; h++)
                {
                    if(Flights.flight[h].getFlightID().equals(sample.userTicket[j].getFlightId()))
                    {
                        Flights.flight[h].setSeats(Flights.flight[h].getSeats()+1);
                    }
                }
                if(sample.k >1) {
                    for (int l = j + 1; l < sample.k; l++) {
                        sample.userTicket[l - 1] = sample.userTicket[l];
                        sample.k--;
                    }
                }
                else {
                    sample.k=0;
                }
                System.out.println(ColorFullTextsAndBackground.GREEN_BOLD+"Ticket canceled successfully!"+ColorFullTextsAndBackground.RESET);
                System.out.println("..............................................................");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                break;
            }
        }
    }
//***************************************************************************************************************************

    /**
     * this function use to filter the flight schedule by user requests!
     */
    public static void filteringTheFlights()
    {
        int t = 0;
        while(t==0){
            TextArt.cls();
            Scanner input = new Scanner(System.in);
            printFilterFlightMenu();

            String command = input.next();
            while (command.equals("1")) {
                System.out.print("Search in FlightID: ");
                String filtered = input.next();

                for (int j = 0; j < Flights.n; j++) {
                    if (Flights.flight[j].getFlightID().contains(filtered)) {
                        Filteredflight.filterFlights[Filteredflight.label] = Flights.flight[j];
                        Filteredflight.label++;
                    }
                }
                break;
            }
            while (command.equals("2")) {
                System.out.print("Search in Origin: ");
                String filtered = input.next();
                for (int j = 0; j < Flights.n; j++) {
                    if(Flights.flight[j].getOrigin().contains(filtered))
                    {
                        Filteredflight.filterFlights[Filteredflight.label]= Flights.flight[j];
                        Filteredflight.label++;
                    }
                }
                break;
            }

            while (command.equals("3")) {
                System.out.print("Search in Destination: ");
                String filtered = input.next();

                for (int j = 0; j < Flights.n; j++) {
                    if (Flights.flight[j].getDestination().contains(filtered)) {
                        Filteredflight.filterFlights[Filteredflight.label] = Flights.flight[j];
                        Filteredflight.label++;
                    }
                }
                break;
            }
            while (command.equals("5")) {
                System.out.println("Search in Date : ");
                String filtered = input.next();

                for (int j = 0; j < Flights.n; j++) {
                    if (Flights.flight[j].getDate().contains(filtered)) {
                        Filteredflight.filterFlights[Filteredflight.label] = Flights.flight[j];
                        Filteredflight.label++;
                    }
                }
                break;
            }
            while (command.equals("6")) {
                System.out.println("Search in Time : ");
                String filtered = input.next();

                for (int j = 0; j < Flights.n; j++) {
                    if (Flights.flight[j].getTime().contains(filtered)) {
                        Filteredflight.filterFlights[Filteredflight.label] = Flights.flight[j];
                        Filteredflight.label++;
                    }
                }
                break;
            }
            while(command.equals("4")){
                System.out.print("Search in Price : ");
                int filtered = input.nextInt();
                for(int j =0 ; j < Flights.n ; j++)
                {
                    if (Flights.flight[j].getPrice()<filtered)
                    {
                        Filteredflight.filterFlights[Filteredflight.label] = Flights.flight[j];
                        Filteredflight.label++;
                    }
                }
                break;
            }
            System.out.printf("| %-20s | %-20s | %-20s | %-15s | %-20s | %-20s | %-6s |\n","FLiGHT ID","ORIGIN","DESTINATION","DATE","TIME","price","SEAT");
            System.out.println(".........................................................................................................................................................");
            for(int j = 0 ; j < Filteredflight.label ; j++) {
                System.out.printf("| "+"%-20s "+"|"+ColorFullTextsAndBackground.CYAN+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.YELLOW+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"| "+ColorFullTextsAndBackground.RED+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+"%-15s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.GREEN+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.PURPLE+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.BLUE+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-6s "+ColorFullTextsAndBackground.RESET+"|\n", Filteredflight.filterFlights[j].getFlightID(), Filteredflight.filterFlights[j].getOrigin(), Filteredflight.filterFlights[j].getDestination(), Filteredflight.filterFlights[j].getDate(), Filteredflight.filterFlights[j].getTime(), Filteredflight.filterFlights[j].getPrice(), Filteredflight.filterFlights[j].getSeats());
                System.out.println(".........................................................................................................................................................");
            }


            t=1;
            if(command.equals("0"))
            {
                t=2;
                Filteredflight.label=0;
            }
        }
        while(t==1){
            Scanner input = new Scanner(System.in);
            printFilterFlightMenu2();
            String command = input.next();
            while (command.equals("1")) {
                System.out.print("flightID :");
                String filtered = input.next();
                for (int j = 0; j<Filteredflight.label; j++) {
                    if (!Filteredflight.filterFlights[j].getFlightID().contains(filtered)) {
                        System.out.println("h");
                        for(int l = j ; l <= Filteredflight.label ; l++)
                        {
                            Filteredflight.filterFlights[l]=Filteredflight.filterFlights[l+1];
                            Filteredflight.label--;
                        }
                    }
                }
                break;
            }
            while (command.equals("2")) {
                System.out.print("Origin: ");
                String filtered = input.next();

                for (int j = 0; j<Filteredflight.label; j++) {
                    if (!Filteredflight.filterFlights[j].getOrigin().contains(filtered)) {
                        for(int l = j ; l <= Filteredflight.label ; l++)
                        {
                            Filteredflight.filterFlights[l]=Filteredflight.filterFlights[l+1];
                            Filteredflight.label--;
                        }
                    }
                }
                break;
            }
            while (command.equals("3")) {
                System.out.print("Destination: ");
                String filtered = input.next();

                for (int j = 0; j<Filteredflight.label; j++) {
                    if (!Filteredflight.filterFlights[j].getDestination().contains(filtered)) {
                        for(int l = j ; l <= Filteredflight.label ; l++)
                        {
                            Filteredflight.filterFlights[l]=Filteredflight.filterFlights[l+1];
                            Filteredflight.label--;
                        }
                    }
                }
                break;
            }
            while (command.equals("5")) {
                System.out.print("Date: ");
                String filtered = input.next();

                for (int j = 0; j<Filteredflight.label; j++) {
                    if (!Filteredflight.filterFlights[j].getDate().contains(filtered)) {
                        for(int l = j ; l <= Filteredflight.label ; l++)
                        {
                            Filteredflight.filterFlights[l]=Filteredflight.filterFlights[l+1];
                            Filteredflight.label--;
                        }
                    }
                }
                break;
            }
            while (command.equals("6")) {
                System.out.print("Time: ");
                String filtered = input.next();

                for (int j = 0; j<Filteredflight.label; j++) {
                    if (!Filteredflight.filterFlights[j].getTime().contains(filtered)) {
                        for(int l = j ; l <= Filteredflight.label ; l++)
                        {
                            Filteredflight.filterFlights[l]=Filteredflight.filterFlights[l+1];
                            Filteredflight.label--;
                        }
                    }
                }
                break;
            }
            while (command.equals("4")) {
                System.out.print("price: ");
                int filtered = input.nextInt();

                for (int j = 0; j<Filteredflight.label; j++) {
                    if (Filteredflight.filterFlights[j].getPrice() > filtered) {
                        for(int l = j ; l <= Filteredflight.label ; l++)
                        {
                            Filteredflight.filterFlights[l]=Filteredflight.filterFlights[l+1];
                            Filteredflight.label--;
                        }
                    }
                }
                break;
            }

//hahaha
            System.out.printf("| %-20s | %-20s | %-20s | %-15s | %-20s | %-20s | %-6s |\n","FLiGHT ID","ORIGIN","DESTINATION","DATE","TIME","price","SEAT");
            System.out.println(".........................................................................................................................................................");
            for(int j = 0 ; j < Filteredflight.label ; j++) {
                System.out.printf("| "+"%-20s "+"|"+ColorFullTextsAndBackground.CYAN+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.YELLOW+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"| "+ColorFullTextsAndBackground.RED+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+"%-15s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.GREEN+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.PURPLE+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-20s "+ColorFullTextsAndBackground.RESET+"|"+ColorFullTextsAndBackground.BLUE+ColorFullTextsAndBackground.BACKGROUND_COLOR_2+" %-6s "+ColorFullTextsAndBackground.RESET+"|\n", Filteredflight.filterFlights[j].getFlightID(), Filteredflight.filterFlights[j].getOrigin(), Filteredflight.filterFlights[j].getDestination(), Filteredflight.filterFlights[j].getDate(), Filteredflight.filterFlights[j].getTime(), Filteredflight.filterFlights[j].getPrice(), Filteredflight.filterFlights[j].getSeats());
                System.out.println(".........................................................................................................................................................");
            }


                if(command.equals("0"))
            {
                Filteredflight.label = 0;
                break ;
            }






        }
        TextArt.cls();
    }
    //****************************************************************************************************************************
    public static void printFilterFlightMenu()
    {
        showFlightCharts();
        System.out.println("...........................................................................");
        System.out.println(ColorFullTextsAndBackground.YELLOW_BOLD+"                 input the feature you want to filter with:                ");
        System.out.println("...........................................................................");
        System.out.println(ColorFullTextsAndBackground.CYAN+"                              1-FlightID                                   ");
        System.out.println(ColorFullTextsAndBackground.RED+"                               2-Origin                                    ");
        System.out.println(ColorFullTextsAndBackground.GREEN+"                             3-Destination                                 ");
        System.out.println(ColorFullTextsAndBackground.PURPLE+"                                4-Price                                    ");
        System.out.println(ColorFullTextsAndBackground.BROWN+"                                5-Date                                     ");
        System.out.println(ColorFullTextsAndBackground.YELLOW+"                                6-Time                                     ");
        System.out.println(ColorFullTextsAndBackground.RESET+"                                0-Exit                                     ");
        System.out.println("...........................................................................");
    }
    //**************************************************************************************************************************
    public static void printFilterFlightMenu2()
    {
        System.out.println("...........................................................................");
        System.out.println(ColorFullTextsAndBackground.YELLOW_BOLD+"                 choose the next feature you want to search:               ");
        System.out.println("...........................................................................");
        System.out.println(ColorFullTextsAndBackground.CYAN+"                              1-FlightID                                   ");
        System.out.println(ColorFullTextsAndBackground.RED+"                               2-Origin                                    ");
        System.out.println(ColorFullTextsAndBackground.GREEN+"                             3-Destination                                 ");
        System.out.println(ColorFullTextsAndBackground.PURPLE+"                                4-Price                                    ");
        System.out.println(ColorFullTextsAndBackground.BROWN+"                                5-Date                                     ");
        System.out.println(ColorFullTextsAndBackground.YELLOW+"                                6-Time                                     ");
        System.out.println(ColorFullTextsAndBackground.RESET+"                                0-Exit                                     ");
        System.out.println("...........................................................................");
    }
}