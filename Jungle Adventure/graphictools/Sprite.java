package graphictools;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import utils.OSDetector;

/**
 * Classe {@code Sprite} is structure that contains all the informations
 * about a texture to render. 
 * <p>
 * {@code Sprite} is based on 
 * <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html">
 * BufferedImage</a> class.
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-03-12
 */
public class Sprite extends Rectangle {
    
    private static final long serialVersionIUD = 1L;
    private BufferedImage texture;
    private int scale = 1;

    /**
     * Create a sprite needed to render graphics
     * @param width  The width dimensions of the image to render
     * @param height  The height dimension of the image to render
     * @param filename  The pathfile of the image
     * @throws Exception
     */
    public Sprite(int width, int height, String filename) {
        super(width, height);

        String fileroot = OSDetector.stringPathFormater("res/texture/");
        filename = OSDetector.stringPathFormater(filename);

        if(filename != null) {
            try {
                this.texture = ImageIO.read(new File(fileroot + filename + ".png"));
            }
            catch (IOException e) {
                System.err.println("system class Sprite: Failing loading sprite " + filename);
				texture = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
            }
        }
    }

    /**
     * Create a sprite needed to render graphics
     * @param width  The width dimensions of the image to render
     * @param height  The height dimension of the image to render
     * @param texture  The {@code BufferedImage needed to render graphic image}
     */
    private Sprite(int width, int height, BufferedImage texture) {
		super(width, height);
		this.texture = texture;
	}

    public void setScale(int scale) {
        this.scale = scale;
        setSize(width * scale, height * scale);
    }
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}


}