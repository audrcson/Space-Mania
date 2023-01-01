package board;

//ini harusnya jadi menu game pas mulai
import mainWIndow.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameBoardFrame extends JFrame {

    public  GameBoardFrame(){
       setVisible(true);
       setTitle("Space Mania");
       setSize(1366, 768);
       setLocationRelativeTo(null);
       setResizable(false);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BorderLayout());
       GameBoardPanel panel = new GameBoardPanel();
       add(panel);
       addWindowListener(new WindowAdapter() {
           @Override
           public void windowOpened(WindowEvent e) {
               panel.start();
           }
       });
    }

}
