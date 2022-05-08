package game.view;

import java.util.HashMap;

import graphictools.Animation;

/**
 * 
 */
public class AnimationManager {
    
    private static Animation a_PlayerIdling;
    private static Animation a_PlayerWalking;
    private static Animation a_PlayerJumping;
    private static Animation a_SkeletonAttack;
    private static Animation a_SkeletonIdling;
    private static Animation a_SkeletonWalking;
    private static Animation a_SlimeIdling;
    private static Animation a_SlimeJump;
    private static Animation a_SlimeDeath;

    private static HashMap<String, Animation> animationHashMap = new HashMap<>();

    private AnimationManager() {}

    public static void init() {
        SpriteManager.init();
        System.out.println("system class Animation: Initialization...");
        
        // !!BEWARE of the order : initObjet() must be before initHashMap()
        initObject();
        initHashMap();
    }

    private static void initObject() {
        a_PlayerIdling = new Animation(10 , SpriteManager.getSprites("s_PlayerIdling"));
        a_PlayerWalking = new Animation(6 , SpriteManager.getSprites("s_PlayerWalking"));
        a_PlayerJumping = new Animation(175, SpriteManager.getSprite("s_PlayerJumping"));
        a_SkeletonAttack = new Animation(10, SpriteManager.getSprites("s_SkeletonAttack"));
        a_SkeletonWalking = new Animation(5, SpriteManager.getSprites("s_SkeletonWalking"));
        a_SkeletonIdling = new Animation(10, SpriteManager.getSprites("s_SkeletonIdling"));
        a_SlimeDeath = new Animation(10, SpriteManager.getSprites("s_SlimeDeath"));
        a_SlimeIdling = new Animation(10, SpriteManager.getSprites("s_SlimeIdling"));
        a_SlimeJump = new Animation(10, SpriteManager.getSprites("s_SlimeJump"));
    }

    private static void initHashMap() {
        animationHashMap.put("a_SlimeDeath", a_SlimeDeath);
        animationHashMap.put("a_SlimeIdling", a_SlimeIdling);
        animationHashMap.put("a_SlimeJump", a_SlimeJump);
        animationHashMap.put("a_PlayerIdling", a_PlayerIdling);
        animationHashMap.put("a_PlayerWalking", a_PlayerWalking);
        animationHashMap.put("a_PlayerJumping", a_PlayerJumping);
        animationHashMap.put("a_SkeletonWalking", a_SkeletonWalking);
        animationHashMap.put("a_SkeletonIdling", a_SkeletonIdling);
        animationHashMap.put("a_SkeletonAttack", a_SkeletonAttack);
    }

    public static Animation getAnimation(String key) {
        return animationHashMap.get(key);
    }
    
}
