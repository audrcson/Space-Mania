package otherWindow;

import mainWIndow.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditsPanel extends JComponent implements ActionListener {
    private JButton Back;
    private Credits creditsWindow;
    private ImageIcon ButtonBackground;

    public CreditsPanel(Credits otherWindow) {

        ButtonBackground= new ImageIcon(this.getClass().getResource("/image/backbutton.png"));
        Back = new JButton(ButtonBackground);
        Back.setBounds(215, 300, 130, 40);
        Back.addActionListener(this);
        this.add(Back);
        this.setLayout(null);
        this.setFocusable(false);
        this.creditsWindow = otherWindow;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            MainFrame mf = new MainFrame();
            creditsWindow.setVisible(false);
            creditsWindow.dispose();
        }
    }
}
