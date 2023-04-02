public class Users {
    /**
     * it contains a list of 20 simple user and an admin
     */
    public static SimpleUser[] simpleUsers = new SimpleUser[20];
    public static int n;//the number of non-empty cells in the list
    public Admin admin = new Admin();

    //--------------------------------------
    /**
     * function to set a simple user s an element of user list
     */

    public static void setSimpleUser(SimpleUser a)
    {
        Users.simpleUsers[Users.n]= a;
        n++;
    }
    //----------------------------------------------------------

    /**
     *Getters & Setters
     */

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}