package view.level;

import controller.FrameController;
import model.MapMatrix;
import view.FrameUtil;
import view.game.GameFrame;

import javax.swing.*;
import java.awt.*;

////可以参考GameFrame的文件理解本文件的内容
//todo: complex the level frame with more levels(easy but advanced part)
public class LevelFrame extends JFrame {
    private static FrameController frameController = new FrameController();

    public LevelFrame(int width, int height) {
        this.setTitle("Level");
        this.setLayout(null);
        this.setSize(width, height);
        JButton level1Btn = FrameUtil.createButton(this, "Level1", new Point(30, height / 2 - 50), 60, 60);
        JButton level2Btn = FrameUtil.createButton(this, "Level2", new Point(120, height / 2 - 50), 60, 60);

        level1Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {1, 1, 1, 1, 1, 1},
                    {1, 20, 0, 0, 0, 1},
                    {1, 0, 0, 10, 2, 1},
                    {1, 0, 2, 10, 0, 1},
                    {1, 1, 1, 1, 1, 1},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });

        level2Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {1, 1, 1, 1, 1, 0},
                    {1, 20, 0, 0, 1, 1},
                    {1, 0, 0, 2, 0, 1},
                    {1, 0, 10, 10, 2, 1},
                    {1, 1, 0, 1, 1, 1},
                    {0, 1, 1, 1, 0, 0},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });

        //todo: complete all level, including level button and corresponding mapMatrix
        frameController.setLevelFrame(this);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static FrameController getFrameController() {
        return frameController;
    }

}
