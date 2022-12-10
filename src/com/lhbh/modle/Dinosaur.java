package com.lhbh.modle;

import com.lhbh.service.FreshThread;
import com.lhbh.service.Sound;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dinosaur {
    public BufferedImage image;
    private BufferedImage img1,img2,img3;
    public int x,y;
    private int jumpValue = 0;
    private boolean jumpState = false;
    private int stepTimer = 0;
    private final int JumpH = 100;
    private final int land_Y = 120;
    private final int FREASH = FreshThread.FREASH;

    public Dinosaur() {
        x = 50;
        y = land_Y;
        try {
            img1 = ImageIO.read(new File("image/img1.png"));
            img2 = ImageIO.read(new File("image/img2.png"));
            img3 = ImageIO.read(new File("image/img3.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void step(){
        int tmp = stepTimer / 250 %3;
        switch (tmp){
            case 1 :
                image = img1;
                break;
            case 2 :
                image =img2;
                break;
            default:
                image = img3;
        }
        stepTimer+=FREASH;
    }
    public void jump(){
        if(jumpState){
            Sound.jump();
        }
        jumpState = true;
    }
    public void move(){
        step();
        if(jumpState){
            if(y >= land_Y){
                jumpValue = -4;
            }
            if(y <= land_Y){
                jumpValue = 4;
            }
            y += jumpValue;
            if(y >= land_Y){
                jumpState=false;
            }
        }

    }
    public Rectangle getFoot(){
        return new Rectangle(x+30 , y+59 , 29 ,18);
    }
    public Rectangle getHead(){
        return new Rectangle(x+66 , y+25 , 32 ,22);
    }
}
