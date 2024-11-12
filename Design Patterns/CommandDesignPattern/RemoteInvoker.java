package CommandDesignPattern;

import CommandDesignPattern.Commands.Command;
import CommandDesignPattern.Commands.NoCommand;

public class RemoteInvoker {
    private Command [] commands;
    private int totalSlots;
    private Command lastCommandExecuted;

    public RemoteInvoker(int totalSlots) {
        this.totalSlots = totalSlots;

        commands = new Command[this.totalSlots];

        NoCommand noCommand = new NoCommand();
        for(int i = 0; i < this.totalSlots; i++) {
            commands[i] = noCommand;
        }

        lastCommandExecuted = noCommand;
    }

    public void setCommand(int btnId, Command command) {
        this.commands[btnId] = command;
    }

    public void onButtonPressed(int btnId) {
        commands[btnId].execute();
        lastCommandExecuted = commands[btnId];
    }

    public void onUndoButtonPressed() {
        lastCommandExecuted.undo();
    }
}
