import java.sql.SQLOutput;
import java.util.Scanner;
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
        System.out.println("              4-Ticket Cancellation                 ");
        System.out.println("                  5-Add charge                      ");
        System.out.println("                  0-Sign Out                        ");
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


                if (user_pass.equals(Users.simpleUsers[i].getUserPass())) {//simple user log in:
                    ShowFunction.simpleUserSignInMenu();
                    String command = input.next();
                    while(command.equals("1"))//change password
                    {
                        changepassword(Users.simpleUsers[i]);
                        break;
                    }

                    //here will be updated Soon!

                    while (command.equals("5"))//add charge menu
                    {
                        ShowFunction.showaddchargemenu(Users.simpleUsers[i]);
                        break;
                    }
                    break;
                }
            }
            else if(user_name.equals("admin"))
            {


                while(user_pass.equals("admin"))//admin log in
                {
                    ShowFunction.adminMenuShow();
                    String command = input.next();
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
        System.out.println("Enter flight ID :");
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
        System.out.println("..........................................................");
        System.out.println("                     FLIGHT SCHEDULE                      ");
        System.out.println("..........................................................");
        for(int i = 0; i < Flights.n ; i++){
            System.out.println(Flights.flight[i].getFlightID());
            System.out.println(Flights.flight[i].getOrigin());
            System.out.println(Flights.flight[i].getDestination());
            System.out.println(Flights.flight[i].getDate());
            System.out.println(Flights.flight[i].getTime());
            System.out.println(Flights.flight[i].getPrice());
            System.out.println(Flights.flight[i].getSeats());
            System.out.println(".......................................................");
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
            if(Flights.flight[i].getFlightID().equals(id))
            {
                System.out.print("Enter flight origin: ");
                Flights.flight[i].setOrigin(input.next());
                System.out.print("Enter flight destination: ");
                Flights.flight[i].setDestination(input.next());
                System.out.print("Enter flight date: ");
                Flights.flight[i].setDate(input.next());
                System.out.print("Enter flight time: ");
                Flights.flight[i].setTime(input.next());
                System.out.print("Enter flight price: ");
                Flights.flight[i].setPrice(input.nextInt());
                System.out.print("Enter flight seats: ");
                Flights.flight[i].setSeats(input.nextInt());
            }
        }
        System.out.println("...........................................................");
    }


    //******************************************************************************************

    public static void showRemoveFlight(){
        Scanner input = new Scanner(System.in);
        ShowFunction.showFlightCharts();
        System.out.print("Enter the FLight ID you want to remove: ");
        String removedId = input.next();

        for(int i =0 ; i<Flights.n ; i++)
        {
            if(Flights.flight[i].getFlightID().equals(removedId)) {
                for(int j=i ; j < Flights.n - 1 ; j++)
                {
                    Flights.flight[j]=Flights.flight[j+1];
                }
                Flights.n=Flights.n - 1;
                break;
            }
        }


    }



}