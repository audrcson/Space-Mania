package otherWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGamePanel extends JComponent implements ActionListener {
    private JButton mode[];
    private String modeNames[];
    private StartGame startWindow;

    public StartGamePanel(StartGame otherWindow) {
        this.setLayout(null);
        this.modeNames = new String[]{"Single Player", "Multi Player"};
        this.mode = new JButton[2];
        this.setFocusable(false);
        this.startWindow = otherWindow;
        this.configureButton();
    }

    private void configureButton() {
        for (int i = 0; i < mode.length; i++) {
            mode[i] = new JButton(modeNames[i]);
            mode[i].setBounds(225, 130 + i * 55, 130, 40);
            mode[i].addActionListener(this);
            mode[i].setBackground(Color.white);
            this.add(mode[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}