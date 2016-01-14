import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class ScoreHealth extends TextToImage {
    
    private GreenfootImage image = new GreenfootImage(300, 26);
    
    public ScoreHealth() {
        //reset statische variabelen
        MoveUp.speed = 1;
        MoveUp.isGameOver = false;
        Beeper.hp = 10;
        Beeper.score = 0;
        
        //teken score en levens
        drawText();
    }
    
    public void act() {
        //update score en levens
        drawText();
        
        //als Beeper dood is, spawn GameOver
        if (Beeper.hp <= 0 && !MoveUp.isGameOver) {
            getWorld().addObject(new GameOver(), 150, getWorld().getHeight()/2+20);
            MoveUp.isGameOver = true;
        }
    }
    
    public void drawText() {
        //teken achtergrond
        image.setColor(new Color(50, 75, 75));
        image.fillRect(0, 0, 300, 26);
        
        //teken levens
        image.setColor(new Color(100, 200, 100));
        for (int i = 0; i < Beeper.hp; i++) {
            image.fillRect(8+17*i, 4, 15, 16);
        }
        
        //teken score
        image.setFont(new Font("Arial", Font.BOLD, 16));
        String text = String.format("%010d", Beeper.score);
        Dimension dim = getTextDimensions(image, text);
        image.setColor(new Color(75, 255, 255));
        image.drawString(text, 201, dim.height-1);
        
        //maak plaatje
        setImage(image);
    }
    
}