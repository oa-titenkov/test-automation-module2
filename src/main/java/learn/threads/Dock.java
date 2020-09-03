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
        TimeUnit.MILLISECONDS.sleep(ship.containers * 100);
        harbor.loadContainers(ship.containers);
        System.out.println("Dock " + id + " successfully loaded " + ship.containers + " containers from Ship " + ship.name);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    lock.unlock();
    ship.lock.unlock();
  }

  public synchronized void unloading(int containerCount) {
    for(int i = 0; i < containerCount; i++){
      System.out.println("Ship " + id + " unloaded container #" + i);
    }
  }
}
