package game.model;

import game.view.AnimationManager;
import graphictools.Animation;
import graphictools.Sprite;

public class MainCharacter extends Character{

    private final int NB_JUMP_MAX = 1;
    private final double TRANSFORMATION_DURATION = 5.0f;
    private final int DEFAULT_POSX;
    private final int DEFAULT_POSY;

    public float jumpNumber = NB_JUMP_MAX;
    private int playerHealth = 3;
    private boolean transformation;
    private boolean attacking;
    private double transformationTime;
    private double transformationTimeStart;
    private int tick;

    public MainCharacter(int posX, int posY, Sprite sprite) {
        super(posX, posY, sprite);

        DEFAULT_POSX = posX;
        DEFAULT_POSY = posY;
        transformationTime = 0.0f;
        transformationTimeStart = 0.0f;
        tick = 0;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public boolean isTransforming() {
        return transformation;
    }

    public void setAttacking(boolean bool) {
        this.attacking = bool;
    }

    public void setTransformation(boolean bool) {
        this.transformation = bool;
    }

    public void update() {
        move();

        if(transformation) {

            movementSpeed = 1;

            if(attacking) {
                tick++;
    
                Animation buffer = AnimationManager.getAnimation("a_SkeletonAttack");
                if(tick == buffer.getDelay() * buffer.getFramesNumber()) {
                    attacking = false;
                    tick = 0;
                }
            }

            transformationTime = System.currentTimeMillis() - transformationTimeStart;
            if(transformationTime / 1000 >= TRANSFORMATION_DURATION) {
                transformation = false;

                transformationTime = 0.0f;
                transformationTimeStart = 0.0f;
            }
        }
        else {
            movementSpeed = 6;
        }

    }

    public void setTransformationTimeStart() {
        transformationTimeStart = System.currentTimeMillis();
    }

    @Override
    protected void changeAnimation() {

        if(!transformation) {
            if(this.fallSpeed < 0 && this.isInAir) {
                setSprite(AnimationManager.getAnimation("a_PlayerJumping").getCurrentFrame());
                jumpNumber--;
            }
            else {
                if(this.left || this.right) {
                    setSprite(AnimationManager.getAnimation("a_PlayerWalking").getCurrentFrame());
                } else {
                    setSprite(AnimationManager.getAnimation("a_PlayerIdling").getCurrentFrame());
                }
            }
        }
        else {
            if(attacking) {
                setSprite(AnimationManager.getAnimation("a_SkeletonAttack").getCurrentFrame());
            }
            else if(this.left || this.right) {
                setSprite(AnimationManager.getAnimation("a_SkeletonWalking").getCurrentFrame());
            } else {
                setSprite(AnimationManager.getAnimation("a_SkeletonIdling").getCurrentFrame());
            }
        }
    }

    @Override
    public void move() {
        //currentDelayRelease = Math.abs((ControllerManager.getInstance().keyboardControl.getCurrentTimeRelease() + DELAY_RELEASE) - Time.getTime());

        if(playerHealth > 0) {
            super.move();
        }

        changeAnimation();
    }

    @Override
    public String toString() {
        return "{ x='" + position.x +
                "', y='" + position.y +
                "', width='" + sprite.width +
                "', height='" + sprite.height + "' }";
    }
}