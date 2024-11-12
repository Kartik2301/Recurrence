package AdapterDesignPattern.WeightMachine.Client;

import AdapterDesignPattern.WeightMachine.Adaptee.WeightMachine;
import AdapterDesignPattern.WeightMachine.Adaptee.WeightMachineForBabies;
import AdapterDesignPattern.WeightMachine.Adapter.WeightMachineAdapter;
import AdapterDesignPattern.WeightMachine.Adapter.WeightMachineAdapterImpl;

public class Client {
    public static void main(String[] args) {
        WeightMachine weightMachine = new WeightMachineForBabies();
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(weightMachine);
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
