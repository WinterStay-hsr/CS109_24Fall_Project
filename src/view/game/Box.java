package view.game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * 作用：表示游戏中箱子元素
 * 功能：绘制箱子，并提供其值
 */
public class Box extends JComponent {
    private final int value = 10;

    public Box(int width, int height) {
        this.setSize(width, height);
        this.setLocation(5, 5);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, getWidth(), getHeight());
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(border);
    }

    public int getValue() {
        return value;
    }
}
