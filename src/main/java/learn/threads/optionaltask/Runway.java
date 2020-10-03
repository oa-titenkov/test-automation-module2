package learn.threads.optionaltask;

public class Runway {

    private int id;
    private Plane currentPlane;

    public Runway(int id) {
        this.id = id;
    }

    public void takePlane(Plane plane) {
        currentPlane = plane;
        System.out.println("Runway #" + id + " took plane #" + plane.getId());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        plane.fly();
        currentPlane = null;
        System.out.println("Runway #" + id + " is free");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Plane getCurrentPlane() {
        return currentPlane;
    }

    public void setCurrentPlane(Plane currentPlane) {
        this.currentPlane = currentPlane;
    }

}
