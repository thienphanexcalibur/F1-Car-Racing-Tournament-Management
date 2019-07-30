package model;

public class Supporter {

    private int ID;
    private String name;
    private String dob;
    private String mobile;

    public Supporter(int ID, String name, String dob, String mobile) {
        this.ID = ID;
        this.name = name;
        this.dob = dob;
        this.mobile = mobile;
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

    public String getMobile() {
        return this.mobile;
    }

    /**
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
