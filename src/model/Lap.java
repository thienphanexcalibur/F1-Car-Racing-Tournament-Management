package model;

public class Lap {

    private int ID;
    private float totalScore;
    Stage stage;
    private int totalFaults;

    public float getTotalScore() {
        return this.totalScore;
    }

    /**
     *
     * @param totalScore
     */
    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public int getFaults() {
        // TODO - implement Lap.getFaults
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param faults
     */
    public void setFaults(int faults) {
        // TODO - implement Lap.setFaults
        throw new UnsupportedOperationException();
    }

    public Stage getStage() {
        return this.stage;
    }

    /**
     *
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getTotalFaults() {
        return this.totalFaults;
    }

    /**
     *
     * @param totalFaults
     */
    public void setTotalFaults(int totalFaults) {
        this.totalFaults = totalFaults;
    }

    public int getID() {
        // TODO - implement Lap.getID
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        // TODO - implement Lap.setID
        throw new UnsupportedOperationException();
    }
}
