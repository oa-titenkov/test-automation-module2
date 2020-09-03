package learn.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Dock {

  ReentrantLock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  private int id;
  private Ship ship;

  public Dock(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Ship getShip() {
    return ship;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
  }

  public void loading(Harbor harbor, Ship ship) {
    lock.lock();
    ship.lock.lock();
      try {
        System.out.println("Dock " + id + " loading containers from Ship #" + ship.name);
        harbor.loadContainers(ship.containers);
        TimeUnit.MILLISECONDS.sleep(ship.containers * 100);
        System.out.println("Dock " + id + " successfully loaded " + ship.containers + " containers from Ship " + ship.name);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (IllegalArgumentException exc) {
        System.out.println("HARBOR CANNOT HANDLE THAT MANY CONTAINERS FROM SHIP: " + ship.name);
      }
    lock.unlock();
    ship.lock.unlock();
  }

  public synchronized void unloading(Harbor harbor, Ship ship) {
    lock.lock();
    ship.lock.lock();
    try {
      System.out.println("Dock " + id + " unloading containers to Ship #" + ship.name);
      harbor.unloadContainers(ship.containers, ship);
      TimeUnit.MILLISECONDS.sleep(ship.containers * 100);
      System.out.println("Dock " + id + " successfully unloaded " + ship.containers + " containers to Ship " + ship.name);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException exc) {
      System.out.println("SHIP CANNOT HANDLE THAT MANY CONTAINERS. SHIP: " + ship.name);
    } catch(IllegalAccessException exc) {
      System.out.println("CAN'T LOAD SHIP TO FULL CAPACITY");
    }
    lock.unlock();
    ship.lock.unlock();
  }
}
