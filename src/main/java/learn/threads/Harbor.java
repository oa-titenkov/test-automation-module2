package learn.threads;

import learn.threads.exceptions.NegativeContainersException;
import learn.threads.exceptions.OverloadCapacityException;

import java.util.ArrayList;
import java.util.List;

public class Harbor {

  private final int HARBOR_DOCK_CAPACITY = 1000;
  private ArrayList<Dock> dockList;
  private ArrayList<Ship> shipList = new ArrayList<>();
  private int currentContainersCount = 200;

  public int getHARBOR_DOCK_CAPACITY() {
    return HARBOR_DOCK_CAPACITY;
  }

  public ArrayList<Dock> getDockList() {
    return dockList;
  }

  public void setDockList(ArrayList<Dock> dockList) {
    this.dockList = dockList;
  }

  public void loadContainers(int containers) throws OverloadCapacityException {
      if(this.currentContainersCount + containers > HARBOR_DOCK_CAPACITY){
        throw new OverloadCapacityException("Overload capacity in harbor!");
      }
      else this.currentContainersCount = this.currentContainersCount + containers;
  }

  public void unloadContainers(int containers, Ship ship) throws OverloadCapacityException, NegativeContainersException {
    if(this.currentContainersCount - containers < 0) {
      throw new NegativeContainersException("Negative containers at the harbor!");
    }
    if(ship.getCapacity() - containers < 0){
      throw new OverloadCapacityException("Too many containers for this ship!");
    }
    if(currentContainersCount < ship.getCapacity()) {
      throw new OverloadCapacityException("Overload capacity on the ship!");
    }
    else this.currentContainersCount = this.currentContainersCount - containers;
  }

  public int getCurrentContainersCount() {
    return currentContainersCount;
  }

  public void setCurrentContainersCount(int currentContainersCount) {
    this.currentContainersCount = currentContainersCount;
  }

  public ArrayList<Ship> getShipList() {
    return shipList;
  }

  public void setShipList(ArrayList<Ship> shipList) {
    this.shipList = shipList;
  }
}
