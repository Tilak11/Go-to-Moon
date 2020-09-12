import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * 
 * This class belongs to the Going to the Moon final project Scenario
 * 
 * This class defines the size of the world (800 x 800) and creates as well as
 * places the initial objects in space.
 * 
 * @author: Randy Gallant
 * @School: Univeristy of Guelph Humber ... Toronto, Canada
 * @version: 1.0 Nov. 2007
 */
public class GoingToTheMoon extends World
{

    /**
     * Constructor for objects of class GoingToTheMoon.
     * 
     */
    public GoingToTheMoon()
    {    
         
        super(800,800,1);
        setBackground("space1.gif");
        addObject(new shuttle(), 400, 748);
        addObject(new Earth(), 400, 780);
        addObject(new EarthLandingPad(), 400, 759);
        addObject(new MoonLand(), 400, 20);
        addObject(new MoonLandingPad(), 400, 45);
        addObject(new RockRight(), 650, 450);
        addObject(new RockRight(), 650, 600);
        addObject(new RockRight(), 450, 530);
        addObject(new RockRight(), 650, 150);
        addObject(new RockRight(), 450, 100);
        addObject(new RockLeft(), 350, 610);
        addObject(new RockCentre(), 400, 700);
        addObject(new RockCentre(), 400, 250);
        addObject(new RockLeft(), 350, 175);
        addObject(new RockLeft(), 270, 390);
        addObject(new RockLeft(), 170, 525);
        addObject(new RockLeft(), 350, 450);
        addObject(new BigRock(), 400, 300);
        addObject(new spacestation(), 720, 350);
        
    }
}
