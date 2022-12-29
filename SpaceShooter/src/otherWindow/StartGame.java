package otherWindow;

import javax.swing.*;
import java.awt.*;

public class StartGame extends JFrame{
    JFrame frame = new JFrame();
    private StartGamePanel startGamePanel;
    private ImageIcon modeFrameBackground;
    private JLabel startGameLabel;

    public StartGame() {

        modeFrameBackground = new ImageIcon(this.getClass().getResource("/image/Game Mode.png"));
        startGameLabel = new JLabel((modeFrameBackground));
        startGameLabel.setSize(600, 400);
        this.add(startGameLabel);
        this.setTitle("Game Mode");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.startGamePanel = new StartGamePanel(this);
        this.setFocusable(false);
        this.getContentPane().add(startGamePanel);
    }
}
