public class SimpleUser {
    private String userName;
    private String userPass;
    private int charge;
    private String name;

    //---------------------------------------------
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
