package levelWindow;

import javax.swing.*;

public class SingleLevel extends JFrame {
    JFrame frame = new JFrame();
    private SingleLevelPanel singlelevelPanel;
    private ImageIcon levelFrameBackground;
    private JLabel levelLabel;

    public SingleLevel() {

        levelFrameBackground = new ImageIcon(this.getClass().getResource("/image/Single Player.png"));
        levelLabel = new JLabel((levelFrameBackground));
        levelLabel.setSize(600, 400);
        this.add(levelLabel);
        this.setTitle("Single Player");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.singlelevelPanel = new SingleLevelPanel(this);
        this.setFocusable(false);
        this.getContentPane().add(singlelevelPanel);
    }
}

