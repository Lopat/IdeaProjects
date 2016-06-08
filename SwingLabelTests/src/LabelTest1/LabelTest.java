package LabelTest1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelTest implements ActionListener {
    JLabel label1;
    JLabel label2;
    JButton button;

    public LabelTest() {

        JFrame frame = new JFrame("Labels Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(480, 480);
        frame.setLayout(new GridLayout(2, 2, 1, 1));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("files/w.png");
        ImageIcon icon2 = new ImageIcon("files/w6.png");


        label1 = new JLabel("First", icon, SwingConstants.CENTER);
        label1.setVerticalTextPosition(SwingConstants.TOP);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);

        label2 = new JLabel("Second", icon2, SwingConstants.CENTER);
        label2.setVerticalTextPosition(SwingConstants.TOP);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);

        frame.add(label1);
        frame.add(label2);

        button = new JButton("Off");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(20, 20));
        frame.add(button);

        JLabel label3 = new JLabel("<html><a href = \"vk.com\">Ссылка</a><br><br>Текст");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setVerticalAlignment(SwingConstants.CENTER);
        frame.add(label3);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Off")) {
            label1.setEnabled(true);
            label2.setEnabled(false);
            button.setText("On");
        } else {
            label1.setEnabled(false);
            label2.setEnabled(true);
            button.setText("Off");
        }
    }
}
