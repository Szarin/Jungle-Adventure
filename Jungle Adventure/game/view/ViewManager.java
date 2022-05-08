package game.view;

import javax.swing.JPanel;

import game.controller.ControllerManager;
import game.core.MainGame;
import game.model.ModelManager;
import game.model.Scene;
import graphictools.Render;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Central class for the views organization. This class is needed
 * to communicate with the other members of the centrals classes
 * such as the {@link game.model.ModelManager ModelManager} or the 
 * {@link game.controller.ControllerManager ControllerManager}.
 * <p>
 * To enable {@code ViewManager} to communicate globally, it is needed to set up
 * this classe to a <b>Singleton</b>. This way it is necessary to instantiate
 * by his method {@link game.view.ViewManager#getInstance() getInstance()}.
 * <p>
 * 
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-04-12
 */
public class ViewManager extends JPanel implements ViewListener {

    private static ViewManager instance;
    private List<ViewScene> viewScene;

    private ViewManager() {
        AnimationManager.init();
        ViewWindow.createDisplay();
        viewScene = new ArrayList<ViewScene>();

        ViewScene vscene01 = new ViewScene(ModelManager.getInstance().scene01, ControllerManager.getInstance().keyboardControl);
        vscene01.setActive(true);
        viewScene.add(vscene01);
    }

    public static ViewManager getInstance() {
        if(instance == null) {
            instance = new ViewManager();
        }
        return instance;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    public List<ViewScene> getViewScene() {
        return viewScene;
    }
    
}