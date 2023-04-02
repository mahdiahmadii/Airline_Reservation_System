import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Users users = new Users();
        Admin admin = new Admin();

        //as author of this program I am right to have an account :)))))))))))
        SimpleUser firstUser = new SimpleUser("mahdi","ahmadi","mahdiahmadi");
        Users.setSimpleUser(firstUser);
        //warning: if you remove my personal account you'll get some unexpected exception and program won't work any more! :))))))))))))))))

        //I add two flight information as sample to my flights chart
        Flight sample1 = new Flight("wx-12","Yazd","Tehran","1402/12/10","22:20",700000,51);
        Flights.setFlight(sample1);
        Flight sample2 = new Flight("wx-13","Yazd","Isfahan","1402/12/09","21:30",600000,55);
        Flights.setFlight(sample2);

        //set the admin
        users.setAdmin(admin);



        do {
            /**
             * option menu
             */
            ShowFunction.optionMenu();
            String command = input.next();


            /**
             * signUp section
             */
            //----------------------------------------------
            while (command.equals("2")) {
                ShowFunction.signUpSection();
                command="0";
            }
            if(command.equals("0"))
            {
                continue;
            }
            //----------------------------------------------


            /**
             * signIn section
             */
            //-----------------------------------------------
            while (command.equals("1"))
            {
                if (command.equals("1")) {
                    ShowFunction.signInMenu();

                }
                command="0";
            }
            //-------------------------------------------------




        }while(true);

    }

}