package CommandDesignPattern;

import CommandDesignPattern.Commands.FanOffCommand;
import CommandDesignPattern.Commands.FanOnCommand;
import CommandDesignPattern.Commands.LightOffCommand;
import CommandDesignPattern.Commands.LightOnCommand;
import CommandDesignPattern.Commands.MicrowaveOffCommand;
import CommandDesignPattern.Commands.MicrowaveOnCommand;
import CommandDesignPattern.Receivers.Fan;
import CommandDesignPattern.Receivers.Light;
import CommandDesignPattern.Receivers.Microwave;

public class RemoteClient {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Light livingRoomLight = new Light();
        Light drawingRoomLight = new Light();
        Microwave microwave = new Microwave();

        FanOnCommand fanOnCommand = new FanOnCommand(fan);
        FanOffCommand fanOffCommand = new FanOffCommand(fan);

        LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        LightOnCommand drawingRoomLightOnCommand = new LightOnCommand(drawingRoomLight);
        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
        LightOffCommand drawingRoomLightOffCommand = new LightOffCommand(drawingRoomLight);

        MicrowaveOnCommand microwaveOnCommand = new MicrowaveOnCommand(microwave);
        MicrowaveOffCommand microwaveOffCommand = new MicrowaveOffCommand(microwave);

        RemoteInvoker remoteInvoker = new RemoteInvoker(10);
        remoteInvoker.setCommand(0, fanOnCommand);
        remoteInvoker.setCommand(1, fanOffCommand);
        remoteInvoker.setCommand(2, livingRoomLightOnCommand);
        remoteInvoker.setCommand(3, drawingRoomLightOnCommand);
        remoteInvoker.setCommand(4, livingRoomLightOffCommand);
        remoteInvoker.setCommand(5, drawingRoomLightOffCommand);
        remoteInvoker.setCommand(6, microwaveOnCommand);
        remoteInvoker.setCommand(7, microwaveOffCommand);

        remoteInvoker.onButtonPressed(0);
        remoteInvoker.onButtonPressed(1);
        remoteInvoker.onButtonPressed(2);
        remoteInvoker.onUndoButtonPressed();
        remoteInvoker.onButtonPressed(6);
        remoteInvoker.onButtonPressed(7);
        remoteInvoker.onUndoButtonPressed();
        remoteInvoker.onButtonPressed(8);
    }
}
