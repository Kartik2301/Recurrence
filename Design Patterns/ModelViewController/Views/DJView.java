package ModelViewController.Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ModelViewController.Controllers.ControllerInterface;
import ModelViewController.Models.BeatModelInterface;

public class DJView extends JFrame implements BeatObserver {
    private BeatModelInterface model;
    private ControllerInterface controller;
    private JLabel bpmLabel;
    private JButton increaseBPM;
    private JButton decreaseBPM;
    private JButton setBPM;
    private JButton switchOnBtn;
    private JButton switchOffBtn;
    private JTextField textField;

    public DJView(BeatModelInterface model, ControllerInterface controller) {
        this.model = model;
        this.controller = controller;

        bpmLabel = new JLabel();
        bpmLabel.setText("Player Not Yet Started");
        increaseBPM = new JButton("Increment BPM");
        decreaseBPM = new JButton("Decrement BPM");
        switchOffBtn = new JButton("Turn Off");
        switchOnBtn = new JButton("Turn On");
        textField = new JTextField("Enter Desired BPM");
        setBPM = new JButton("Set BPM");

        increaseBPM.setBounds(0, 0, 250, 100);
        decreaseBPM.setBounds(300, 0, 250, 100);

        switchOnBtn.setBounds(0, 220, 250, 100);
        switchOffBtn.setBounds(300, 220, 250, 100);
        
        textField.setBounds(0, 440, 250, 100);
        setBPM.setBounds(300, 440, 250, 100);

        bpmLabel.setBounds(200, 530, 400, 100);
        
        increaseBPM.addActionListener((e) -> {
            controller.increaseBPM();
        });

        decreaseBPM.addActionListener((e) -> {
            controller.decreaseBPM();
        });

        switchOnBtn.addActionListener((e) -> {
            controller.start();
        });

        switchOffBtn.addActionListener((e) -> {
            controller.stop();
        });

        setBPM.addActionListener((e) -> {
            controller.setBPM(Integer.parseInt(textField.getText().toString()));
        });
        
        resetConfigs();

        model.registerObserver(this);
        
        this.setTitle("DJ Player");
        this.setSize(600, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setLayout(null);
        this.add(increaseBPM);
        this.add(decreaseBPM);
        this.add(setBPM);
        this.add(switchOnBtn);
        this.add(switchOffBtn);
        this.add(bpmLabel);
        this.add(textField);
    }

    public void enableConfigButtons() {
        increaseBPM.setEnabled(true);
        decreaseBPM.setEnabled(true);
        switchOffBtn.setEnabled(true);
        setBPM.setEnabled(true);
    }

    public void disableOnButton() {
        switchOnBtn.setEnabled(false);
    }

    public void resetConfigs() {
        switchOnBtn.setEnabled(true);
        increaseBPM.setEnabled(false);
        decreaseBPM.setEnabled(false);
        switchOffBtn.setEnabled(false);
        setBPM.setEnabled(false);
    }
    
    @Override
    public void update() {
        int bpm = model.getBPM();
        bpmLabel.setText("Current BPM is: " + bpm);
    }
    
}
