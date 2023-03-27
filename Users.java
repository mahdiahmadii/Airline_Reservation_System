public class Users {
    public static SimpleUser[] simpleUsers = new SimpleUser[10];
    private Admin admin = new Admin();
    public static int n;
    /*public Users()
    {
        for(int i=0 ;i <2;i++) {
            Users.simpleUsers[i].setUserName(" ");
            Users.simpleUsers[i].setUserPass(" ");
        }
    }*/
    public static void setSimpleUser(SimpleUser a)
    {
        Users.simpleUsers[Users.n]= a;
        n++;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}