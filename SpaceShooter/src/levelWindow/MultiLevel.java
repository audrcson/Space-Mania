package levelWindow;

import javax.swing.*;

public class MultiLevel extends JFrame {
    JFrame frame = new JFrame();
    private MultiLevelPanel multilevelPanel;
    private ImageIcon levelFrameBackground;
    private JLabel levelLabel;

    public MultiLevel() {

        levelFrameBackground = new ImageIcon(this.getClass().getResource("/image/Multiplayer.png"));
        levelLabel = new JLabel((levelFrameBackground));
        levelLabel.setSize(600, 400);
        this.add(levelLabel);
        this.setTitle("Multiplayer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.multilevelPanel = new MultiLevelPanel(this);
        this.setFocusable(false);
        this.getContentPane().add(multilevelPanel);
    }
}
