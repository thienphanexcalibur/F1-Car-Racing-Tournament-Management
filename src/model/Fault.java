package model;

public class Fault {

    private int ID;
    Lap lap;
    private String description;

    public Fault(int ID, Lap lap, String description) {
        this.ID = ID;
        this.lap = lap;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Fault() {
        // TODO - implement Fault.Fault
        throw new UnsupportedOperationException();
    }

    public Lap getLap() {
        return this.lap;
    }

    /**
     *
     * @param lap
     */
    public void setLap(Lap lap) {
        this.lap = lap;
    }

    public int getID() {
        // TODO - implement Fault.getID
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        // TODO - implement Fault.setID
        throw new UnsupportedOperationException();
    }

}
