import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Counter is an Actor in the Going to the Moon Scenario
 * 
 * @author: Randy Gallant
 * @School: University of Guelph/Humber
 * @version: 1.0 Nov. 2007
 */
public class Counter extends Actor
{
    private int value;;
    private String text;
    private int stringLength;

    public Counter()
    {
        text = "";
        stringLength = (text.length() + 2) * 10;
        updateImage();
    }

    public Counter(String prefix, int fuel)
    {
        value = fuel;
        text = prefix;
        stringLength = (text.length() + 2) * 10;

        setImage(new GreenfootImage(stringLength, 16));
        updateImage();
    }

    public int Reset(int Fuelnew)
    {
        value = Fuelnew;
        updateImage();
        return value;
    }
    public void Decrement()
    {
        value--;
        updateImage();
    }

    /**
     * Create and Update the Image
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(Color.WHITE);
        image.drawString(text + value, 1, 12);
    }
}