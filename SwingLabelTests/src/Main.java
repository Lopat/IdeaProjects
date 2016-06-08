import LabelTest1.LabelTest;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LabelTest();
            }
        });

    }
}
