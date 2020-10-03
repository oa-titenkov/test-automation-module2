package learn.threads.optionaltask;

public class Plane {

    private int id;

    public Plane(int id) {
        this.id = id;
    }

    public void fly(Runway runway) {
        try {
            System.out.println("Plane #" + id + " getting ready on runway #" + runway.getId());
            Thread.sleep(2000);
            System.out.println("Plane #" + id + " flew away");
            Thread.sleep(500);
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
