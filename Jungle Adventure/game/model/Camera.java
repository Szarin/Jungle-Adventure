package game.model;

import game.view.ViewWindow;
import physics.Vector2D;
import java.awt.Graphics;

public class Camera {

    public Vector2D position;
    private Character character;

    public Camera(Character character) {
        position = new Vector2D();
        this.character = character;
    }

    public int getPosX() {
        return (int)(character.getPosX() - ViewWindow.WIDTH/2);
    }

    public int getPosY() {
        return (int)(character.getPosY() - ViewWindow.HEIGHT/2);
    }

    public void update() {
        position.x = getPosX();
        position.y = getPosY();
    }

    public void render(Graphics graphics) {
        graphics.translate((int)position.x, (int)position.y);
    }

    public void unfollow(Graphics graphics) {
        graphics.translate((int)-position.x, 0);
    }
    
}
