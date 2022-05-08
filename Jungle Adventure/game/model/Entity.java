package game.model;

import graphictools.Sprite;
import physics.Vector2D;
import utils.Direction;

import java.awt.Rectangle;

public abstract class Entity {

    protected Sprite sprite;
	private boolean lockSprite;
	
	protected Vector2D position;

	private Entity(double posX, double posY) {
		position = new Vector2D(posX, posY);
	}
	
	public Entity(double posX, double posY, Sprite sprite) {
		this(posX, posY);
		this.sprite = sprite;
	}
	
	public double getPosX() {
		return position.x;
	}
	
	public double getPosY() {
		return position.y;
	}
	
	public Sprite getSprite() {
		sprite.x = (int)position.x;
		sprite.y = (int)position.y;
		return sprite;
	}
	
	public void setSprite(Sprite sprite) {
		if(lockSprite) {
			return;
		}
		this.sprite = sprite;
	}
    
	public void lockCurrentSprite() {
		lockSprite = true;
	}

	public void unlockCurrentSprite() {
		lockSprite = false;
	}
}
