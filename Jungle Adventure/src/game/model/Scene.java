package game.model;

import java.util.ArrayList;
import java.util.List;

import game.view.AnimationManager;
import game.view.SpriteManager;
import graphictools.Sprite;

/**
 * {@code Scene} is the composite set of all entity that form
 * a new level.
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-12-12
 */
public class Scene {

    private List<Tile> tiles;
    private List<Enemy> enemies;
    private MainCharacter player;
    private int[][] posMap;
    
    public int sceneWidth;

    private int id;
    private int enemyDeathDelay;

    public Scene(int[][] posMap, MainCharacter player, int id) {
        tiles = new ArrayList<>();
        enemies = new ArrayList<>();

        this.player = player;
        this.posMap = posMap;
        initTilesMap(this.posMap);

        sceneWidth = posMap[0].length * Tile.TILE_WIDTH * 5;
    }

    public int getId() {
        return this.id;
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    public void removeDeadEntities() {
        for(int i = 0; i < enemies.size(); i++) {
            if(enemies.get(i).isDead()) {
                enemies.remove(i);
            }
        }
 
        /*if(player.isDead()) {
            reset();
        }*/
    }

    public void checkCollision() {
        for(Tile tile : this.tiles) {
            if(tile.getIsColliding())
			    player.checkCollision(tile);
        }
    }

    private int[][] getPosMap() {

        return posMap;
    }

    private void initTilesMap(int[][] posMap) {
        int[][] map = posMap;

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                switch(map[i][j]) {
                    case 1:
                        initTile(j, i, "lu");
                        break;
                    case 2:
                        initTile(j, i, "u");
                        break;
                    case 3:
                        initTile(j, i, "ru");
                        break;
                    case 4:
                        initTile(j, i, "l");
                        break;
                    case 5:
                        initTile(j, i, "ilu");
                        break;
                    case 6:
                        initTile(j, i, "iu");
                        break;
                    case 7:
                        initTile(j, i, "iru");
                        break;
                    case 8:
                        initTile(j, i, "il");
                        break;
                    case 9:
                        initTile(j, i, "i").desactiveCollision();
                        break;
                    case 10:
                        initTile(j, i, "ir");
                        break;
                    case 11:
                        initTile(j, i, "r");
                        break;
                    case 12:
                        initTile(j, i, "ild");
                        break;
                    case 13:
                        initTile(j, i, "id");
                        break;
                    case 14:
                        initTile(j, i, "ird");
                        break;
                    case 15:
                        initTile(j, i, "ld");
                        break;
                    case 16:
                        initTile(j, i, "d");
                        break;
                    case 17:
                        initTile(j, i, "rd");
                        break;
                    case 18:
                        initTile(j, i, "clu");
                        break;
                    case 19:
                        initTile(j, i, "cru");
                        break;
                    case 20:
                        initTile(j, i, "cld");
                        break;
                    case 21:
                        initTile(j, i, "crd");
                        break;
                    case 22:
                        initEnemy(j, i);
                        break;
                    case 0:
                        break;
                }
               // System.out.println(tilesMap[i][j].toString());
            }
        }

       // System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder stringMap = new StringBuilder();

        for(int i = 0; i < posMap.length; i++) {
            stringMap.append("{ ");

            for(int j = 0; j < posMap[0].length; j++) {
                stringMap.append(posMap[i][j] + ", ");
            }
            
            stringMap.append("}\n");
        }

        return stringMap.toString();
    }

    private Enemy initEnemy(float posX, float posY) {
        Sprite slime = SpriteManager.getSprite("s_Slime");
        Enemy resultEnemy = new Enemy(posX * 80, posY * 80, slime);
        enemies.add(resultEnemy);
        return resultEnemy;
    }

    private Tile initTile(float posX, float posY, String tileCode) {
        Sprite tile = SpriteManager.getSprite("tile_" + tileCode);
        Tile resultTile = new Tile(posX * (float)tile.getWidth(), posY * (float)tile.getHeight() - 2, tile);
        tiles.add(resultTile);

        return resultTile;
    }
}
