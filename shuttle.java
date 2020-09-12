import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This is the Class that controlls the movements of a spaceship on its trip to the Moon
 * and back to Earth again.  The actor is the Object Shuttle.
 * 
 * @author Randy Gallant 
 * @version 1.0 Nov. 2007
 */
public class shuttle extends Actor
{
    /**
     * These are the class' variables that are set up to make the trip to the Moon Possible
     */
    private int sCount=0;
    private static final int EAST = 0;      //variables for direction
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    private  int CentreTurnX;       //initial turning points for manouvers
    private  int CentreTurnY;
    private static int Fuel;
    private int spot=0;//fuel variable
    private int rspot=0;
    public Flag F1;     //flag object
    public Home H1;     //welcome home sign object
    public OutofFuel OOF;   //out of fuel object
    private int fuelstops = 0;      //fuel stops flag
    private int direction;
    private Counter FCounter;   //fuel counter object
    public Explosion EXP;       //Explosion object
    public Explosion1 EXP1;     //explosion1 object
    private  static boolean manouverRight;      //flagts for manouvering around the rocks
    private  static boolean manouverLeft;
    private  static boolean manouverCentre;
    private  static boolean RmanouverRight;      //flagts for manouvering around the rocks
    private  static boolean RmanouverLeft;
    private  static boolean RmanouverCentre;
    private  static boolean returntrip;     //flag for return trip
    private int weaponCount;        //variable to keep track of your weapons

    /**---------------------------------------Shuttle Constuctor --------------------------------------
     * This is the Constructor for the class Shuttle which sets initial conditions
     */
    public shuttle()
    {
        setDirection(NORTH);       //set initial direction
        Fuel = 1500;       //set initial fuel to 1500 pounds
        weaponCount = 1;     //set weapon count to 1
        manouverRight = false;     //set inital flags
        manouverLeft = false;
        manouverCentre = false;
        returntrip = false;
    }

    /**-------------------------------------- Found Space Station ----------------------------------------
     * This method detects that you have found the space station
     */

    public boolean FoundSpaceStation()     //found space station
    {
        Actor SpaceStation = getOneObjectAtOffset(50, 0, spacestation.class);     //detects objects at offset from shuttle location
        if(SpaceStation != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }

    }

    /**-------------------------------------- Found Moon Landing ----------------------------------------
     * This method detects that you have found the small Moon Landing pad
     */
    public boolean FoundMoonLanding()      //found moon landing pad
    {
        Actor MoonL = getOneObjectAtOffset(0, 0, MoonLandingPad.class);     //detects objects at offset from shuttle location
        if(MoonL != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }

    }

    /**-------------------------------------- Found Moon ----------------------------------------
     * This method destoys the ship and Moon if you hit the Moon not the landing point
     */
    public boolean FoundMoon()      //found moon
    {
        Actor MoonL = getOneObjectAtOffset(0, 0, MoonLand.class);     //detects objects at offset from shuttle location
        if(MoonL != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Right Return ----------------------------------------
     * This method detects that you found a Right Rock on your return trip
     */ 
    public boolean FoundRockRightreturn()     //found right rock on return trip
    {
        Actor MoonL = getOneObjectAtOffset(0, 15, RockRight.class);//detects objects at offset from shuttle location
        if(MoonL != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Left Return ----------------------------------------
     * This method detects that you found a Left Rock on your return trip
     */ 
    public boolean FoundRockLeftreturn()      //found left rock on return trip
    {
        Actor MoonL = getOneObjectAtOffset(0, 15, RockLeft.class);     //detects objects at offset from shuttle location
        if(MoonL != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Centre Return ----------------------------------------
     * This method detects that you found a Centre Rock on your return trip
     */ 
    public boolean FoundRockCentrereturn()        //found centre rock on return trip
    {
        Actor MoonL = getOneObjectAtOffset(0, 15, RockCentre.class);     //detects objects at offset from shuttle location
        if(MoonL != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Right ----------------------------------------
     * This method detects that you found a Right Rock on your to the Moon trip
     */
    public boolean FoundRockRight()     //found right rock
    {
        Actor MoonL = getOneObjectAtOffset(0, -15, RockRight.class);     //detects objects at offset from shuttle location
        if(MoonL != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Left ----------------------------------------
     * This method detects that you found a Left Rock on your to the Moon trip
     */
    public boolean FoundRockLeft()      //found left rock
    {
        Actor MoonL = getOneObjectAtOffset(0, -15, RockLeft.class);     //detects objects at offset from shuttle location
        if(MoonL != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Rock Centre ----------------------------------------
     * This method detects that you found a Centre Rock on your to the Moon trip
     */
    public boolean FoundRockCentre()        //found centre rock
    {
        Actor MoonL = getOneObjectAtOffset(0, -15, RockCentre.class);     //detects objects at offset from shuttle location
        if(MoonL != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Big Rock  ----------------------------------------
     * This method detects that you found a Big Rock on your to the Moon trip
     */
    public boolean FoundBigRock()        //found big rock
    {
        Actor SpaceStation = getOneObjectAtOffset(0, -15, BigRock.class);     //detects objects at offset from shuttle location
        if(SpaceStation != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Found Earth Landing ----------------------------------------
     * This method detects that you have found the small Earth Landing pad
     */
    public boolean FoundEarthLanding()     //found earth Landing pad
    {
        Actor SpaceStation = getOneObjectAtOffset(0, 0, EarthLandingPad.class);     //detects objects at offset from shuttle location
        if(SpaceStation != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }

    }

    /**-------------------------------------- Found Earth ----------------------------------------
     * This method destoys the ship and Earth if you hit the Earth not the landing point
     */
    public boolean FoundEarth()     //found earth
    {
        Actor SpaceStation = getOneObjectAtOffset(0, 0, Earth.class);     //detects objects at offset from shuttle location
        if(SpaceStation != null) 
        {

            return true;
        }
        else 
        {
            return false;
        }
    }

    /**-------------------------------------- Can Move ----------------------------------------
     * This method determines if the ship can move or not.  If it has come in contact with
     * an Object in space or has detected the edge of the world
     */   
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) 
        {
            case SOUTH :
            y++;
            break;
            case EAST :
            x++;
            break;
            case NORTH :
            y--;
            break;
            case WEST :
            x--;
            break;
        }

        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) 
        {
            return false;
        }
        else if (x < 0 || y < 0) 
        {
            return false;
        }

        return true;
    }

    /**-------------------------------------- Set Direction ----------------------------------------
     * This method sets the direction of the graphic of your ship to match your movements
     */ 
    public void setDirection(int direction)
    {
        this.direction = direction;
        switch(direction) {
            case SOUTH :
            setRotation(180);
            break;
            case EAST :
            setRotation(90);
            break;
            case NORTH :
            setRotation(0);
            break;
            case WEST :
            setRotation(270);
            break;
            default :
            break;
        }
    }

    /**-------------------------------------- Fuel Dec ----------------------------------------
     * This method creates a new fuel counter and updates it every time you act
     */
    public void FuelDec()
    {
        if(FCounter == null) 
        {
            FCounter = new Counter("Fuel: ", Fuel);   //new fuel counter  
            getWorld().addObject(FCounter, 720, 280);       //add object to world at location
        }        
        FCounter.Decrement();   //decrement the fuel counter
    }

    /**-------------------------------------- Destroy -- ----------------------------------------
     * This method creates a new explosion and destroys object at offset
     */
    public void Destroy()
    {
        Explode();      //call to destroy the rock
        weaponCount--;
        Actor rock = getOneObjectAtOffset(0, -15, BigRock.class);   //detect object at offset to shuttle
        if(rock != null) 
        {
            getWorld().removeObject(rock);
        }
    }

    /**-------------------------------------- Explode ----------------------------------------
     * This method creates a new explosion 
     */ 
    public void Explode()
    {
        EXP1 = new Explosion1();        // new explosion1 object
        getWorld().addObject(EXP1,getX(),getY());    //add object to world at position
    }

    /**-------------------------------------- Destroy Ship ----------------------------------------
     *This method creates a new explosion and destroys all that touches it
     */
    public void DestroyShip()
    {
        EXP = new Explosion();  // new explosion object
        getWorld().addObject(EXP,getX(),getY());      //add object to world at position
    }

    /**-------------------------------------- Set Flag ----------------------------------------
     * This method creates a new Flag and displays it on the moon
     */  
    public void SetFlag()
    {
        F1 = new Flag();       //new flag object
        getWorld().addObject(F1,450,50);       //add new object at location

    }

    /**--------------------------------------Welcome Home ----------------------------------------
     * This method creates a new welcome home sign and displays it
     */ 
    public void WelcomeHome()
    {
        H1 = new Home();       //new welcome home sign
        getWorld().addObject(H1,550,750);  //add new object to world at location
    }

    /**------------------------------------- Act -------------------------------------------------
     * This metod act controls the overall movement of your ship for every 1 grid location you move
     * Act - do whatever the shuttle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /**-------------------------------Trip to Moon ------------------------------------------
         * The first part of this code is for setting the direction of the movements
         *on the way to the moon.  There is different code to control the return trip
         */
        int Tx= getX();
        int Ty=getY();
        if(Fuel <=0)        //check to see if you are out of fuel
        {
            OOF = new OutofFuel();  //new out of fuel object
            getWorld().addObject(OOF,getX(),getY());    //add object to world at position 
        }
        if(returntrip == false)     //Checks to see if you have already been to the Moon
        {
            if (Tx==400 && Ty==350)     
            //must locate point X = 400 & y = 350 and change direction
            //remember you hit this point 2 times, once on the way to the space station and once on the way to the Moon
            //you have to take this into account.
            {
                spot+=1;
                setDirection(EAST);

                move();          
                if (spot==2)
                {
                    setDirection(NORTH);
                    move();
                }

            }
            
            else if (FoundSpaceStation()&& sCount<=1)
            {
                Fuel =2500;     //reset the fuel to 2500 for continued trip to the moon
                FCounter.Reset(Fuel);
                setDirection(WEST);
                sCount++;
                move();
            }

            /**  Your code that goes here must detect the objects and conduct the movements or take the action
             * required of your Shuttle at this point of the initial trip
             * 
             * This is the largest area of code you will enter.
             * 
             * My code below is there to destroy your ship if you do not detect the objects an hit them.  This code must 
             * stay and you can add yours above it.
             * 
             * The code you must enter here are all of the else if statements to determine what is in your path and what to 
             * what to do about it.  So things like:
             * 
             * else if(FoundMoonLanding())
             * {
             *     Your code goes here!
             * }
             * 
             * Follow the examples in the labs if you get stuck!!
             *
             *FoundSpaceStation() for this part will reset your fuel to 2500 for the trip to the Moon.
             */

            //----------------------------This code must stay to destroy your ship if needed---------------
            

          

            else if (FoundEarth())
            {       
                DestroyShip();    //call to destroy your ship you hit something              
            }
            
             else if(manouverCentre == true)     //Centre rock manouvers code Part 1 from Lab 4 with different directions and points
            {                                   //pay very close attention to this, this is where the differences are!
                int x = getX();  //sets points for next turn
                int y = getY();

                if (CentreTurnX+170 == x && CentreTurnY ==y)     //checks for next turn
                {
                    setDirection(NORTH);
                    move();
                }

                else if(CentreTurnX+170 == x && CentreTurnY-65 == y) //checks for next turn
                {
                    setDirection(WEST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY-65 == y))    //checks for next turn
                {
                    setDirection(NORTH);
                    manouverCentre = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }

            /** You will need to remove the comments on the following code before use!
             * 
             */ 

            else if(manouverRight == true)      //Right rock manouvers
            {
                int x = getX();      //gets points for manouvering around rocks
                int y = getY();

                if (CentreTurnX-90 == x && CentreTurnY ==y)     //locates next turning point in manouver
                {
                    setDirection(NORTH);
                    move();
                }

                else if(CentreTurnX-90 == x && CentreTurnY-65 == y)     //locates next turning point in manouver
                {
                    setDirection(EAST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY-65 == y))    //locates next turning point in manouver
                {
                    setDirection(NORTH);
                    manouverRight = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }

            else if(manouverLeft == true)       //Left rock manouvers
            {
                int x = getX();      //gets points for manouvering around rocks
                int y = getY();

                if (CentreTurnX+90 == x && CentreTurnY ==y)     //locates next turning point in manouver
                {
                    setDirection(NORTH);
                    move();
                }

                else if(CentreTurnX+90 == x && CentreTurnY-65 == y)     //locates next turning point in manouver
                {
                    setDirection(WEST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY-65 == y))    //locates next turning point in manouver
                {
                    setDirection(NORTH);
                    manouverLeft = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }
            else if (FoundRockRight())      //checks for finding the RockRight
            {
                manouverRight = true;      //start of manouver
                setDirection(WEST);
                CentreTurnX = getX();       //gets turning original point for location in space
                CentreTurnY = getY();
                move();
            }
              else if(FoundMoonLanding())
            {
                SetFlag();               
                setDirection(SOUTH);
                returntrip=true;
                move();
            }
            
            else if (FoundRockLeft())  //checks for finding the RockLeft
            {
                manouverLeft = true;      //start of manouver
                setDirection(EAST);
                CentreTurnX = getX();       //gets turning original point for location in space
                CentreTurnY = getY();
                move();
            }

            else if (FoundRockCentre())  //checks for finding the RockCentre  code Part 2 from Lab 4!
            {
                manouverCentre = true;      //stat of manouver
                setDirection(EAST);
                CentreTurnX = getX();       //gets starting points of the inital turn
                CentreTurnY = getY();
                move();
            }

            else if (FoundBigRock())
            {       
                Destroy();    //call to destroy your ship you hit something              
            }

             

           

            // /** You will need to remove the comments on the following code before use!
             // * 
             // */ 

        

            else if(canMove()) 
            {
                move();
            }
            else 
            {
                turn();
                move();
            }

        }

        /**----------------------------------Return Trip back to Earth -----------------------
         * The following code controls the movement of your ship for the return trip to Earth
         * Notice that some of the directions of motion have changed from the first part
         */

        else if(returntrip == true)  //Checks to see if you have already been to the Moon
        {
             
            if (Tx==400 && Ty==350)     
            //must locate point X = 400 & y = 350 and change direction
            //remember you hit this point 2 times, once on the way to the space station and once on the way to the Moon
            //you have to take this into account.
            {
                rspot+=1;
                setDirection(EAST);  
                move();          
                if (rspot>1)
                {
                    setDirection(SOUTH);
                    move();
                }

            }
            
             else if (FoundSpaceStation() && sCount>=1)
            {
                Fuel =1500;     //reset the fuel to 1500 for continued trip back to the earth
                FCounter.Reset(Fuel);
                setDirection(WEST);
                move();
            }
           

            /**  Your code that goes here must detect the objects and conduct the movements or take the action
             * required of your Shuttle at this point of the return trip
             * 
             * Again This is the largest area of code you will enter.
             * 
             * My code below is there to destroy your ship if you do not detect the objects an hit them.  This code must 
             * stay and you can add yours above it.
             * 
             * The code you must enter here are all of the else if statements to determine what is in your path and what to 
             * what to do about it.  So things like:
             * 
             * else if(FoundEarthLanding())
             * {
             *     Your code goes here!
             * }
             * 
             * Follow the examples in the labs if you get stuck!!
             * 
             * FoundSpaceStation() for this part will reset your fuel to 1500 for the trip home.
             */

            

            else if(FoundEarthLanding())
            {
                WelcomeHome();
                setDirection(NORTH);
            }
            
            else if(RmanouverCentre == true)     //Centre rock manouvers code Part 1 from Lab 4 with different directions and points
            {                                   //pay very close attention to this, this is where the differences are!
                int x = getX();  //sets points for next turn
                int y = getY();

                if (CentreTurnX+170 == x && CentreTurnY ==y)     //checks for next turn
                {
                    setDirection(SOUTH);
                    move();
                }

                else if(CentreTurnX+170 == x && CentreTurnY+65 == y) //checks for next turn
                {
                    setDirection(WEST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY+65 == y))    //checks for next turn
                {
                    setDirection(SOUTH);
                    RmanouverCentre = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }
            /** You will need to remove the comments on the following code before use!
             * 
             */ 

            else if(RmanouverRight == true)      //Right rock manouvers
            {
                int x = getX();      //gets points for manouvering around rocks
                int y = getY();

                if (CentreTurnX-90 == x && CentreTurnY ==y)     //locates next turning point in manouver
                {
                    setDirection(SOUTH);
                    move();
                }

                else if(CentreTurnX-90 == x && CentreTurnY+65 == y)     //locates next turning point in manouver
                {
                    setDirection(EAST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY+65 == y))    //locates next turning point in manouver
                {
                    setDirection(SOUTH);
                    RmanouverRight = false;      //end of manouver
                    move();
                }
                else
                {
                    move();
                }
            }

            else if(RmanouverLeft == true)       //Left rock manouvers
            {
                int x = getX();      //gets points for manouvering around rocks
                int y = getY();

                if (CentreTurnX+90 == x && CentreTurnY ==y)     //locates next turning point in manouver
                {
                    setDirection(SOUTH);
                    move();
                }

                else if(CentreTurnX+90 == x && CentreTurnY+65 == y)     //locates next turning point in manouver
                {
                    setDirection(WEST);
                    move();
                }

                else if((CentreTurnX==x) &&(CentreTurnY+65 == y))    //locates next turning point in manouver
                {
                    setDirection(SOUTH);
                    RmanouverLeft = false;      //end of manouver
                    move();
                }

            }
            else if (FoundRockRightreturn())
            {       
                RmanouverRight = true;      //start of manouver
                setDirection(WEST);
                CentreTurnX = getX();       //gets turning original point for location in space
                CentreTurnY = getY();
                move();         
            }
            else if (FoundRockLeftreturn())
            {       

                RmanouverLeft = true;      //start of manouver
                setDirection(EAST);
                CentreTurnX = getX();       //gets turning original point for location in space
                CentreTurnY = getY();
                move();         
            }
            else if (FoundRockCentrereturn())
            {       
                RmanouverCentre = true;      //stat of manouver
                setDirection(EAST);
                CentreTurnX = getX();       //gets starting points of the inital turn
                CentreTurnY = getY();
                move();        
            }
                               
           //----------------------------This code must stay to destroy your ship if needed---------------
             else if (FoundMoon())
            {       
                 DestroyShip();     //call to destroy your ship you hit something            
             }       
            else if (FoundEarth())
            {       
                DestroyShip();       //call to destroy your ship you hit something          
            }
            //----------------------------This code must stay to destroy your ship if needed---------------
            // else if (FoundRockRightreturn())
            // {       
                // DestroyShip();     //call to destroy your ship you hit something            
            // }       
             // else if (FoundRockLeftreturn())
            // {       
                // DestroyShip();     //call to destroy your ship you hit something            
            // }
             // else if (FoundRockCentrereturn())
            // {       
                // DestroyShip();     //call to destroy your ship you hit something            
            // }
            else if (FoundBigRock())
            {       
                Destroy();       //call to destroy your ship you hit something          
            } 
            

            
            else if(canMove()) 
            {
                move();
            }
            else 
            {
                turn();
                move();
            }

        } 

    }

    /**-------------------------------- Turn ------------------------------
     * This method you can use to control your ships direction at any point
     */ 
    public void turn()
    {
        switch(direction) {
            case SOUTH :
            setDirection(EAST);
            break;
            case EAST :
            setDirection(SOUTH);
            break;
            case NORTH :
            setDirection(EAST);
            break;
            case WEST :
            setDirection(NORTH);
            break;
        }
    }

    /**------------------------------------- Move ------------------------------------
     * This method keeps track of your fuel for every movement
     * This method also moves your ship 1 place on th grid
     */
    public void move()
    {
        Fuel --;        //decrement of fuel variable
        FuelDec();      //call for decrement of fuel counter
        switch(direction) 
        {
            case SOUTH :
            setLocation(getX(), getY() + 1);
            break;
            case EAST :
            setLocation(getX() + 1, getY());
            break;
            case NORTH :
            setLocation(getX(), getY() - 1);
            break;
            case WEST :
            setLocation(getX() - 1, getY());
            break;

        }
    }

}//end of class
