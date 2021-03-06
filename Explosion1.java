import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.*;

/**
 * Explosion1 is an Actor in the Going to the Moon Scenario
 * @author: Randy Gallant
 * @School: University of Guelph/Humber
 * @version: 1.0 Nov. 2007
 *
 *
 * An explosion. It starts by expanding and then collapsing. 
 * The explosion will explode other obejcts that the explosion intersects.
 * 
 * Explosion1 Class Credit to:
 * @author Poul Henriksen
 * @version 1.0.1
 */

public class Explosion1 extends Actor
{
    /** How many images should be used in the animation of the explostion */
    private final static int IMAGE_COUNT= 8;
    
    /** 
     * The images in the explosion. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    
    /** Current size of the explosion */
    private int size=0;
    
    /** How much do we increment the index in the explosion animation. */
    private int increment=1;    
    
    public Explosion1() {
        
        initialiseImages();
        setImage(images[0]);        
        Greenfoot.playSound("Explosion.wav");
    }    
    
    /** 
     * Create the images for explosion.
     */
    public synchronized static void initialiseImages() {
        if(images == null) {
            GreenfootImage baseImage = new GreenfootImage("images/explosion.png");
            int maxSize = baseImage.getWidth()/2;
            int delta = maxSize / (IMAGE_COUNT+1);
            int size = 0;
            images = new GreenfootImage[IMAGE_COUNT];
            for(int i=0; i < IMAGE_COUNT; i++) {
                size = size + delta;
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    /**
     * EXPLODE!
     */
    public void act()
    { 
        setImage(images[size]);

        size += increment;
        if(size>=IMAGE_COUNT) {
            increment = -increment;
            size += increment;
        }
        
       
        if(size <= 0) {
            getWorld().removeObject(this);
        }
    }
    
}