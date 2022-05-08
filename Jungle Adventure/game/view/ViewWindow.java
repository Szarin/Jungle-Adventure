package game.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.text.View;

import game.controller.ControllerManager;
import game.controller.KeyboardControl;
import game.core.GameLoop;
import game.core.MainGame;
import game.model.ModelManager;

public class ViewWindow extends JFrame {

    public static final int HEIGHT = 1080;
    public static final int WIDTH = 1600;

    public static ViewScene scene;
    
    public static void createDisplay() {
        System.out.println("system class ViewWindow: create Window...");

        JFrame window = new JFrame("Jungle Adventure");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        window.setUndecorated(true);
        scene = new ViewScene(ModelManager.getInstance().scene01, ControllerManager.getInstance().keyboardControl);
        window.setContentPane(scene);
        window.setVisible(true);
    }

}
