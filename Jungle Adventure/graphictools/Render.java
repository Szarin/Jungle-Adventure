package graphictools;

import java.awt.Graphics;

import game.model.Camera;
import game.model.Character;
import game.model.Entity;
import utils.Direction;

/**
 * Classe {@code Render} is a set of tools used to graphically render
 * package {@code graphictool}'s objects.
 * <p>
 * {@code Render} is based on the framework java swing.
 * 
 * @author 	Guillaume Schneider
 * @version 1.0
 * @since 	2021-03-12
 * @see 	
 * <a href="https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html">
 * javax.swing</a>
 */
public class Render {
	
	/**
	 * Renders a character on screen
	 * @param entity  The entity to render
	 * @param graphics  Graphics object
	 */
	public static void renderCharacter(Character character, Graphics graphics) {
		int posX = (int)(character.getPosX());
		int posY = (int)(character.getPosY());
		Sprite sprite = character.getSprite();
		
		if(character instanceof Character) {

			if(((Character) character).getFacing() == Direction.LEFT) {
				renderFlippedSprite(sprite, posX, posY, graphics);
			}
			else renderSprite(sprite, posX, posY, graphics);
		}
		else renderSprite(sprite, posX, posY, graphics);
	}

	/**
	 * Render an entity on screen
	 * @param entity  entity to render
	 * @param graphics  graphics object
	 */
	public static void renderGameObject(Entity gameObject, Graphics graphics) {	
		renderSprite(gameObject.getSprite(), (int)gameObject.getPosX(), (int)gameObject.getPosY(), graphics);
	}

	/**
	 * Renders a sprite on screen
	 * @param model  The model to render
	 * @param posX  Model top left corner position
	 * @param posY  Model top left corner position
	 * @param graphics  Graphics object
	 */
	public static void renderSprite(Sprite sprite, int posX, int posY, Graphics graphics) {
		graphics.drawImage(sprite.getTexture(), posX, posY, sprite.width, sprite.height, null);
	}

	/**
	 * Renders an horizontally flipped sprite on screen
	 * @param model  The model to render
	 * @param posX  Model top left corner position
	 * @param posY  Model top left corner position
	 * @param graphics  Graphics object
	 */
	public static void renderFlippedSprite(Sprite sprite, int posX, int posY, Graphics graphics) {
		graphics.drawImage(sprite.getTexture(), posX + sprite.width, posY, -sprite.width, sprite.height, null);
	}
}