package otherWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditsPanel extends JComponent implements ActionListener {
    private Credits creditsWindow;

    public CreditsPanel(Credits otherWindow) {
        this.setLayout(null);
        this.setFocusable(false);
        this.creditsWindow = otherWindow;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
