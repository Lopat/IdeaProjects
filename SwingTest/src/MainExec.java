import GUI.MainFrame;
import VALS.CrowCounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created on 31.01.2016
 */
public class MainExec
{
    public static void main(String[] args) {

        CrowCounter counter = CrowCounter.getInstance();
        MainFrame frame = MainFrame.getMainFrame();
        MainFrame.label.setText(String.valueOf(counter.getCrows()));

        MainFrame.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter.setCrows();
            }
        });




        frame.setVisible(true);

    }

}
