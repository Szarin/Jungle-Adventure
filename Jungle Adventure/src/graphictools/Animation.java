package graphictools;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe <code>Animation</code> is a stucture that contains a set of sprites
 * <p>
 * Animation is usually used to operate in a inner loop. In this case
 * each sprite displayed constitute one tick at time
 * 
 * @author 	Guillaume Schneider
 * @version 1.0
 * @since 	2021-03-12
 */
public class Animation {

    private List<Sprite> frames;
	private double delay;
	
	private int currentFrame;
	private int currentDelay;
	
	/**
	 * Creates an animation
	 * @param delay  The number of ticks between each frame
	 * @param framesModels  The animation frames
	 */
	public Animation(double delay, Sprite... framesModels) {
		this.frames = new ArrayList<Sprite>();
		this.delay = delay;
		this.currentFrame = 0;
		this.currentDelay = 0;
		
		for(Sprite model : framesModels) {
			this.frames.add(model);
		}
	}

	/**
	 * Creates an animation
	 * @param delay  The number of ticks between each frame
	 * @param framesModels  The animation frames
	 */
    public Animation(double delay, List<Sprite> framesModels) {
        this.frames = new ArrayList<Sprite>();
		this.delay = delay;
		this.currentFrame = 0;
		this.currentDelay = 0;
		
		frames = framesModels;
    }
	
	/**
	 * Gets the current frame of the animation
	 * @return the current sprite at each tick's main loop
	*/
	public Sprite getCurrentFrame() {
		this.currentDelay++;
		if(this.currentDelay == this.delay) {
			this.currentFrame++;
			if(this.currentFrame == frames.size()) {
				this.currentFrame = 0;
			}
			this.currentDelay = 0;
		}
		return frames.get(currentFrame);
		
	}

	public double getDelay() {
		return this.delay;
	}

	public int getFramesNumber() {
		return frames.size();
	}
    
}
