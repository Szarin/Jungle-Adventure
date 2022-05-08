package game.core;


import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;

import game.controller.ControllerManager;
import game.model.ModelManager;
import game.model.Scene;
import game.view.ViewWindow;
import game.view.ViewManager;

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
public class MainGame {

    public static ViewManager viewManager = ViewManager.getInstance();
    public static ModelManager modelManager = ModelManager.getInstance();
    public static ControllerManager controllerManager = ControllerManager.getInstance();
    //private static Main instance;

    public static void main (String[] args) throws IOException{
        viewManager = ViewManager.getInstance();
        modelManager = ModelManager.getInstance();
        controllerManager = ControllerManager.getInstance();

        Thread mainThread = new Thread(new GameLoop());
        mainThread.start();

    }
}
