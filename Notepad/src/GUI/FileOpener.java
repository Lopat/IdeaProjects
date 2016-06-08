package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created on 11.02.2016
 */
public class FileOpener implements ActionListener {

    JTextField fileNameField;
    JTextField fileTextField;
    JButton open;
    JButton save;

    public FileOpener() {

        JFrame frame = new JFrame("Notepad");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 200);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());


        fileNameField = new JTextField(40);
        open = new JButton("Open file");
        save = new JButton("Save file");
        open.addActionListener(this);
        save.addActionListener(this);
        save.setEnabled(false);

        fileTextField = new JTextField(40);
        fileTextField.setPreferredSize(new Dimension(300, 100));

        frame.add(fileNameField);
        frame.add(open);
        frame.add(save);
        frame.add(fileTextField);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String filename = fileNameField.getText();
        File file = new File(filename);

        if (file.exists()) {

            if (e.getActionCommand().equals("Open file")) {

                try {

                    BufferedReader fr = new BufferedReader(new FileReader(filename));
                    StringBuilder sb = new StringBuilder();

                    while (fr.ready()) {
                        sb.append(fr.readLine());
                    }
                    fr.close();

                    fileTextField.setText(sb.toString());
                    save.setEnabled(true);
                    open.setEnabled(false);
                    fileNameField.setEnabled(false);
                }
                catch (IOException e1) {

                    fileTextField.setText("Error!");
                }
            } else {

                String text = fileTextField.getText();

                try {
                    BufferedWriter fw = new BufferedWriter(new FileWriter(filename));
                    fw.write(text);
                    fw.close();
                    save.setEnabled(false);
                    open.setEnabled(true);
                    fileNameField.setEnabled(true);
                }
                catch (IOException e1) {
                    fileTextField.setText("Error write");
                }
            }
        } else {
            fileTextField.setText("File Not Exists");
        }
    }
}
