package model;

import java.util.List;

public class Register {

    private int ID;
    List<Racer> racer;
    Team team;

    public Register(int ID, List<Racer> racer, Team team) {
        this.ID = ID;
        this.racer = racer;
        this.team = team;
    }

    public Team getTeam() {
        return this.team;
    }

    /**
     *
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    public int getID() {
        // TODO - implement Register.getID
        return this.ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        // TODO - implement Register.setID
        this.ID = ID;
    }

    public List<Racer> getRacer() {
        return racer;
    }

    public void setRacer(List<Racer> racer) {
        this.racer = racer;
    }

}
