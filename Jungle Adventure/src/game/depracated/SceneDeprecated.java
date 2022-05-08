package game.depracated;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.model.Enemy;
import game.model.MainCharacter;
import game.model.Tile;
import game.view.SpriteManager;
import game.view.ViewWindow;
import graphictools.Sprite;
import utils.Direction;
import utils.Path;

/**
 * {@code Scene} is the composite set of all entity that form
 * a new level via a text file system.
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-12-12
 */
@Deprecated
public class SceneDeprecated {

    private MainCharacter player;
    private List<Enemy> enemies;
    private List<Tile> tiles;

    private int height;
    private int width;
    private int id;

    public SceneDeprecated(MainCharacter player, String filename) {
        System.out.println("system class Scene: loading scene...");
        this.player = player;

        tiles = new ArrayList<>();
        enemies = new ArrayList<>();

        loadMap(filename, 15, 15);
    }

    public MainCharacter getPlayer() {
        return this.player;
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }


    public List<Tile> getTiles() {
        return this.tiles;
    }


    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getId() {
        return this.id;
    }

    private void loadMap(String filename, int width, int height) {
        BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(new Path("res/maps/" + filename + ".txt").getPath())));

            this.width = Integer.parseInt(reader.readLine());
		    this.height = Integer.parseInt(reader.readLine());
						
			for(int y=0;y<height;y++) {
				String line = reader.readLine();
				String[] singles = line.split("\\s+");
				
				for(int x=0;x<width;x++) {
					switch(singles[x]) {
					case "1":
                        Sprite tile010 = SpriteManager.getSprite("tile010");
						this.tiles.add(new Tile(x * tile010.width, y * tile010.height, tile010));
						break;
					/*case "x":
						this.enemies.add(new Enemy(x*blockModel.width, y*blockModel.height));
						break;
					case "^":
						this.tiles.add(new Spikes(x*blockModel.width, y*blockModel.height, Direction.UP));
						break;
					case "<":
						this.tiles.add(new Spikes(x*blockModel.width, y*blockModel.height, Direction.LEFT));
						break;
					case ">":
						this.tiles.add(new Spikes(x*blockModel.width, y*blockModel.height, Direction.RIGHT));
						break;
					case ".":
						this.tiles.add(new Spikes(x*blockModel.width, y*blockModel.height, Direction.DOWN));
						break;
					case "X":
						this.tiles.add(new ExitDoor(x*blockModel.width, y*blockModel.height-20));
						break;*/
					case "0":
						break;
					}
				}
			}
		} catch(IOException e) {
			System.err.println("system class Scene: couldn't load map file " + filename);
		}
    }
    
}
