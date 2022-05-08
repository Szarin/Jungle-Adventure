package game.model;

import java.util.Random;

import core.Animation;
import game.view.AnimationManager;
import graphictools.Sprite;

public class Enemy extends Character {

    private boolean dead;
    private boolean remove;
    private int tick;
    private int deathTick;

    public Enemy(float posX, float posY, Sprite sprite) {
        super(posX, posY, sprite);
        deathTick = 0;
    }

    @Override
    protected void changeAnimation() {
        if(ModelManager.getInstance().player.isAttacking()) {
            setSprite(AnimationManager.getAnimation("a_SlimeDeath").getCurrentFrame());
            dead = true;
        }
        else {
            setSprite(AnimationManager.getAnimation("a_SlimeJump").getCurrentFrame());
        } 
    }

    @Override
    public void move() {
        changeAnimation();
    }

    @Override
    public void update() {
        move();

        if(dead) {
            deathTick++;
        }

        if(deathTick >= getDeathDelay()) {
            remove = true;
        }

    }

    public boolean isDead() {
        return remove;
    }
    
    public int getDeathDelay() {
        graphictools.Animation slimeDeath = AnimationManager.getAnimation("a_SlimeDeath");
        return (int)(slimeDeath.getDelay() * slimeDeath.getFramesNumber());
    }
}
