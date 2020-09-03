package learn.threads;

import java.util.List;

public class Harbor {

  private final int HARBOR_DOCK_CAPACITY = 300;
  private List<Dock> dockList;
  private int currentContainersCount;

  public int getHARBOR_DOCK_CAPACITY() {
    return HARBOR_DOCK_CAPACITY;
  }

  public List<Dock> getDockList() {
    return dockList;
  }

  public void setDockList(List<Dock> dockList) {
    this.dockList = dockList;
  }

  public void loadContainers(int containers) {
    if(this.currentContainersCount + containers > HARBOR_DOCK_CAPACITY){
      throw new IllegalArgumentException();
    }
    else this.currentContainersCount = this.currentContainersCount + containers;
  }

  public void unloadContainers(int containers) {
    this.currentContainersCount =  this.currentContainersCount - containers;
  }

}
