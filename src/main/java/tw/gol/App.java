package tw.gol;

import tw.gol.GUI.GameOfLifePanel;
import tw.gol.GUI.Imp.ControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String[] args )
    {
        JFrame frame = new JFrame();
        final GameOfLifePanel golPanel = new GameOfLifePanel(20, 20);
        golPanel.randInitial();


        frame.add(golPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("width:"+golPanel.getWidth()+"  height:"+golPanel.getHeight());
        frame.setSize(golPanel.getWidth(), golPanel.getHeight()+40);
        frame.setTitle("Game of Life");


        ControlPanel controlPanel = initControlPanel(golPanel);


        frame.add(controlPanel);

        frame.setVisible(true);
//        frame.setSize(500,500);
        //frame.setResizable(false);



//        golPanel.startGame();
    }

    private static ControlPanel initControlPanel(final GameOfLifePanel golPanel) {
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setBackground(new Color(0,0,0));
        controlPanel.setSize(300,300);

        final JButton btStart = new JButton("start");
        final JButton btRandom = new JButton("randInitial");
        final JButton btStop = new JButton("stopGame");

//        controlPanel.setLayout(new BorderLayout());

        //设置初始状态
        btStart.setEnabled(true);
        btStop.setEnabled(false);
        btRandom.setEnabled(true);

        btStart.setSize(20,30);
        controlPanel.add("start",btStart);
//        controlPanel.add(btStart,BorderLayout.EAST);
        controlPanel.setSize(300,300);

        btStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                golPanel.startGame();
                btStart.setEnabled(false);
                btRandom.setEnabled(false);
                btStop.setEnabled(true);
            }
        });


        btRandom.setSize(20,30);
        controlPanel.add("randInitial",btRandom);
        btRandom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                golPanel.randInitial();

            }
        });


        btStop.setSize(20,30);
        controlPanel.add("stopGame",btStop);
        controlPanel.setSize(300,300);

        btStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                golPanel.stopGame();
                btStart.setEnabled(true);
                btStop.setEnabled(false);
                btRandom.setEnabled(true);
            }
        });
        return controlPanel;
    }

    public void initGui(){

    }
}
