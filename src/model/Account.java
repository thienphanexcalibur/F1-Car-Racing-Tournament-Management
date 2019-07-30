package model;

public class Account {

    private int ID;
    private String name;
    private String dob;
    private String username;
    private String password;
    private String address;

    public Account(int ID, String name, String dob, String username, String password, String address) {
        this.ID = ID;
        this.name = name;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public String getUsername() {
        return this.username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return this.address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return this.dob;
    }

    /**
     *
     * @param dob
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }
}
