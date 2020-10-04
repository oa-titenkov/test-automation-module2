package learn.threads.maintask;

import learn.threads.maintask.entity.Dock;
import learn.threads.maintask.entity.Harbor;
import learn.threads.maintask.entity.Ship;

import java.util.Arrays;
import java.util.Scanner;

public class Action {

    private static final Harbor harbor = new Harbor(10);

    public static void main(String[] args) {
        System.out.println("Harbor currently has " +
                harbor.getCurrentContainersCount() + " containers and " +
                harbor.getDockList().size() + " docks");
        System.out.println("Type [SHIP_NAME CONTAINERS_LOAD CONTAINERS_UNLOAD DOCK_NUM]");
        Scanner scanner  =  new Scanner(System.in);

        while (scanner.hasNext()) {
            String[] ship = scanner.nextLine().split(" ");
            if(ship.length != 2 && ship.length != 4 && ship.length != 1) {
                System.out.println("Wrong input!");
            }
            else if(ship[0].equals("status")) {
                System.out.println("Current harbor containers: " + harbor.getCurrentContainersCount());
            }
            else if(ship[1].equals("status")) {
                System.out.println(harbor.getShipStatus(ship[0]));
            }
            else if(ship.length == 4) {
                System.out.println(Arrays.toString(ship));
                startShipThread(
                        ship[0],
                        Integer.parseInt(ship[1]),
                        Integer.parseInt(ship[2]),
                        harbor.getDockList().get(Integer.parseInt(ship[3])));
            }

        }

    }

    private static void startShipThread(String name, int loadCount, int unloadCount, Dock dock) {
        Ship ship = harbor.getShipByName(name);

        if(loadCount != 0 && unloadCount != 0) {
            new Thread(() -> dock.loadAndUnloadContainers(harbor, ship, loadCount, unloadCount)).start();
        }
        else if(loadCount != 0) {
            new Thread(() -> dock.loadContainers(harbor, ship, loadCount)).start();
        }
        else {
            new Thread(() -> dock.unloadContainers(harbor, ship, unloadCount)).start();
        }

    }


}
