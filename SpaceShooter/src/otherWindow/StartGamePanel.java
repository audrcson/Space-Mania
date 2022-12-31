package otherWindow;


import levelWindow.MultiLevel;
import levelWindow.SingleLevel;
import mainWIndow.MainFrame;

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
        this.modeNames = new String[]{"/image/singleplayerbutton.png", "/image/multiplayerbutton.png", "/image/backbutton.png"};
        this.mode = new JButton[3];
        this.setFocusable(false);
        this.startWindow = otherWindow;
        this.configureButton();
    }

    private void configureButton() {
        for (int i = 0; i < mode.length; i++) {
            ImageIcon im = new ImageIcon(this.getClass().getResource(modeNames[i]));
            mode[i] = new JButton(im);
            mode[i].setBounds(225, 112 + i * 55, 130, 40);
            mode[i].addActionListener(this);
            this.add(mode[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mode[0]) {
            SingleLevel sl = new SingleLevel();
            startWindow.setVisible(false);
            startWindow.dispose();
        }

        else if(e.getSource() == mode[1]) {
            MultiLevel ml = new MultiLevel();
            startWindow.setVisible(false);
            startWindow.dispose();
        }
        else {
            MainFrame mf = new MainFrame();
            startWindow.setVisible(false);
            startWindow.dispose();
        }
    }
}