package AdapterDesignPattern.WeightMachine.Adapter;

import AdapterDesignPattern.WeightMachine.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
    private WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        return 0.453592 * weightMachine.getWeightInPounds();
    }
    
}
