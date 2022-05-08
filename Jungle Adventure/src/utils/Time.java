package utils;

/*
* Class of implementation of tools and temporality
* especially and usually within the main loop
* it is advisable to make it inherited from the main loop class and not outside to be able to implement its tools
*/
@Deprecated
public class Time {
    
    public static float timeStarted = System.nanoTime();
    private static float previousTime, startTime, lastTime;
    private static float deltaTime = 1.0f;
    private static float fps;

    public static float getTime() {
        return System.currentTimeMillis() / 1000;
    }

    public static float getPreviousTime() {
        return previousTime;
    }

    /*
    * Get the delta time per tick usually of the main loop
    * to make it work set up the function updateDeltaTime()
    */
    public static float getDeltaTime() {
        return deltaTime;   
    }

    /*
    * Get the startTime of the main's loop
    * Set up the function updateStartTime() before use this function
    */
    protected static float getStartTime() {
        return startTime;
    }

    /*
    * Get the lastTime of the main's loop
    * Set up the function updateLastTime() before use this function
    */
    protected static float getLastTime() {
        return lastTime;
    }

    protected static void updatePreviousTime() {
        previousTime = System.nanoTime();
    }

    protected static void updateStartTime() {
        startTime = System.nanoTime();
    }

    protected static void updateLastTime() {
        lastTime = (float)((System.nanoTime() - startTime) * 1E-9);
    }

    /*
    * update the delta time's tick of the main loop
    * In order to make this function work, you need to set up the startTime and the lastTime in the main loop
    * use function updateStartTime() to set up startTime's tick main loop
    * use function updateLastTime() to set up lastTime's tick main loop 
    */
    public static void updateDeltaTime() {
        deltaTime = lastTime - startTime;
    }

    /*
    * Get the fps of the soft
    * In order to make this function work, you need to set up the function updateFps()
    */
    public static float getFps() {
        return fps;
    }

    /*
    * Update the value of the fps for each tick
    */
    public static void updateFps() {
        fps = 1 / deltaTime;
    }

}
