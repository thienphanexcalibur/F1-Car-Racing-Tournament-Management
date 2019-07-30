package model;

public class User {

    private int ID;
    Account account;

    public User(int ID, Account account) {
        this.ID = ID;
        this.account = account;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
