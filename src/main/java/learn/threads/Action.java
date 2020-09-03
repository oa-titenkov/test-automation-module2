package learn.threads;

import java.util.Arrays;
import java.util.Scanner;

public class Action {

  private static Harbor harbor = new Harbor();

  public static void main(String[] args) {

    Scanner scanner  =  new Scanner(System.in);
    while (scanner.hasNext()) {
      String[] ship = scanner.nextLine().split(" ");
      System.out.println(Arrays.toString(ship));
      createShipThread(ship[0], Integer.parseInt(ship[1]), Integer.parseInt(ship[2]), createDockThread(Integer.parseInt(ship[3])));
    }
  }

  public static void createShipThread(String name, int capacity, int containers, Dock dock) {
    new Thread(() -> dock.loading(harbor, new Ship(name, capacity, containers))).start();
  }

  public static Dock createDockThread(int id){
    return new Dock(id);
  }

}
