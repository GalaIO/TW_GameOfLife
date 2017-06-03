package tw.gol;

import tw.gol.GUI.GameOfLifePanel;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String[] args )
    {
        JFrame frame = new JFrame();
        GameOfLifePanel golPanel = new GameOfLifePanel(3, 3);
        golPanel.randInitial();
        frame.add(golPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(golPanel.getWidth(), golPanel.getHeight());
        frame.setTitle("Game of Life");
        frame.setVisible(true);
        //frame.setResizable(false);
        golPanel.startGame();
    }
}
