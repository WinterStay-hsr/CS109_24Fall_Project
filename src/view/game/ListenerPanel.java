package view.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * This class is only to enable key events.
 */
public abstract class ListenerPanel extends JPanel {
    public ListenerPanel() {
        enableEvents(AWTEvent.KEY_EVENT_MASK);
        this.setFocusable(true);
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        super.processKeyEvent(e);
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> doMoveRight();
                case KeyEvent.VK_LEFT, KeyEvent.VK_A -> doMoveLeft();
                case KeyEvent.VK_UP, KeyEvent.VK_W -> doMoveUp();
                case KeyEvent.VK_DOWN, KeyEvent.VK_S -> doMoveDown();
            }
        }
    }


    public abstract void doMoveRight();
    public abstract void doMoveLeft();
    public abstract void doMoveUp();
    public abstract void doMoveDown();

}
