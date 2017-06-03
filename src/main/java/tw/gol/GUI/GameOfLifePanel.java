package tw.gol.GUI;

import tw.gol.GUI.Imp.GOLMatrixImp;

import javax.swing.*;
import java.awt.*;

/**
 * Created by win10 on 2017/6/3.
 */
public class GameOfLifePanel extends JPanel implements Runnable
{
    private final int rows;
    private final int columns;
    private volatile boolean isChanging = false;
    private GOLMatrix golMatrix;

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    private int blockSize = 10;
    private Thread backUpdate;

    public GameOfLifePanel(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        golMatrix = new GOLMatrixImp(rows, columns);
        setSize(columns*blockSize, rows*blockSize);
        //启动后台线程，更新色块
        backUpdate = new Thread(this);

    }

    public void randInitial(){
        golMatrix.randSource(0.3);
    }

    public void startGame(){
        backUpdate.start();
    }

    public void stopGame(){
        backUpdate.stop();
    }

    public void run()
    {
        while(true)
        {
//            synchronized(this) {
                golMatrix.updateLife();
                repaint();
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if(golMatrix.isAlive(i, j))
                {
                    g.fillRect(j * blockSize, i * blockSize, blockSize, blockSize);
                }
                else
                {
                    g.drawRect(j * blockSize, i * blockSize, blockSize, blockSize);
                }
            }
        }
    }

}
