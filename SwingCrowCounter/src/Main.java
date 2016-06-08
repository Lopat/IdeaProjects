import gui.Counter;

import javax.swing.*;

/**
 * Created on 05.02.2016
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Counter();
            }
        });
    }
}
