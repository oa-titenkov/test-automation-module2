package learn.threads.maintask.entity;

import learn.threads.maintask.exceptions.NegativeContainersException;
import learn.threads.maintask.exceptions.OverloadCapacityException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Dock {

    private ReentrantLock lock = new ReentrantLock(true);

    private int id;
    private Ship ship;

    public Dock(int id) {
        this.id = id;
    }

    public void loadContainers(Harbor harbor, Ship ship, int containers) {
        this.lock.lock();
        ship.lock.lock();
        try {
            System.out.println("Dock " + id + " getting containers from " + ship.name);
            harbor.loadContainers(containers);
            ship.unloadContainers(containers);
            TimeUnit.SECONDS.sleep(containers);
            System.out.println("Dock " + id + " successfully got " + containers + " containers from " + ship.name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (OverloadCapacityException e) {
            System.out.println(e.getMessage());
        } finally {
            this.lock.unlock();
            ship.lock.unlock();
        }

    }

    public void unloadContainers(Harbor harbor, Ship ship, int containers) {
        this.lock.lock();
        ship.lock.lock();
        try {
            System.out.println("Dock " + id + " loading containers to " + ship.name);
            harbor.unloadContainers(containers);
            ship.loadContainers(containers);
            TimeUnit.SECONDS.sleep(containers);
            System.out.println("Dock " + id + " successfully loaded " + containers + " containers to " + ship.name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NegativeContainersException | OverloadCapacityException e) {
            System.out.println(e.getMessage());
        } finally {
            this.lock.unlock();
            ship.lock.unlock();
        }

    }

    public void loadAndUnloadContainers(Harbor harbor, Ship ship, int loadCount, int unloadCount) {
        this.lock.lock();
        ship.lock.lock();
        try {
            System.out.println("Dock " + id + " getting containers from " + ship.name);
            System.out.println("Dock " + id + " loading containers to " + ship.name);
            harbor.unloadContainers(loadCount);
            harbor.loadContainers(unloadCount);
            ship.loadContainers(loadCount);
            ship.unloadContainers(unloadCount);
            TimeUnit.SECONDS.sleep(loadCount + unloadCount);
            System.out.println("Dock " + id + " successfully loaded " + loadCount + " containers to " + ship.name);
            System.out.println("Dock " + id + " successfully got " + unloadCount + " containers from " + ship.name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NegativeContainersException | OverloadCapacityException e) {
            System.out.println(e.getMessage());
        } finally {
            this.lock.unlock();
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
