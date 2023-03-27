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
             * sign up section
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
             * signIn menu
             */
            while (command.equals("1"))
            {
                if (command.equals("1")) {
                    System.out.print("usename:");
                    String user_name = input.next();
                    System.out.print("password:");
                    String user_pass = input.next();
                    for (int i = 0; i < Users.n ; i++)
                    {
                        int elsee =0;
                        if (user_name.equals(Users.simpleUsers[i].getUserName())) {
                            if (user_pass.equals(Users.simpleUsers[i].getUserPass())) {
                                System.out.println("welcome");
                                break;
                            }
                        }
                        else if(user_name.equals(users.getAdmin().getName()))
                        {
                            if(user_pass.equals(users.getAdmin().getPassword()))
                            {
                                System.out.println("welcome admin!");
                            }
                        }


                    }
                }
                command="0";
            }
        }while(true);

    }

}