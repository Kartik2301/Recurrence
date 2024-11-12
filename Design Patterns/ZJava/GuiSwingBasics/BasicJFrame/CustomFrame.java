package ZJava.GuiSwingBasics.BasicJFrame;

import java.awt.Color;

import javax.swing.JFrame;

public class CustomFrame extends JFrame {
    public CustomFrame() {
        this.setTitle("JFrame Title Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 450);
        this.setResizable(false);
        this.setVisible(true);

        this.getContentPane().setBackground(new Color(123, 50, 250));
    }
}