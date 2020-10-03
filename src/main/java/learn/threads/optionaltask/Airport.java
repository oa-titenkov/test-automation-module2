package learn.threads.optionaltask;

import java.util.concurrent.*;

public class Airport {

    public static LinkedBlockingQueue<Runway> runways = new LinkedBlockingQueue<>(5);
    public static LinkedBlockingQueue<Plane> planes = new LinkedBlockingQueue<>(10);


    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++) {
            runways.add(new Runway(i));
        }
        for(int i = 1; i <= 10; i++) {
            planes.add(new Plane(i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i < planes.size(); i++) {
            executorService.submit(() -> {
                try {
                    Runway runway = runways.take();
                    Plane plane = planes.remove();
                    runway.takePlane(plane);
                    runways.put(runway);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();

    }

}
