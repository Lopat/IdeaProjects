package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter implements ActionListener {

    private int crows = 0;
    JLabel label;

    public Counter() {

        JFrame frame = new JFrame("Считай ворон");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        frame.setResizable(false);

        label = new JLabel("Количество ворон = " + crows);
        JButton button1 = new JButton("+");
        JButton button2 = new JButton("-");
        JPanel panel = new JPanel();
        panel.setSize(60, 30);
        panel.add(button1);
        panel.add(button2);

        button1.addActionListener(this);
        button2.addActionListener(this);

        frame.add(panel);
        frame.add(label);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int tmp = getCrows();

        if (e.getActionCommand().equals("+")) {
            tmp += 1;
        } else {
            tmp -= 1;
        }
        label.setText("Количество ворон = " + tmp);
        this.setCrows(tmp);
    }

    public int getCrows() {
        return crows;
    }

    public void setCrows(int crows) {
        this.crows = crows;
    }

}
