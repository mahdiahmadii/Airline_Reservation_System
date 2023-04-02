public class Users {
    public static SimpleUser[] simpleUsers = new SimpleUser[20];
    public Admin admin = new Admin();

    //--------------------------------------
    public static int n;
    public static void setSimpleUser(SimpleUser a)
    {
        Users.simpleUsers[Users.n]= a;
        n++;
    }
    //----------------------------------------------------------

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}