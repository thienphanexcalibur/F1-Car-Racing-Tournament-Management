package model;

public class Manager {

    private int ID;
    private Account account;

    public Manager(int ID, Account account) {
        this.ID = ID;
        this.account = account;
    }

    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
