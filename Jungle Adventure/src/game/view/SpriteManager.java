package game.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import graphictools.Sprite;

/**
 * Central structure class to organize and initialize all the {@code Sprite} created.
 * Use this class as a static class (instatiation is not enabled). 
 * <p>
 * Method {@link #init()} must be called to make the behavior of this class work.
 * <p>
 * To access a {@code List<Sprite>} get through 
 * {@link game.view.SpriteManager#getSprites(String) getSprites(String)}
 * or for a {@code Sprite} get through 
 * {@link game.view.SpriteManager#getSprite(String) getSprite(String)}.
 * <p>
 * The image scale to render of {@code Sprite} can be changed get through this class
 * ({@link #setSpriteScale(int)}).
 * 
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since 2021-04-12
 * @see {@link graphictools.Sprite Sprite}
 */
public class SpriteManager {

    private static List<Sprite> s_PlayerIdling;
    private static List<Sprite> s_PlayerWalking;
    private static List<Sprite> s_SkeletonWalking;
    private static List<Sprite> s_SkeletonAttack;
    private static List<Sprite> s_SkeletonIdling;
    private static List<Sprite> s_SlimeIdling;
    private static List<Sprite> s_SlimeJump;
    private static List<Sprite> s_SlimeDeath;
    private static List<Sprite> background;
    private static HashMap<String, List<Sprite>> spritesHashMap;

    private static HashMap<String, Sprite> spriteHashMap;
    
    private SpriteManager() {}
    
    public static void init() {
		System.out.println("system class SpriteManager: Initialization...");
        
        initObject();
        initSpriteHashMap();
        initSpritesHashMap();
    }

    public static void initObject() {
        s_PlayerIdling = new ArrayList<>();
        s_PlayerWalking = new ArrayList<>();
        s_SkeletonAttack = new ArrayList<>();
        s_SkeletonWalking = new ArrayList<>();
        s_SkeletonIdling = new ArrayList<>();
        s_SlimeDeath = new ArrayList<>();
        s_SlimeIdling = new ArrayList<>();
        s_SlimeJump = new ArrayList<>();
        background = new ArrayList<>();

        initSprites(384, 216, "Background/plx-", 5, background);
        initSprites(19, 34, "Player/Idle/idle_frame_", 12, s_PlayerIdling);    
        initSprites(19, 34, "Player/Walking/run", 8, s_PlayerWalking);   
        initSprites(19, 34, "Player/WalkingSkeleton/tile", 12,  s_SkeletonWalking);
        initSprites(25, 34, "Player/AttackSkeleton/tile", 17, s_SkeletonAttack);
        initSprites(19, 34, "Player/IdleSkeleton/tile", 10, s_SkeletonIdling);
        initSprites(25, 34, "Enemy/Slime/Idle/SlimeBlue_Idle", 4, s_SlimeIdling);
        initSprites(25, 34, "Enemy/Slime/Jump/SlimeBlue_Jump", 18, s_SlimeJump);
        initSprites(29, 34, "Enemy/Slime/Death/SlimeBlue_Death", 11, s_SlimeDeath);
    }

    private static void initSpritesHashMap() {
        spritesHashMap = new HashMap<>();

        spritesHashMap.put("s_PlayerIdling", s_PlayerIdling);
        spritesHashMap.put("s_PlayerWalking", s_PlayerWalking);
        spritesHashMap.put("background", background);
        spritesHashMap.put("s_SkeletonWalking", s_SkeletonWalking);
        spritesHashMap.put("s_SkeletonAttack", s_SkeletonAttack);
        spritesHashMap.put("s_SkeletonIdling", s_SkeletonIdling);
        spritesHashMap.put("s_SlimeIdling", s_SlimeIdling);
        spritesHashMap.put("s_SlimeDeath", s_SlimeDeath);
        spritesHashMap.put("s_SlimeJump", s_SlimeJump);

        setSpritesScale("s_PlayerIdling", 5);   
        setSpritesScale("s_PlayerWalking", 5);  
        setSpritesScale("background", 3);   
        setSpritesScale("s_SkeletonAttack", 6);
        setSpritesScale("s_SkeletonWalking", 5);
        setSpritesScale("s_SkeletonIdling", 5);
        setSpritesScale("s_SlimeJump", 5);
        setSpritesScale("s_SlimeIdling", 5);
        setSpritesScale("s_SlimeDeath", 5);
    }

    private static void initSpriteHashMap() {
        spriteHashMap = new HashMap<>();

        spriteHashMap.put("s_Slime", new Sprite(19, 34, "Enemy/Slime/Idle/SlimeBlue_Idle1"));
        spriteHashMap.put("s_PlayerJumping", new Sprite(19, 34, "Player/Jumping/jump1"));
        spriteHashMap.put("tile_lu", new Sprite(16, 16, "Tileset/tile_lu"));
        spriteHashMap.put("tile_u", new Sprite(16, 16, "Tileset/tile_u"));
        spriteHashMap.put("tile_ru", new Sprite(16, 16, "Tileset/tile_ru"));
        spriteHashMap.put("tile_l", new Sprite(16, 16, "Tileset/tile_l"));
        spriteHashMap.put("tile_ilu", new Sprite(16, 16, "Tileset/tile_ilu"));
        spriteHashMap.put("tile_iu", new Sprite(16, 16, "Tileset/tile_iu"));
        spriteHashMap.put("tile_iru", new Sprite(16, 16, "Tileset/tile_iru"));
        spriteHashMap.put("tile_il", new Sprite(16, 16, "Tileset/tile_il"));
        spriteHashMap.put("tile_i", new Sprite(16, 16, "Tileset/tile_i"));
        spriteHashMap.put("tile_ir", new Sprite(16, 16, "Tileset/tile_ir"));
        spriteHashMap.put("tile_ild", new Sprite(16, 16, "Tileset/tile_ild"));
        spriteHashMap.put("tile_r", new Sprite(16, 16, "Tileset/tile_r"));
        spriteHashMap.put("tile_id", new Sprite(16, 16, "Tileset/tile_id"));
        spriteHashMap.put("tile_ird", new Sprite(16, 16, "Tileset/tile_ird"));
        spriteHashMap.put("tile_ld", new Sprite(16, 16, "Tileset/tile_ld"));
        spriteHashMap.put("tile_d", new Sprite(16, 16, "Tileset/tile_d"));
        spriteHashMap.put("tile_rd", new Sprite(16, 16, "Tileset/tile_rd"));
        spriteHashMap.put("tile_clu", new Sprite(16, 16, "Tileset/tile_clu"));
        spriteHashMap.put("tile_cru", new Sprite(16, 16, "Tileset/tile_cru"));
        spriteHashMap.put("tile_cld", new Sprite(16, 16, "Tileset/tile_cld"));
        spriteHashMap.put("tile_crd", new Sprite(16, 16, "Tileset/tile_crd"));

        setSpriteScale("s_PlayerJumping", 5);
        setSpriteScale("tile_lu", 5);
        setSpriteScale("tile_u", 5);
        setSpriteScale("tile_ru", 5);
        setSpriteScale("tile_l", 5);
        setSpriteScale("tile_ilu", 5);
        setSpriteScale("tile_iu", 5);
        setSpriteScale("tile_iru", 5);
        setSpriteScale("tile_il", 5);
        setSpriteScale("tile_i", 5);
        setSpriteScale("tile_ir", 5);
        setSpriteScale("tile_ild", 5);
        setSpriteScale("tile_r", 5);
        setSpriteScale("tile_id", 5);
        setSpriteScale("tile_ird", 5);
        setSpriteScale("tile_ld", 5);
        setSpriteScale("tile_d", 5);
        setSpriteScale("tile_rd", 5);
        setSpriteScale("tile_clu", 5);
        setSpriteScale("tile_cru", 5);
        setSpriteScale("tile_cld", 5);
        setSpriteScale("tile_crd", 5);
    }   
        
    /**
     * Init the list of sprites for a given animation
     * @param width  width of the image
     * @param height  height of the image
     * @param pathfile  pathfile from res\\texture (res/texture for Linux and MacOS).
     * Assuming assuming it is for the character player, then the pathfile will be: 
     * <i>"Player\\file"</i>.
     * @param imagesNumber  number of the images for animation
     * @param sprites  given images frames list
     */
    private static void initSprites(int width, int height, String pathfile, int imagesNumber, List<Sprite> sprites) {
        for(int i = 0; i < imagesNumber; i++) {
            sprites.add(i, new Sprite(width, height, pathfile + (i + 1)));
        }
    }

    public static List<Sprite> getSprites(String key) {
        return spritesHashMap.get(key);
    }

    public static Sprite getSprite(String key) {
        return spriteHashMap.get(key);
    }

    public static void setSpritesScale(String sprites, int scale) {
        Iterator<Sprite> iterSprites = getSprites(sprites).iterator();
        while(iterSprites.hasNext()) {
            iterSprites.next().setScale(scale);
        }
    }

    public static void setSpriteScale(String sprite, int scale) {
        getSprite(sprite).setScale(scale);
    }
    
}