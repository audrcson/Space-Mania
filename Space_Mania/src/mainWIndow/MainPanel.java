package mainWIndow;

import otherWindow.Credits;
import otherWindow.LeaderBoard;
import otherWindow.StartGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPanel extends JComponent implements ActionListener{
    private final JButton button[];
    private final String buttonNames[];
    private final MainFrame parentWindow;

    public MainPanel(MainFrame mainWindow) {
        this.setLayout(null);
        //  this.buttonNames = new String[]{"/image/startgamebutton.png", "/image/leaderboardbutton.png", "/image/creditsbutton.png", "/image/exitbutton.png"};
        this.buttonNames = new String[]{"Start Game", "Leader Board", "Credits", "Exit"};
        this.button = new JButton[4];
        this.setFocusable(false);
        this.parentWindow = mainWindow;
        this.configureButton();

    }


    private void configureButton() {

        for (int i = 0; i < button.length; i++) {
            // ImageIcon im = new ImageIcon(this.getClass().getResource(buttonNames[i]));
            button[i] = new JButton(buttonNames[i]);
            button[i].setBounds(225, 130 + i * 55, 130, 40);
            button[i].addActionListener(this);
            button[i].setBackground(Color.WHITE);
            this.add(button[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == button[0]) {
            StartGame sg = new StartGame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
        else if(evt.getSource()== button[1]){
            LeaderBoard lb = new LeaderBoard();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
        else if (evt.getSource() == button[2]) {
            Credits cr = new Credits();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
        else {
            parentWindow.dispose();
        }
    }
}
