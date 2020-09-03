package learn.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Action {

  private static Harbor harbor;

  public static void main(String[] args) {

    harbor = new Harbor();
    createDocks(10);

    Scanner scanner  =  new Scanner(System.in);
    while (scanner.hasNext()) {
      String[] ship = scanner.nextLine().split(" ");
      System.out.println(Arrays.toString(ship));
      createShipThread(
              ship[0],
              ship[1],
              Integer.parseInt(ship[2]),
              Integer.parseInt(ship[2]),
              harbor.getDockList().get(Integer.parseInt(ship[3])));
    }
  }

  public static void createShipThread(String action, String name, int capacity, int containers, Dock dock) {
    if(action.equals("load")) {
      new Thread(() -> dock.unloading(harbor, new Ship(name, capacity, containers))).start();
    }
    else if(action.equals("unload")) {
      new Thread(() -> dock.loading(harbor, new Ship(name, capacity, containers))).start();
    }
    else System.out.println("Wrong action!");
  }

  public static void createDocks(int docksCount){
    ArrayList<Dock> dockList = new ArrayList<>();
    for(int i = 0; i < docksCount; i++) {
      dockList.add(new Dock(i));
    }
    harbor.setDockList(dockList);
  }

}
