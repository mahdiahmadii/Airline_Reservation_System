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
    public static void signInMenu()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("usename:");
        String user_name = input.next();
        System.out.print("password:");
        String user_pass = input.next();
    }


}