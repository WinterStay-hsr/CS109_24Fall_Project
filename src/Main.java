import view.level.LevelFrame;
import view.login.LoginFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame(280,280);
            loginFrame.setVisible(true);
            //need to redesign the width and the height of the level frame
            LevelFrame levelFrame = new LevelFrame(600,450);
            levelFrame.setVisible(false);
            loginFrame.setLevelFrame(levelFrame);
        });
    }
}
