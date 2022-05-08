package game.core;
import utils.Time;

import javax.swing.text.View;
import game.model.ModelManager;
import game.view.ViewWindow;

/**
 * {@code GameLoop} is the implementation of the inner loop of this software.
 * As this class is an implementation of {@link java.lang.Runnable Runnable}
 * interface, this class act as this type. And in fact run on its own.
 * This class does not need to be somewhere else.
 * <p>
 * Inheritance of {@link utils.Time Time} class is needed to calculate
 * the delta time and the fps of the loop. 
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-04-12
 */
public class GameLoop implements Runnable{

    private final int MAX_FPS = 60;
    // Max fps limit of the loop

    private final int MAX_DELTATIME = 1000 / MAX_FPS;
    // Deltatime calculated from MAX_FPS limit

    private final int MAX_FRAMESKIP = 10;
    // no. of frames that can be skipped in any one animation loop
    // i.e the games state is updated but not rendered

    private static boolean isRunning = true;
    private static double deltaTime;
    private int ticks = 0;

    @Override
    public void run() {

        double nextFrameTime = System.currentTimeMillis();
        int countFrameskip;

        long time0 = System.nanoTime();
        double time = 0;
        double lastTime = 0;
        deltaTime = 0;

        render();

        while (isRunning) {
            time = (System.nanoTime() - time0)/1E9;  // time in seconds from the beginning
            //Time.updateStartTime();


            /* If frame animation is taking too long, update the game state
            without rendering it, to get the updates/sec nearer to
            the required FPS. */
            countFrameskip = 0;
            while(System.currentTimeMillis() > nextFrameTime && countFrameskip < MAX_FRAMESKIP) {
                update();

                nextFrameTime += MAX_DELTATIME;
                countFrameskip++;
            }

            render();

            deltaTime = time - lastTime;  //time of last loop
            lastTime = time;

            //Time.updateLastTime();

            // Time.updateDeltaTime();
            // Time.updateFps();


            // if(ticks % 10000000 == 0) {
            //     System.out.println("deltaTime: " + 1);
            //     System.out.println("fps: " + (1 ));
            // }
            // ticks++;

            //Time.updateStartTime();

        }


        System.exit(0);

    }

    public static void setIsRunning(boolean bool) {
        isRunning = bool;
    }

    public static boolean getIsRunning() {
        return isRunning;
    }

    public static double getDeltaTime() {
        return deltaTime;
    }

    /**
     * Calculate all the data of the logic core's game. At each tick of
     * the loop theses data are update. In this way {@code update()}
     * should be placed in the inner loop.
     */
    private static void update() {
        ModelManager.getInstance().player.update();
        ModelManager.getInstance().scene01.checkCollision();    
        ModelManager.getInstance().playerCamera.update();
        ModelManager.getInstance().scene01.removeDeadEntities();

        for(var enemy : ModelManager.getInstance().scene01.getEnemies()) {
            enemy.update();
        }
    }

    /**
     * Render all the images of the ressources provided. At each tick of
     * the loop theses images are render. In this way {@code update()}
     * should be placed in the inner loop.
     */
    private static void render() {
        ViewWindow.scene.repaint();
    }
}
