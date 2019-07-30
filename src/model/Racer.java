package model;

public class Racer {

    private int ID;
    Team team;
    private String name;
    private String dob;
    private int experience;

    public Racer(int ID, Team team, String name, String dob, int experience) {
        this.ID = ID;
        this.team = team;
        this.name = name;
        this.dob = dob;
        this.experience = experience;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
