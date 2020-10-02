package learn.threads.optionaltask;

public class Plane {

    private int id;

    public Plane(int id) {
        this.id = id;
    }

    public void fly() {
        try {

            System.out.println("Plane #" + id + " getting ready on runway #" + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Plane #" + id + " flew away");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
