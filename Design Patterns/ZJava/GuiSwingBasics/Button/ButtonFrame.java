package ZJava.GuiSwingBasics.Button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonFrame extends JFrame implements ActionListener {
    private JButton button;
    private JLabel label;

    public ButtonFrame() {
        label = new JLabel();
        label.setText("You babbit, clicked the button");
        label.setBounds(250, 300, 250, 100);
        label.setVisible(false);

        button = new JButton();
        button.setText("Get Started");
        button.setBounds(100, 100, 250, 100);
        button.setFocusable(false);
        button.setForeground(Color.cyan);
        button.setBackground(Color.yellow);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(500, 500);

        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            label.setVisible(true);
        }
    }
}
