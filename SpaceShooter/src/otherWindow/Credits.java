package otherWindow;

import javax.swing.*;

public class Credits {

    JFrame frame = new JFrame();
    private CreditsPanel creditsPanel;
    private ImageIcon creditsFrameBackground;
    private JLabel creditsLabel;

    public Credits() {

        creditsFrameBackground = new ImageIcon(this.getClass().getResource("/image/otherbg.png"));
        creditsLabel = new JLabel((creditsFrameBackground));
        creditsLabel.setSize(600, 400);
        frame.add(creditsLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        this.creditsPanel = new CreditsPanel(this);
        frame.setFocusable(false);
    }
}
