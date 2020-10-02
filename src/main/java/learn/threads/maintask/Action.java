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
        System.out.println("Supported actions: [load, unload]");
        System.out.println("Type [SHIP_NAME ACTION CONTAINERS_NUM DOCK_NUM]");
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
                        ship[1],
                        ship[0],
                        harbor.getDockList().get(Integer.parseInt(ship[3])),
                        Integer.parseInt(ship[2]));
            }

        }

    }

    private static void startShipThread(String action, String name, Dock dock, int containers) {
        Ship ship = harbor.getShipByName(name);
        switch (action) {
            case "load":
                new Thread(() -> dock.unloadContainers(harbor, ship, containers)).start();
                break;
            case "unload":
                new Thread(() -> dock.loadContainers(harbor, ship, containers)).start();
                break;
            default:
                System.out.println("Wrong action!");
                break;
        }
    }


}
