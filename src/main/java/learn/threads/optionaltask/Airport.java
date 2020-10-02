package learn.threads.optionaltask;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Airport {

    private static final ArrayList<Runway> runways = new ArrayList<>();
    private static final ArrayList<Plane> planes = new ArrayList<>();


    public Airport() {

    }

    public static void main(String[] args) {

        for(int i = 1; i <= 5; i++) {
            runways.add(new Runway());
        }
        for(int i = 1; i <= 10; i++) {
            planes.add(new Plane(i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5, new Runway());
        executorService.submit(() -> planes.get(0).fly());
        executorService.submit(() -> planes.get(1).fly());
        executorService.submit(() -> planes.get(2).fly());
        executorService.submit(() -> planes.get(3).fly());
        executorService.submit(() -> planes.get(4).fly());
        executorService.submit(() -> planes.get(5).fly());
        executorService.submit(() -> planes.get(6).fly());
        executorService.submit(() -> planes.get(7).fly());
        executorService.submit(() -> planes.get(8).fly());
        executorService.submit(() -> planes.get(9).fly());
        executorService.shutdown();

    }


}
