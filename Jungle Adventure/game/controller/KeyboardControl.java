package game.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.core.GameLoop;
import game.model.ModelManager;

/**
 * Class implementation of the {@link java.awt.event.KeyListener KeyListener}
 * type. Especially this class is used to implement the keyboard controls.
 * As this class is an implement of {@code KeyListener} <b>don't use</b>
 * the method of this class.
 * 
 * @author  Guillaume Schneider, Hugo Miceli
 * @version 1.0
 * @since   2021-04-12
 */
public class KeyboardControl implements KeyListener {

    private ModelManager modelManager;

    public KeyboardControl() { modelManager = ModelManager.getInstance(); }

    @Override
    public void keyPressed(KeyEvent keyCode) {

        if (keyCode.getKeyCode() == KeyEvent.VK_ESCAPE) {
            GameLoop.setIsRunning(false);
        }

        if(keyCode.getKeyCode() == KeyEvent.VK_A || keyCode.getKeyCode() == KeyEvent.VK_LEFT) {
            modelManager.player.left = true;
        }
        else if(keyCode.getKeyCode() == KeyEvent.VK_D || keyCode.getKeyCode() == KeyEvent.VK_RIGHT) {
            modelManager.player.right = true;
        }
        else if(!modelManager.player.isTransforming() && (keyCode.getKeyCode() == KeyEvent.VK_SPACE || keyCode.getKeyCode() == KeyEvent.VK_UP)) {
            modelManager.player.jump();
        }

        if(keyCode.getKeyCode() == KeyEvent.VK_F) {
            modelManager.player.setTransformation(true);
            modelManager.player.setTransformationTimeStart();
        }

        if(keyCode.getKeyCode() == KeyEvent.VK_E && modelManager.player.isTransforming()) {
            modelManager.player.setAttacking(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent keyCode) {
        if(keyCode.getKeyCode() == KeyEvent.VK_A || keyCode.getKeyCode() == KeyEvent.VK_LEFT) {
			modelManager.player.left = false;
		}
		else if(keyCode.getKeyCode() == KeyEvent.VK_D || keyCode.getKeyCode() == KeyEvent.VK_RIGHT) {
			modelManager.player.right = false;
		}
    }

    @Override
    public void keyTyped(KeyEvent keyCode) {
    }
    
}
