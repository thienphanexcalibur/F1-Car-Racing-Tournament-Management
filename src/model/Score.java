package model;

public class Score {

    private int ID;
    Lap lap;
    private float point;

    public Score(int ID, Lap lap, float point) {
        this.ID = ID;
        this.lap = lap;
        this.point = point;
    }

    public float getPoint() {
        return this.point;
    }

    /**
     *
     * @param point
     */
    public void setPoint(float point) {
        this.point = point;
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
        // TODO - implement Score.getID
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        // TODO - implement Score.setID
        throw new UnsupportedOperationException();
    }
}
