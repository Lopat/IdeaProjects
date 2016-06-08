package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created on 31.01.2016
 */
public class MainFrame extends JFrame{

    public static JButton button;
    public static JButton button2;
    public static JLabel label;



    public static MainFrame getMainFrame()
    {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setName("CrowCounter");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(300, 400);

        button = new JButton("+");
        button2 = new JButton("-");
        label = new JLabel("");
        label.setBorder(new TitledBorder("Crows count"));

        mainFrame.add(button, BorderLayout.NORTH);
        mainFrame.add(button2, BorderLayout.NORTH);
        mainFrame.add(label, BorderLayout.SOUTH);

        return mainFrame;
    }
}
