package googlecloudtasks.service;

import googlecloudtasks.model.ComputeEngine;

public class ComputeEngineService {

    private static final String VM_CLASS =  "testdata.ce.vmclass";
    private static final String INSTANCE_REASON = "testdata.ce.reason";

    public ComputeEngine hardcoreTaskFormFill() {
        ComputeEngine computeEngine = new ComputeEngine();
        computeEngine.setNumberOfInstances("4");
        computeEngine.setInstancesReason("");
        computeEngine.setOperationSystemSoftware("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");
        computeEngine.setVMClass("Regular");
        computeEngine.setInstanceType("n1-standard-8 (vCPUs: 8, RAM: 30GB)");
        computeEngine.setGPUNumber("1");
        computeEngine.setGPUType("NVIDIA Tesla V100");
        computeEngine.setLocalSSD("2x375 GB");
        computeEngine.setLocation("Frankfurt (europe-west3)");
        computeEngine.setCommittedUsage("1 Year");
        return computeEngine;
    }

    public ComputeEngine hardcoreTaskFillFromProperty() {
        ComputeEngine computeEngine = new ComputeEngine();
        computeEngine.setNumberOfInstances("4");
        computeEngine.setInstancesReason(TestDataReader.getTestData(INSTANCE_REASON));
        computeEngine.setOperationSystemSoftware("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");
        computeEngine.setVMClass(TestDataReader.getTestData(VM_CLASS));
        computeEngine.setInstanceType("n1-standard-8 (vCPUs: 8, RAM: 30GB)");
        computeEngine.setGPUNumber("1");
        computeEngine.setGPUType("NVIDIA Tesla V100");
        computeEngine.setLocalSSD("2x375 GB");
        computeEngine.setLocation("Frankfurt (europe-west3)");
        computeEngine.setCommittedUsage("1 Year");
        return computeEngine;
    }

}
