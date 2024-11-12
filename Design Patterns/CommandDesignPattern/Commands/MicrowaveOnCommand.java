package CommandDesignPattern.Commands;

import CommandDesignPattern.Receivers.Microwave;

public class MicrowaveOnCommand implements Command {
    private Microwave microwave;

    public MicrowaveOnCommand(Microwave microwave) {
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        microwave.turnOn();
    }

    @Override
    public void undo() {
        microwave.turnOff();
    }
    
}
