import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        SimpleUser[] simpleUsers = new SimpleUser[10];
        Users users = new Users();
        Admin admin = new Admin();

        //as author of this program I am right to have an account :)))))))))))
        SimpleUser firstUser = new SimpleUser("mahdi","ahmadi","mahdiahmadi");
        Users.setSimpleUser(firstUser);

        //set the admin
        users.setAdmin(admin);


        do {

            //option menu
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