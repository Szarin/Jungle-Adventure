package game.model;

import graphictools.Sprite;
import utils.BooleanEvent;
import utils.Direction;
import core.GameObject;
import java.awt.Rectangle;

public abstract class Character extends Entity {

    public boolean left;
    public boolean right;
    private Direction facing;
    protected float fallSpeed;
	protected boolean isInAir;
    protected int movementSpeed;

    public Character(float posX, float posY, Sprite sprite) {
        super(posX, posY, sprite);

        this.left = false;
		this.right = false;
		this.fallSpeed = 0;
		this.isInAir = true;
		this.facing = Direction.RIGHT;
		this.movementSpeed = 5;
    }

    public void setFacing(Direction direction) {
        this.facing = direction;
    }

    public Direction getFacing() {
        return this.facing;
    }

    /**Sets fall speed to 10*/
	public void jump() {
		if(!isInAir) {
			this.fallSpeed = -15;
			this.isInAir = true;
		}
	}

    protected abstract void changeAnimation();

	public abstract void update();

    public void move() {
		if(left) {
			position.x -= this.movementSpeed;
			facing = Direction.LEFT;
		}
		if(right) {
			this.position.x += this.movementSpeed;
			this.facing = Direction.RIGHT;
		}
		
		this.position.y += this.fallSpeed;
		this.fallSpeed++;
    }

    public Direction checkCollision(Entity block) {
		Rectangle intersection = getSprite().intersection(block.getSprite());
		
		if(intersection.isEmpty()) {
			return Direction.NULL; //No collision
		}
		
		if(intersection.width > intersection.height) {
			//Above or below

			//System.out.println("intersection");
			
			if(position.y < block.position.y) {
				//System.out.println("above");
				//Above
				position.y = block.position.y - getSprite().height;
				this.fallSpeed = 0;
				this.isInAir = false;
				return Direction.NULL;
			} else {
				//System.out.println("below");

				//Below
				position.y = block.position.y + block.getSprite().height;
				this.fallSpeed = 0;
				return Direction.NULL;
			}
		} else {
			//Left or right
			
			if(position.x < block.position.x) {
				//Left
				//System.out.println("left");

				position.x = block.position.x - getSprite().width;
				return Direction.LEFT;
			} else {
				//Right
				//System.out.println("right");

				position.x = block.position.x + block.getSprite().width;
				return Direction.RIGHT;
			}
		}

	}

}
