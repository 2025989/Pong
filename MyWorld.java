import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World {
    
    private GreenfootSound music = new GreenfootSound("STRUGGLES.mp3");
    int platformCounter = 1;
    int timer = 0;
    
    public MyWorld() {
        //maak een wereld van 300x650 waar objecten uit kunnen vallen
        super(300, 650, 1, false);
        populateTheWorld();
    }
    
    public void act() {
        //elke 50 frames komt er een Platform of een Spike bij
        if (timer%50 == 0) {
            platformCounter++;
            
            //elke 10 Platforms of Spikes gaat het spel sneller
            if (platformCounter%10 == 0) {
                MoveUp.speed++;
            }
            
            //10% kans op een Spike ipv een Platform
            if (Greenfoot.getRandomNumber(10) == 0) {
                addObject(new Spike(), 35+Greenfoot.getRandomNumber(230), getHeight()+25);
            }
            //90% kans op een Platform
            else {
                int platformX = 35+Greenfoot.getRandomNumber(230);
                if (Greenfoot.getRandomNumber(10) == 0) {
                    //10% kans op een Heart bovenop een Platform
                    addObject(new Heart(), platformX-25+Greenfoot.getRandomNumber(50), getHeight()+9);
                }
                addObject(new Platform(), platformX, getHeight()+25);
            }
        }
        
        //timer telt de frames
        timer++;
    }
    
    public void started() {
        //start muziek
        music.playLoop();
    }
    
    public void stopped() {
        //pauzeer muziek
        music.pause();
    }
    
    protected void populateTheWorld() {
        //spawn ScoreHealth en TopSpike bovenin
        addObject(new ScoreHealth(), getWidth()/2, 13);
        addObject(new TopSpike(), getWidth()/2, 26);
        
        //spawn Beeper bovenop een Platform
        int beeperX = 35+Greenfoot.getRandomNumber(230);
        addObject(new Beeper(), beeperX-25+Greenfoot.getRandomNumber(50), getHeight()-345);
        addObject(new Platform(), beeperX, getHeight()-325);
        
        //spawn nog een aantal Platforms
        for (int i = 0; i < 6; i++) {
            addObject(new Platform(), 35+Greenfoot.getRandomNumber(230), getHeight()-25-(50*i));
        }
        
        //zet de volgorde waarin de klassen getekend worden
        setPaintOrder(
            GameOver.class, ScoreHealth.class,
            Beeper.class, TopSpike.class,
            Platform.class, Spike.class
        );
    }
    
}