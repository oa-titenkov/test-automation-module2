package learn.threads.maintask.entity;

import learn.threads.maintask.exceptions.NegativeContainersException;
import learn.threads.maintask.exceptions.OverloadCapacityException;

import java.util.ArrayList;

public class Harbor {

    public final int HARBOR_DOCK_CAPACITY = 1000;
    private ArrayList<Dock> dockList =  new ArrayList<>();
    private ArrayList<Ship> shipList = new ArrayList<>();
    private int currentContainersCount = 100;

    public Harbor(int docksCount) {
        for(int i = 0; i < docksCount; i++) {
            this.dockList.add(new Dock(i));
        }
    }

    public void loadContainers(int containers) {
        if(this.currentContainersCount + containers > HARBOR_DOCK_CAPACITY){
            throw new OverloadCapacityException("Overload capacity in harbor!");
        }
        else this.currentContainersCount = this.currentContainersCount + containers;

    }

    public void unloadContainers(int containers)  {
        if(this.currentContainersCount - containers < 0) {
            throw new NegativeContainersException("Negative containers at the harbor!");
        }
        else {
            this.currentContainersCount = this.currentContainersCount - containers;
        }

    }

    public String getShipStatus(String name) {
        for(int i = 0; i < getShipList().size(); i++) {
            if(getShipList().get(i).getName().equals(name)){
                return "Ship " + name + " currently has " + getShipList().get(i).getContainers() + " containers";
            }
        }
        return "No such ship registered!";
    }

    public Ship getShipByName(String name) {
        for(int i = 0; i < getShipList().size(); i++) {
            if(getShipList().get(i).getName().equals(name)){
                return getShipList().get(i);
            }
        }
        Ship newShip = new Ship(name);
        getShipList().add(newShip);
        return newShip;
    }

    public ArrayList<Dock> getDockList() {
        return dockList;
    }

    public void setDockList(ArrayList<Dock> dockList) {
        this.dockList = dockList;
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
