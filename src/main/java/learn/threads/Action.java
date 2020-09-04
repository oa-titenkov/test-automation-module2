package learn.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Action {

  private static Harbor harbor;

  public static void main(String[] args) {

    harbor = new Harbor();
    int harborDocks = 10;
    createDocks(harborDocks);
    System.out.println("Harbor currently has " + harbor.getCurrentContainersCount() + " containers and " + harborDocks + " docks");
    System.out.println("Type [ACTION SHIP_NAME CONTAINERS DOCK_NUMBER]");
    Scanner scanner  =  new Scanner(System.in);
    while (scanner.hasNext()) {
      String[] ship = scanner.nextLine().split(" ");
      if(ship.length != 2 && ship.length != 4 && ship.length != 1) {
        System.out.println("Wrong input!");
      }
      else if(ship[0].equals("status")) System.out.println("Current harbor containers: " + harbor.getCurrentContainersCount());
      else if(ship[1].equals("status")) System.out.println(getShipStatus(ship[0]));
      else {
        System.out.println(Arrays.toString(ship));
        createShipThread(
                ship[0],
                ship[1],
                Integer.parseInt(ship[2]),
                harbor.getDockList().get(Integer.parseInt(ship[3])));
      }
    }

  }

  private static void createShipThread(String action, String name, int containers, Dock dock) {
      for(int i = 0; i < harbor.getShipList().size(); i++) {
        if (harbor.getShipList().get(i).name.equals(name)) {
          switch (action) {
            case "load":
              int finalIL = i;

              new Thread(() -> {
                dock.unloading(harbor, harbor.getShipList().get(finalIL), containers);
                harbor.getShipList().get(finalIL).loadContainers(containers);
              }).start();
              break;
            case "unload":
              int finalIU = i;
              new Thread(() -> {
                dock.loading(harbor, harbor.getShipList().get(finalIU), containers);
                harbor.getShipList().get(finalIU).unloadContainers(containers);
              }).start();
              break;
            default:
              System.out.println("Wrong action!");
              break;
          }
        }
        else {
          Ship ship = new Ship(name, 100, containers);
          harbor.getShipList().add(ship);
          actionWIthANewShip(ship, action, dock, containers);
        }
    }
    if(harbor.getShipList().size() == 0){
        Ship ship = new Ship(name, 100, containers);
        harbor.getShipList().add(ship);
        actionWIthANewShip(ship, action, dock, containers);
    }
  }

  private static void createDocks(int docksCount){
    ArrayList<Dock> dockList = new ArrayList<>();
    for(int i = 0; i < docksCount; i++) {
      dockList.add(new Dock(i));
    }
    harbor.setDockList(dockList);
  }

  private static void actionWIthANewShip(Ship ship, String action, Dock dock, int containers) {
    switch (action) {
      case "load":
        new Thread(() -> dock.unloading(harbor, ship, containers)).start();
        break;
      case "unload":
        new Thread(() -> dock.loading(harbor, ship, containers)).start();
        break;
      default:
        System.out.println("Wrong action!");
        break;
    }
  }

  private static String getShipStatus(String name) {
    for(int i = 0; i < harbor.getShipList().size(); i++) {
      if(harbor.getShipList().get(i).getName().equals(name)){
        return "Ship " + name + " has currently " + harbor.getShipList().get(i).getContainers() + " containers";
      }
    }
    return "No such ship registered!";
  }


}
