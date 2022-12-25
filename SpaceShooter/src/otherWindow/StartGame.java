package otherWindow;

import javax.swing.*;
import java.awt.*;

public class StartGame {
    JFrame frame = new JFrame();
    private StartGamePanel startGamePanel;
    private ImageIcon modeFrameBackground;
    private JLabel startGameLabel;

    public StartGame() {

        modeFrameBackground = new ImageIcon(this.getClass().getResource("/image/otherbg.png"));
        startGameLabel = new JLabel((modeFrameBackground));
        startGameLabel.setSize(600, 400);
        frame.add(startGameLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        this.startGamePanel = new StartGamePanel(this);
        frame.setFocusable(false);
    }
}
