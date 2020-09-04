package learn.threads;

import learn.threads.exceptions.NegativeContainersException;
import learn.threads.exceptions.OverloadCapacityException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Dock {

  private ReentrantLock lock = new ReentrantLock(true);
  private Condition condition = lock.newCondition();

  private int id;
  private Ship ship;

   Dock(int id) {
    this.id = id;
  }

  public void loading(Harbor harbor, Ship ship, int containers) {
     lock.lock();
     ship.lock.lock();
     try {
        harbor.loadContainers(containers);
        System.out.println("Dock " + id + " loading containers from " + ship.name);
        TimeUnit.MILLISECONDS.sleep(containers * 1000);
        System.out.println("Dock " + id + " successfully loaded " + ship.containers + " containers from " + ship.name);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (OverloadCapacityException e) {
        System.out.println(e.getMessage());
      } finally {
       lock.unlock();
       ship.lock.unlock();
     }

  }

  public synchronized void unloading(Harbor harbor, Ship ship, int conttainers) {
    lock.lock();
    ship.lock.lock();
    try {
      harbor.unloadContainers(conttainers, ship);
      System.out.println("Dock " + id + " unloading containers to " + ship.name);
      TimeUnit.MILLISECONDS.sleep(conttainers * 1000);
      System.out.println("Dock " + id + " successfully unloaded " + ship.containers + " containers to " + ship.name);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (NegativeContainersException | OverloadCapacityException e) {
      System.out.println(e.getMessage());
    } finally {
      lock.unlock();
      ship.lock.unlock();
    }

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

  public ReentrantLock getLock() {
    return lock;
  }

  public void setLock(ReentrantLock lock) {
    this.lock = lock;
  }
}
