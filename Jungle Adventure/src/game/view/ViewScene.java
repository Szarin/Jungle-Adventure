package game.view;


import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game.core.GameLoop;
import game.model.Camera;
import game.model.Enemy;
import game.model.Tile;
import game.model.ModelManager;
import game.model.Scene;
import graphictools.Render;
import graphictools.Sprite;

import java.awt.event.KeyListener;
import java.util.List;


public class ViewScene extends JPanel {
    
    private static final long serialVersionUID = 1L;
	private Scene modelScene;
	private Camera camera;
	private boolean active;
	private int id;

	private List<Tile> tiles;
	private List<Enemy> enemies;

	public ViewScene(Scene scene, KeyListener listener) {
		super();

		System.out.println("system class ViewScene: create scene render...");
		modelScene = scene;

		camera = ModelManager.getInstance().playerCamera;
		id = scene.getId();
		tiles = scene.getTiles();
		enemies = scene.getEnemies();

		this.setFocusable(true);
		this.addKeyListener(listener);

	}

	public void renderBackground(List<Sprite> sprites, Graphics graphics) {
		List<Sprite> background = sprites;

		for(int x = 0; x < modelScene.sceneWidth; x += background.get(0).width) {
			Render.renderSprite(background.get(0), x, 0, graphics);
			Render.renderSprite(background.get(1), x, 0, graphics);
			Render.renderSprite(background.get(2), x, 0, graphics);
			Render.renderSprite(background.get(3), x, 0, graphics);
			Render.renderSprite(background.get(4), x, 0, graphics);
		}
	}

	public void renderBackground(Sprite sprite, Graphics graphics) {
		Sprite background = sprite;

		for(int x = 0; x < getWidth(); x += background.width) {
			Render.renderSprite(background, x, 0, graphics);
		}
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean bool) {
		active = bool;
	}

	public int getId() {
		return id;
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);


		//if(GameLoop.getIsRunning()) {
	
		if(ModelManager.getInstance().player.getPosX() > ViewWindow.WIDTH)
			camera.unfollow(graphics);

		renderBackground(SpriteManager.getSprites("background"), graphics);

		for(var tile : tiles) {
			Render.renderSprite(tile.getSprite(), (int)tile.getPosX(), (int)tile.getPosY(), graphics);
			// graphics.drawString("(" + tile.getPosX() + ", " + tile.getPosY() + ")", (int)(tile.getPosX() + tile.getSprite().width / 2), (int)(tile.getPosY() + tile.getSprite().height / 2));
		}

		for(var enemy : enemies) {
			Render.renderCharacter(enemy, graphics);
		}

		Render.renderCharacter(ModelManager.getInstance().player, graphics);
		camera.render(graphics);

		// graphics.setColor(Color.BLACK);
		// graphics.setFont(new Font("serif", Font.BOLD, 10));
		// graphics.drawString("(" + ModelManager.getInstance().player.getPosX() + ", " + ModelManager.getInstance().player.getPosY() + ")", 100, 100);
	}
}