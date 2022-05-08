package game.model;

import graphictools.Sprite;
import physics.Vector2D;

import java.awt.Rectangle;

import components.Transform;
import core.GameObject;

public class Tile extends Entity {

    public final static int TILE_WIDTH = 16;
    public final static int TILE_HEIGHT = 16;

    private int tileId;
    private static int countId;
    private boolean isColliding = true;

    public Tile(float posX, float posY) {
        super(posX, posY, null);
        tileId = 0;
    }

    public Tile(float posX, float posY, Sprite sprite) {
        this(posX, posY);
        this.sprite = sprite;

        countId++;
        tileId = countId;
    }

    public void desactiveCollision() {
        isColliding = false;
    }

    public boolean getIsColliding() {
        return this.isColliding;
    }

    public int getTileId() {
        return this.tileId;
    }

    @Override
    public String toString() {
        return "{ id='" + tileId +
                "', posX='" + getPosX() +
                "', posY='" + getPosY() +
                "' }";
    }
    
}
