package game.view;

import java.util.Set;

/**
 * {@code SceneManager} is a class to organize all the render scene of
 * the game and differents states of rendering.
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-06-12
 * @see     {@link game.model.Scene Scene}, 
 * {@link game.view.ViewScene ViewScene}
 */
public class SceneManager {

    private static Set<ViewScene> scenes;

    private SceneManager() {}

    public static void addScene(ViewScene scene) {
        scene.add(scene);
    }

    public static void removeScene(ViewScene scene) {
        scenes.remove(scene);
    }

    public static ViewScene getScene(int id) {
        for(ViewScene scene : scenes) {
            if(scene.getId() == id) {
                return scene;
            }
        }
        return null;
    }
    
}
