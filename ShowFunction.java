import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;
public class ShowFunction {

    public static void optionMenu() {
        System.out.println("...........................................................");
        System.out.println("               Airline Reservation System                  ");
        System.out.println("...........................................................");
        System.out.println("                        1-sign in                          ");
        System.out.println("                        2-sign up                          ");
        System.out.println("...........................................................");
        System.out.print(">>");
    }
    //*********************************************************************************************
    public static void signUpSection(){
        Scanner input = new Scanner(System.in);
        System.out.println("....................................................");
        System.out.print("            input your username:");
        String user_name = input.next();
        System.out.print("            input your password:");
        String user_pass = input.next();
        System.out.print("            input your name:");
        String name_of_user = input.next();

        SimpleUser simpleUser = new SimpleUser(user_name, user_pass, name_of_user);
        Users.setSimpleUser(simpleUser);
        System.out.println("....................................................");
        System.out.println("          signed up successfully!");
        System.out.println("....................................................");
    }
//***********************************************************************************************
    public static void adminMenuShow(){
        System.out.println("................................................");
        System.out.println("                Admin Menu Option               ");
        System.out.println("................................................");
        System.out.println("                     1-Add                      ");
        System.out.println("                    2-Update                    ");
        System.out.println("                    3-remove                    ");
        System.out.println("                 4-FlightSchedule               ");
        System.out.println("                    0-LogOut                    ");
        System.out.println("................................................");
        System.out.print(">>");
    }

    //*******************************************************************************************

    public static void simpleUserSignInMenu()
    {
        System.out.println("....................................................");
        System.out.println("               Passenger Menu Option                ");
        System.out.println("....................................................");
        System.out.println("                1-Change Password                   ");
        System.out.println("               2-Search Flight Ticket               ");
        System.out.println("                3-Booking Ticket                    ");
        System.out.println("                 4-Booked TIckets                   ");
        System.out.println("              5-Ticket Cancellation                 ");
        System.out.println("                  6-Add charge                      ");
        System.out.println("                   0-Sign Out                       ");
        System.out.println("....................................................");
        System.out.print(">>");

    }

//****************************************************************************************signinmenu(all)
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
                        changepassword(Users.simpleUsers[i]);
                        break;
                    }
                    while(command.equals("2"))
                    {
                        showFlightCharts();
                        //to be contined...
                        break;
                    }
                    while(command.equals("3"))
                    {
                        showFlightCharts();
                        System.out.println("....................................................................");
                        System.out.println("                            BOOKING TICKET                          ");
                        System.out.println("....................................................................");
                        for(int j =0;j<Flights.n;j++)
                        {
                            System.out.println("ID :"+Flights.flight[j].getFlightID());
                        }
                        System.out.println("please Enter the ID of flight you want to buy: ");
                        String flightId = input.next();
                        for(int j =0 ; j <= Flights.n -1 ;j++)
                        {
                            if(Flights.flight[j].getFlightID().equals(flightId))
                            {
                                if(Users.simpleUsers[i].getCharge() >= Flights.flight[j].getPrice()&& Flights.flight[j].getSeats()>=1) {
                                    String flightID = Flights.flight[j].getFlightID();
                                    String origin = Flights.flight[j].getOrigin();
                                    String destination = Flights.flight[j].getDestination();
                                    String date = Flights.flight[j].getDate();
                                    String time = Flights.flight[j].getOrigin();
                                    int price = Flights.flight[j].getPrice();
                                    String passangername = Users.simpleUsers[i].getUsername();
                                    String uniqTicketID = uniqStringGenerator(20);
                                    Flights.flight[j].setSeats(Flights.flight[j].getSeats()-1);
                                    Users.simpleUsers[i].setCharge(Users.simpleUsers[i].getCharge()-Flights.flight[j].getPrice());


                                    Ticket ticket = new Ticket(flightID, origin, destination, date, time, price, passangername, uniqTicketID);
                                    Users.simpleUsers[i].setTicket(ticket);
                                    System.out.println("booked seccessfully!");
                                }
                                else if (Users.simpleUsers[i].getCharge()<Flights.flight[j].getPrice()){
                                    System.out.println("Not enough charge!");
                                }
                                else if(Flights.flight[j].getSeats()<1)
                                {
                                    System.out.println("doesn't have any empty seats!");
                                }
                            }
                        }
                        break;


                    }
                    while(command.equals("4"))
                    {
                        System.out.println("                                               .................................................................");
                        System.out.println("                                                                           BOOKED TICKET                        ");
                        System.out.println("                                               .................................................................");
                        System.out.printf("| %-20s | %-20s | %-20s | %-15s | %-20s | %-20s | %-22s |\n","FLiGHT ID","ORIGIN","DESTINATION","DATE","TIME","Price","TicketID");
                        for(int j =0 ; j < Users.simpleUsers[i].k ; j++)
                        {
                            System.out.printf("| %-20s | %-20s | %-20s | %-15s | %-20s | %-20s | %-22s |\n",Users.simpleUsers[i].userTicket[j].getFlightId(),Users.simpleUsers[i].userTicket[j].getOrigin(),Users.simpleUsers[i].userTicket[j].getDestination(),Users.simpleUsers[i].userTicket[j].getDate(),Users.simpleUsers[i].userTicket[j].getTime(),Users.simpleUsers[i].userTicket[j].getPrice(),Users.simpleUsers[i].userTicket[j].getTicketId());

                            /*System.out.println(Users.simpleUsers[i].userTicket[j].getTicketId());
                            System.out.println(Users.simpleUsers[i].userTicket[j].getFlightId());
                            System.out.println(Users.simpleUsers[i].userTicket[j].getPassangerName());*/
                        }
                        break;
                    }

                    while(command.equals("5"))//Ticket cancelation
                    {
                        String flightID = input.next();
                        for(int j =0 ; j < Users.simpleUsers[i].k ; j++)
                        {
                            if(Users.simpleUsers[i].userTicket[j].getFlightId().equals(flightID))
                            {
                                Users.simpleUsers[i].setCharge(Users.simpleUsers[i].getCharge()+Users.simpleUsers[i].userTicket[j].getPrice());
                                for(int h = 0 ; h < Flights.n ; h++)
                                {
                                    if(Flights.flight[h].getFlightID().equals(Users.simpleUsers[i].userTicket[j].getFlightId()))
                                    {
                                        Flights.flight[h].setSeats(Flights.flight[h].getSeats()+1);
                                    }
                                }
                                if(Users.simpleUsers[i].k >1) {
                                    for (int l = j + 1; l < Users.simpleUsers[i].k; l++) {
                                        Users.simpleUsers[i].userTicket[l - 1] = Users.simpleUsers[i].userTicket[l];
                                        Users.simpleUsers[i].k--;
                                    }
                                }
                                else {
                                    Users.simpleUsers[i].k=0;
                                }
                                System.out.println("Ticket canceled successfully!");
                                break;
                            }
                            else {
                                System.out.println(Users.simpleUsers[i].userTicket[j].getTicketId());
                            }
                        }
                        break;
                    }

                    while (command.equals("6"))//add charge menu
                    {
                        ShowFunction.showaddchargemenu(Users.simpleUsers[i]);
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
    public static void showaddchargemenu(SimpleUser user)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(".....................................................");
        System.out.println("                 ADD CHARGE MENU                     ");
        System.out.println(".....................................................");
        System.out.println("your current charge is "+ user.getCharge()+" toman");
        System.out.print("please enter the value you want to charge :");
        user.setCharge((user.getCharge()+input.nextInt()));
        System.out.println("\nyour current charge is "+ user.getCharge()+" toman");
        System.out.println(".....................................................");
    }
//******************************************************************************************
    public static void changepassword(SimpleUser user)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(".........................................................");
        System.out.println("                   CHANGE PASSWORD!                      ");
        System.out.println(".........................................................");
        System.out.println(" Your current password is :" + user.getUserPass());
        System.out.print(" Enter your new password : ");
        user.setUserPass(input.next());
        System.out.println("Your password updated to '"+ user.getUserPass()+"'");

    }
    //*******************************************************************************************
    public static void showAddFlight(){
        Scanner input = new Scanner(System.in);
        System.out.println("............................................................");
        System.out.println("                         ADD FLIGHT                         ");
        System.out.println("............................................................");
        System.out.print("Enter flight ID :");
        String Id = input.next();
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


        Flight ticket = new Flight(Id,origin,destination,date,time,price,seats);
        Flights.setFlight(ticket);
    }


     //**********************************************************************************************


    //*****************************************************************************************
    public static void showFlightCharts(){
        System.out.println("                                              ..........................................................");
        System.out.println("                                                                   FLIGHT SCHEDULE                      ");
        System.out.println("                                              ..........................................................");
        System.out.printf("| %-20s | %-20s | %-20s | %-15s | %-20s | %-20s | %-6s |\n","FLiGHT ID","ORIGIN","DESTINATION","DATE","TIME","price","SEAT");
        System.out.println("...............................................................................................................................................");
        for(int i = 0; i < Flights.n ; i++){
            System.out.printf("| %-20s | %-20s | %-20s | %-15s | %-20s | %-20d | %-6d |\n",Flights.flight[i].getFlightID(),Flights.flight[i].getOrigin(),Flights.flight[i].getDestination(),Flights.flight[i].getDate(),Flights.flight[i].getTime(),Flights.flight[i].getPrice(),Flights.flight[i].getSeats());
            /*System.out.println(Flights.flight[i].getFlightID());
            System.out.println(Flights.flight[i].getOrigin());
            System.out.println(Flights.flight[i].getDestination());
            System.out.println(Flights.flight[i].getDate());
            System.out.println(Flights.flight[i].getTime());
            System.out.println(Flights.flight[i].getPrice());
            System.out.println(Flights.flight[i].getSeats());*/
            System.out.println("...............................................................................................................................................");
        }
    }

    //**************************************************************************************************
    public static void showUpdateMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println(".........................................................");
        System.out.println("                        UPDATE MENU                      ");
        System.out.println(".........................................................");
        for(int i =0;i<Flights.n;i++)
        {
            System.out.println("ID :"+Flights.flight[i].getFlightID());
        }
        System.out.println(".........................................................");
        System.out.print("Enter the Id of flight you want to change:");
        String id = input.next();
        for(int i =0 ; i<Flights.n ; i++)
        {
            while(Flights.flight[i].getFlightID().equals(id))
            {
                System.out.println("wich one you want to update?");
                System.out.println("1-origin");
                System.out.println("2-destination");
                System.out.println("3-date");
                System.out.println("4-time");
                System.out.println("5-price");
                System.out.println("6-seats");
                System.out.println("0-LogOut");
                System.out.print(">>");
                String commandForUpdate = input.next();
                while(commandForUpdate.equals("1"))
                {
                    System.out.print("input the new origin: ");
                    Flights.flight[i].setOrigin(input.next());
                    System.out.println("Updated successfully!");
                    break;
                }
                while(commandForUpdate.equals("2"))
                {
                    System.out.print("input the new destination: ");
                    Flights.flight[i].setDestination(input.next());
                    System.out.println("Updated successfully!");
                    break;
                }
                while(commandForUpdate.equals("3"))
                {
                    System.out.print("input the new date: ");
                    Flights.flight[i].setDate(input.next());
                    System.out.println("Updated successfully!");
                    break;
                }
                while(commandForUpdate.equals("4"))
                {
                    System.out.print("input the new time: ");
                    Flights.flight[i].setTime(input.next());
                    System.out.println("Updated successfully!");
                    break;
                }
                while(commandForUpdate.equals("5"))
                {
                    System.out.print("input the price : ");
                    Flights.flight[i].setPrice(input.nextInt());
                    System.out.println("Updated successfully!");
                    break;
                }
                while(commandForUpdate.equals("6"))
                {
                    System.out.print("input the new seats : ");
                    Flights.flight[i].setSeats(input.nextInt());
                    System.out.println("Updated successfully!");
                    break;
                }
                if(commandForUpdate.equals("0"))
                {
                    break;
                }
            }
        }
        System.out.println("...........................................................");
    }


    //******************************************************************************************

    public static void showRemoveFlight(){
        Scanner input = new Scanner(System.in);
        while(true) {
            ShowFunction.showFlightCharts();
            System.out.println(".....................................................................");
            System.out.println("                             REMOVE FLIGHT                           ");
            System.out.println(".....................................................................");
            System.out.print("Enter the FLight ID you want to remove or 0 to return back: ");
            String removedId = input.next();
            if(removedId.equals("0"))
            {
                break;
            }
            for (int i = 0; i < Flights.n; i++) {
                if (Flights.flight[i].getFlightID().equals(removedId)) {
                    for (int j = i; j < Flights.n - 1; j++) {
                        Flights.flight[j] = Flights.flight[j + 1];
                    }
                    Flights.n = Flights.n - 1;
                    break;
                }
            }
            System.out.println("The flight " + removedId + "has been removed!");
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


}