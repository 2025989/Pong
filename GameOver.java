import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class GameOver extends TextToImage {
    
    private GreenfootImage image = new GreenfootImage(200, 350);
    
    public GameOver() {
        //update high score
        if (Beeper.highScore < Beeper.score) {
            Beeper.highScore = Beeper.score;
        }
        
        //teken achtergrond
        image.setColor(new Color(50, 75, 75, 200));
        image.fillRect(0, 0, 200, 350);
        
        //tekst "GAME OVER"
        image.setFont(new Font("Arial", Font.BOLD, 26));
        String text1 = "GAME OVER";
        Dimension dim1 = getTextDimensions(image, text1);
        image.setColor(new Color(75, 255, 255));
        image.drawString(text1, image.getWidth()/2-(int)(dim1.getWidth()/2), image.getHeight()/2-100);
        
        //tekst "Score: " ...
        image.setFont(new Font("Arial", Font.BOLD, 26));
        String text2 = "Score: "+ Beeper.score;
        Dimension dim2 = getTextDimensions(image, text2);
        image.setColor(new Color(100, 200, 100));
        image.drawString(text2, image.getWidth()/2-(int)(dim2.getWidth()/2), image.getHeight()/2-25);
        
        //tekst "High Score: " ...
        image.setFont(new Font("Arial", Font.BOLD, 14));
        String text3 = "High Score: "+ Beeper.highScore;
        Dimension dim3 = getTextDimensions(image, text3);
        image.setColor(new Color(200, 200, 50));
        image.drawString(text3, image.getWidth()/2-(int)(dim3.getWidth()/2), image.getHeight()/2+35);
        
        //teken GameOver en stop het spel
        setImage(image);
        Greenfoot.stop();
    }
    
}