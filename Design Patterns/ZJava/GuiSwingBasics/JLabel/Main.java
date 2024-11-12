package ZJava.GuiSwingBasics.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {
        ImageIcon imageIcon = new ImageIcon("ZJava/GuiSwing/JLabel/avatar_1718182446.png");
        Border border = BorderFactory.createLineBorder(Color.green);

        JLabel label = new JLabel();
        label.setText("Kellogs, is cornflakes");
        label.setIcon(imageIcon);
        label.setForeground(Color.green);
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setIconTextGap(10);
        label.setOpaque(true);
        label.setBackground(Color.black);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(border);
        // label.setBounds(100, 100, 250, 250);

        JFrame frame = new JFrame();
        // frame.setSize(450, 450);
        // frame.setLayout(null);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
