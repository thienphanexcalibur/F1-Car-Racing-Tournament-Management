package model;

import java.util.List;

public class Stage {

    private int ID;
    private int totalLaps;

    public Stage(int ID, int totalLaps) {
        this.ID = ID;
        this.totalLaps = totalLaps;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTotalLaps() {
        return totalLaps;
    }

    public void setTotalLaps(int totalLaps) {
        this.totalLaps = totalLaps;
    }

    @Override
    public String toString() {
        return "Stage " + this.getID();
    }
}
