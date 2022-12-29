package mainWindow;

import javax.swing.*;

public class MainFrame extends JFrame {
    private MainPanel mainPanel;
    private ImageIcon mainFrameBackground;
    private JLabel mainLabel;


    public MainFrame()
    {

        mainFrameBackground = new ImageIcon(this.getClass().getResource("/image/bgpict.png"));
        mainLabel = new JLabel(mainFrameBackground);
        mainLabel.setSize(600,400);
        this.add(mainLabel);
        this.setTitle("Space Mania");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.mainPanel = new MainPanel(this);
        this.getContentPane().add(mainPanel);
    }
}
