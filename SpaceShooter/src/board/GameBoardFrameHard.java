package board;

//ini harusnya jadi menu game pas mulai

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameBoardFrameHard extends JFrame {

    public  GameBoardFrameHard(){
        setVisible(true);
        setTitle("Space Mania");
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        GameBoardPanelHard panel = new GameBoardPanelHard();
        add(panel);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                panel.start();
            }
        });
    }

}
