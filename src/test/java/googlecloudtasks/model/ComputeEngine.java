package googlecloudtasks.model;

import java.util.Objects;

public class ComputeEngine {

    private String numberOfInstances;
    private String instancesReason;
    private String operationSystemSoftware;
    private String VMClass;
    private String instanceType;
    private String GPUNumber;
    private String GPUType;
    private String LocalSSD;
    private String location;
    private String committedUsage;

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getInstancesReason() {
        return instancesReason;
    }

    public void setInstancesReason(String instancesReason) {
        this.instancesReason = instancesReason;
    }

    public String getOperationSystemSoftware() {
        return operationSystemSoftware;
    }

    public void setOperationSystemSoftware(String operationSystemSoftware) {
        this.operationSystemSoftware = operationSystemSoftware;
    }

    public String getVMClass() {
        return VMClass;
    }

    public void setVMClass(String VMClass) {
        this.VMClass = VMClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getGPUNumber() {
        return GPUNumber;
    }

    public void setGPUNumber(String GPUNumber) {
        this.GPUNumber = GPUNumber;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getLocalSSD() {
        return LocalSSD;
    }

    public void setLocalSSD(String localSSD) {
        LocalSSD = localSSD;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return numberOfInstances == that.numberOfInstances &&
                GPUNumber == that.GPUNumber &&
                Objects.equals(instancesReason, that.instancesReason) &&
                Objects.equals(operationSystemSoftware, that.operationSystemSoftware) &&
                Objects.equals(VMClass, that.VMClass) &&
                Objects.equals(instanceType, that.instanceType) &&
                Objects.equals(GPUType, that.GPUType) &&
                Objects.equals(LocalSSD, that.LocalSSD) &&
                Objects.equals(location, that.location) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, instancesReason, operationSystemSoftware, VMClass, instanceType, GPUNumber,
                            GPUType, LocalSSD, location, committedUsage);
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances=" + numberOfInstances +
                ", instancesReason='" + instancesReason + '\'' +
                ", operationSystemSoftware='" + operationSystemSoftware + '\'' +
                ", VMClass='" + VMClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", GPUNumber=" + GPUNumber +
                ", GPUType='" + GPUType + '\'' +
                ", LocalSSD='" + LocalSSD + '\'' +
                ", location='" + location + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }
}
