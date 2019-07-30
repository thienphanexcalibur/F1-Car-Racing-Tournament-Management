package model;

import java.util.List;

public class Tournament {

    private int ID;
    private String name;
    private String startDate;
    private String endDate;

    public Tournament(int ID, String name, String startDate, String endDate) {
        this.ID = ID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
