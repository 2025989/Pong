import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Beeper extends MoveUp {
    
    public static int hp;
    public static int score;
    public static int highScore;
    
    public void act() {
        if (!isGameOver) {
            //beweeg
            movement();
            
            //pak hartjes
            checkHeart();
            
            //ga dood
            checkDeath();
        }
    }
    
    protected void movement() {
        //beweeg naar boven
        moveUp();
        
        //val naar beneden als je niet op een Platform staat
        if (getOneObjectAtOffset(0, 10, Platform.class) == null) {
            setLocation(getX(), getY()+speed*3);
            score++;
        }
        
        //beweeg naar links en naar rechts
        if (Greenfoot.isKeyDown("left") && getX() > 15) {move(-speed*2);}
        if (Greenfoot.isKeyDown("right") && getX() < getWorld().getWidth()-15) {move(speed*2);}
        
        //als je tegen de zijkant van een Platform aan komt, drijf naar de bovenkant
        while (getOneObjectAtOffset(0, 0, Platform.class) != null) {
            setLocation(getX(), getY()-1);
        }
    }
    
    public void checkDeath() {
        //als je een Spike aanraakt of uit de wereld valt, ga je dood
        if (getY() > getWorld().getHeight()
        || getY() < 34
        || getOneObjectAtOffset(0, 10, Spike.class) != null) {
            hp--;
            
            //respawn op een platform...
            if (getWorld().getObjects(Platform.class).size() >= 2) {
                Platform platform = getWorld().getObjects(Platform.class).get(getWorld().getObjects(Platform.class).size()-1);
                getWorld().addObject(new Beeper(), platform.getX()-25+Greenfoot.getRandomNumber(50), platform.getY()-20);
            }
            //... of in de lucht als er geen platform gevonden is
            else {
                getWorld().addObject(new Beeper(), 150, 150);
            }
            getWorld().removeObject(this);
        }
    }
    
    public void checkHeart() {
        Heart heart = getOneObjectAtOffset(0, 0, Heart.class);
        
        //als je een hartje pakt, krijg je levens erbij
        if (heart != null) {
            if (hp < 10) {hp++;}
            getWorld().removeObject(heart);
        }
    }
    
}