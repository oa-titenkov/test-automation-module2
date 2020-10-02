package learn.threads.optionaltask;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;

public class Runway implements ThreadFactory {

    private int id = 1;
    private Plane currentPlane;

    protected final ReentrantLock lock = new ReentrantLock(true);

    public void takePlane(Plane plane) {
        currentPlane = plane;
        System.out.println("Runway #" + id + " took plane #" + plane.getId());
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

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, String.valueOf(id++));
    }
}
