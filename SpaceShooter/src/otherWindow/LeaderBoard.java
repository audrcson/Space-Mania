package otherWindow;

import javax.swing.*;

public class LeaderBoard {

    JFrame frame = new JFrame();
    private LeaderBoardPanel leaderBoardPanel;
    private ImageIcon lbFrameBackground;
    private JLabel leaderBoardLabel;

    public LeaderBoard() {

        lbFrameBackground = new ImageIcon(this.getClass().getResource("/image/otherbg.png"));
        leaderBoardLabel = new JLabel((lbFrameBackground));
        leaderBoardLabel.setSize(600, 400);
        frame.add(leaderBoardLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        this.leaderBoardPanel = new LeaderBoardPanel(this);
        frame.setFocusable(false);
    }
}
