package learn.threads;

import java.util.concurrent.locks.ReentrantLock;

public class Ship {

  private final int capacity;
  public String name;
  public int containers;
  ReentrantLock lock = new ReentrantLock(true);

  Ship(String name, int capacity,  int containers) {
    this.capacity = capacity;
    this.name = name;
    this.containers = containers;
  }

  public int getCapacity() {
    return capacity;
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

  public void loadContainers(int containers) {
    this.containers = this.containers + containers;
  }

  public void unloadContainers(int containers) {
    this.containers = this.containers - containers;
  }

  public ReentrantLock getLock() {
    return lock;
  }

  public void setLock(Boolean lock) {
    if(lock)  this.lock.lock();
    else this.lock.unlock();

  }

  @Override
  public String toString() {
    return "Ship{" +
            "capacity=" + capacity +
            ", name='" + name + '\'' +
            ", containers=" + containers +
            ", lock=" + lock +
            '}';
  }
}
