package learn.threads;

import java.util.ArrayList;
import java.util.List;

public class Harbor {

  private final int HARBOR_DOCK_CAPACITY = 300;
  private ArrayList<Dock> dockList;
  private int currentContainersCount;

  public int getHARBOR_DOCK_CAPACITY() {
    return HARBOR_DOCK_CAPACITY;
  }

  public ArrayList<Dock> getDockList() {
    return dockList;
  }

  public void setDockList(ArrayList<Dock> dockList) {
    this.dockList = dockList;
  }

  public void loadContainers(int containers) {
      if(this.currentContainersCount + containers > HARBOR_DOCK_CAPACITY){
        throw new IllegalArgumentException();
      }
      else this.currentContainersCount = this.currentContainersCount + containers;
  }

  public void unloadContainers(int containers, Ship ship) throws IllegalAccessException {
    if(ship.getCapacity() - containers < 0 || ship.getContainers() - containers < 0){
      throw new IllegalArgumentException();
    }
    if(currentContainersCount < ship.getCapacity()) {
      throw new IllegalAccessException();
    }
    else this.currentContainersCount = this.currentContainersCount - containers;
  }


}
