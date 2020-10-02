package learn.threads.maintask.entity;

import learn.threads.maintask.exceptions.NegativeContainersException;
import learn.threads.maintask.exceptions.OverloadCapacityException;

import java.util.concurrent.locks.ReentrantLock;

public class Ship {

    public final int SHIP_CAPACITY = 100;

    public String name;
    public int containers = 20;

    protected final ReentrantLock lock = new ReentrantLock(true);

    public Ship(String name) {
        this.name = name;
    }

    public void loadContainers(int containers) {
        if(this.containers + containers > SHIP_CAPACITY) {
            throw new OverloadCapacityException("Overloaded capacity for ship: " + name);
        }
        else {
            this.containers = this.containers + containers;
        }
    }

    public void unloadContainers(int containers) {
        if(this.containers - containers < 0) {
            throw new NegativeContainersException("Negative containers for ship: " + name);
        }
        else {
            this.containers = this.containers - containers;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContainers() {
        return containers;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        if(lock) this.lock.lock();
        else this.lock.unlock();
    }

    @Override
    public String toString() {
        return "Ship{" +
                ", name='" + name + '\'' +
                ", containers=" + containers +
                ", lock=" + lock +
                '}';
    }
}
