package com.lhbh.service;

import com.lhbh.view.GamePanel;
import com.lhbh.view.MainFrame;
import com.lhbh.view.ScoreDialog;
import sun.applet.Main;

import java.awt.*;

public class FreshThread extends Thread{
    public static final int FREASH=20;
    GamePanel p;

    public FreshThread(GamePanel p){
        this.p=p;
    }
    @Override
    public void run(){
        while (!p.isFinish()){
            p.repaint();
            try{
                Thread.sleep(FREASH);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Container c =p.getParent();
            while (!(c instanceof MainFrame)){
                c = c.getParent;
            }
            MainFrame frame=(MainFrame)c;
            new ScoreDialog(frame);
            frame.restart();
        }
    }
}
