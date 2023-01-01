package otherWindow;
import javax.swing.*;

public class Credits extends JFrame{

    JFrame frame = new JFrame();
    private CreditsPanel creditsPanel;
    private ImageIcon creditsFrameBackground;
    private JLabel creditsLabel;

    public Credits() {

        creditsFrameBackground = new ImageIcon(this.getClass().getResource("/image/credits.png"));
        creditsLabel = new JLabel((creditsFrameBackground));
        creditsLabel.setSize(600, 400);
        this.add(creditsLabel);
        this.setTitle("Credits");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Credits");
        this.creditsPanel = new CreditsPanel(this);
        this.setFocusable(false);
        this.getContentPane().add(creditsPanel);
    }
}

