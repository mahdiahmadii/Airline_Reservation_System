import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        SimpleUser[] simpleUsers = new SimpleUser[10];
        Users users = new Users();
        Admin admin = new Admin();
        SimpleUser firstUser = new SimpleUser("mahdi","ahmadi","mahdiahmadi");
        Users.setSimpleUser(firstUser);
        users.setAdmin(admin);
        do {
            System.out.println("1-signin\n2-signup");
            String command = input.next();
            while (command.equals("2")) {
                System.out.print("input your username:");
                String user_name = input.next();
                System.out.print("\ninput your password:");
                String user_pass = input.next();
                System.out.print("\ninput your name:");
                String name_of_user = input.next();
                SimpleUser simpleUser = new SimpleUser(user_name, user_pass, name_of_user);
                Users.setSimpleUser(simpleUser);
                command="0";
            }
            if(command.equals("0"))
            {
                continue;
            }
            while (command.equals("1"))
            {
                if (command.equals("1")) {
                    System.out.println(users.getAdmin().getPassword());
                    System.out.println(users.getAdmin().getName());
                    System.out.print("usename:");
                    String user_name = input.next();
                    System.out.print("password:");
                    String user_pass = input.next();
                    System.out.println(Users.n);
                    for (int i = 0; i < Users.n ; i++)
                    {
                        int elsee =0;
                        if (user_name.equals(Users.simpleUsers[i].getUserName())) {
                            if (user_pass.equals(Users.simpleUsers[i].getUserPass())) {
                                System.out.println("welcome");
                                break;
                            }
                            /*else {
                                System.out.println("wrong password!");
                            }*/
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