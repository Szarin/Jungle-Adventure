package game.controller;

/**
 * Central class for the controllers organization. This class is needed
 * to communicate with the other members of the centrals classes
 * such as the {@link game.model.ModelManager ModelManager} or the 
 * {@link game.controller.ViewManager ViewManager}.
 * <p>
 * To enable {@code ControllerManager} to communicate globally, it is needed to set up
 * this classe to a <b>Singleton</b>. This way it is necessary to instantiate
 * by his method {@link game.view.ControllerManager#getInstance() getInstance()}.
 * <p>
 * 
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-04-12
 */
public class ControllerManager {

    private static ControllerManager instance;
    public KeyboardControl keyboardControl;

    private ControllerManager() {
        keyboardControl = new KeyboardControl();
    }

    public static ControllerManager getInstance() {
        if(instance == null) {
            instance = new ControllerManager();
        }
        return instance;
    }
    
}
