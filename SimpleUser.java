public class SimpleUser {
    /**
     * features
     */
    private String userName;
    private String userPass;
    private int charge;
    private String name;
    public Ticket[] userTicket = new Ticket[30];
    public int k;//number of elements in the userTicket list

    //__________________________________________________________

    /**
     * function to add new Ticket to list
     * @param ticket
     */
    public void setTicket(Ticket ticket)
    {
        this.userTicket[k] = ticket;
        k++;
    }
    //---------------------------------------------

    /**
     * constructors to make a simple user by its information
     */
    public SimpleUser()
    {
        this.name = " ";
        this.userName = " ";
        this.userPass = " ";
    }
    public SimpleUser(String username,String userpass,String name)
    {
        this.name = name;
        this.userName = username;
        this.userPass = userpass;
        this.charge = 0;
    }


    //--------------------------------------------

    /**
     * Setters & Getters
     */
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
