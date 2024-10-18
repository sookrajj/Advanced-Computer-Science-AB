package Q1.Pong;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
// find java processing

public class Pong {
    private JLabel playerPadel;
    private JLabel ComputerPadel;
    private JLabel Pong;

    public Pong() {
        playerPadel.setText("Player");
        playerPadel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseMoved(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                playerPadel.move(playerPadel.getX(), playerPadel.getY()+e.getY());
            }
        });


    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("nice");
        frame.setContentPane(new Pong().Pong);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
