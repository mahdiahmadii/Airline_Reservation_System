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
        System.out.println("                    0-logOut                    ");
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

//****************************************************************************************
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


                if(user_pass.equals("admin"))
                {
                    ShowFunction.adminMenuShow();
                    break;
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
}