package com.lhbh.modle;

import com.lhbh.view.BackgroundImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Obstacle {
    public int x,y;
    private int speed;
    public BufferedImage image;
    private BufferedImage stone;
    private BufferedImage cacti;

    public Obstacle(){
        try{
            stone = ImageIO.read(new File("image/stone.png"));
            cacti = ImageIO.read(new File("image/cs.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

        //随机生成障碍
        Random r = new Random();
        if(r.nextInt(2) == 0){
            image = cacti;
        }else{
            image = stone;
        }

        x = 800;
        y = 200- image.getHeight();
        speed = BackgroundImage.SPEED;
    }

    public void move(){
        x -= speed;
    }
    public boolean isLive(){
        if(x <= -image.getWidth()){
            return false;
        }
        return true;
    }
    public Rectangle getBounds(){
        if(image == cacti){
            return new Rectangle(x+7,y,15,image.getHeight());
        }
        return new Rectangle(x+5,y+4,23,21);
    }
}
