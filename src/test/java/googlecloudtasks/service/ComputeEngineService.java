package googlecloudtasks.service;

import googlecloudtasks.model.ComputeEngine;

public class ComputeEngineService {

    private static final String VM_CLASS =  "test.data.ce.vmclass";
    private static final String INSTANCE_REASON = "test.data.ce.reason";
    private static final String LOCATION = "test.data.ce.location";
    private static final String COMMITTED_USAGE = "test.data.ce.committed_usage";
    private static final String LOCAL_SSD = "test.data.ce.local_ssd";
    private static final String GPU_TYPE = "test.data.ce.gpu_type";
    private static final String INSTANCES = "test.data.ce.instances";
    private static final String OPERATION_SYSTEM = "test.data.ce.operation_system";
    private static final String INSTANCE_TYPE = "test.data.ce.instance_type";
    private static final String GPU_NUMBER = "test.data.ce.gpu_number";

    public ComputeEngine getComputeEngineHardcore() {
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

    public ComputeEngine getComputeEngineHardcoreFromProperty() {
        ComputeEngine computeEngine = new ComputeEngine();
        computeEngine.setNumberOfInstances(TestDataReader.getTestData(INSTANCES));
        computeEngine.setInstancesReason(TestDataReader.getTestData(INSTANCE_REASON));
        computeEngine.setOperationSystemSoftware(TestDataReader.getTestData(OPERATION_SYSTEM));
        computeEngine.setVMClass(TestDataReader.getTestData(VM_CLASS));
        computeEngine.setInstanceType(TestDataReader.getTestData(INSTANCE_TYPE));
        computeEngine.setGPUNumber(TestDataReader.getTestData(GPU_NUMBER));
        computeEngine.setGPUType(TestDataReader.getTestData(GPU_TYPE));
        computeEngine.setLocalSSD(TestDataReader.getTestData(LOCAL_SSD));
        computeEngine.setLocation(TestDataReader.getTestData(LOCATION));
        computeEngine.setCommittedUsage(TestDataReader.getTestData(COMMITTED_USAGE));
        return computeEngine;
    }

}
