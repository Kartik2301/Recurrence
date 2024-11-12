package CommandDesignPattern.Commands;

import CommandDesignPattern.Receivers.Microwave;

public class MicrowaveOffCommand implements Command {
    private Microwave microwave;

    public MicrowaveOffCommand(Microwave microwave) {
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        microwave.turnOff();
    }

    @Override
    public void undo() {
        microwave.turnOn();
    }
    
}
