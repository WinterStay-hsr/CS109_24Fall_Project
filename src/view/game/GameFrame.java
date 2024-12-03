package view.game;

import javax.swing.*;
import java.awt.*;

import controller.GameController;
import model.MapMatrix;
import view.FrameUtil;

public class GameFrame extends JFrame {

    private GameController controller;
    private JButton restartBtn;
    private JButton loadBtn;

    private JLabel stepLabel;
    private GamePanel gamePanel;

    public GameFrame(int width, int height, MapMatrix mapMatrix) {
        this.setTitle("2024 CS109 Project Demo");
        this.setLayout(null);
        this.setSize(width, height);
        //游戏棋盘布局部分
        gamePanel = new GamePanel(mapMatrix);
        gamePanel.setLocation(30, height / 2 - gamePanel.getHeight() / 2);
        this.add(gamePanel);
        //使用 GamePanel 和 MapMatrix 初始化 GameController
        this.controller = new GameController(gamePanel, mapMatrix);

        //使用 FrameUtil 工具类创建了重新开始和加载游戏的按钮，并配置了动作监听器以处理按钮点击事件
        this.restartBtn = FrameUtil.createButton(this, "Restart", new Point(gamePanel.getWidth() + 80, 120), 80, 50);
        this.loadBtn = FrameUtil.createButton(this, "Load", new Point(gamePanel.getWidth() + 80, 210), 80, 50);

        /*创建了一个 JLabel 来显示游戏的当前步骤或状态。这个标签也相对于 GamePanel 进行定位，并添加到窗口中。
         *GamePanel 被设置为根据需要更新此标签。*/
        this.stepLabel = FrameUtil.createJLabel(this, "Start", new Font("serif", Font.ITALIC, 22), new Point(gamePanel.getWidth() + 80, 70), 180, 50);
        gamePanel.setStepLabel(stepLabel);

        this.restartBtn.addActionListener(e -> {
            controller.restartGame();
            gamePanel.requestFocusInWindow();//enable key listener
        });
        this.loadBtn.addActionListener(e -> {
            String string = JOptionPane.showInputDialog(this, "Input path:");
            System.out.println(string);
            gamePanel.requestFocusInWindow();//enable key listener
        });
        //todo: add other button here such as load, save, back, (up, down, left, right) through mouseclick...
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
