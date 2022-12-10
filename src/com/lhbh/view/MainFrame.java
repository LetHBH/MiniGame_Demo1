package com.lhbh.view;

import com.lhbh.service.ScoreRecorder;
import com.lhbh.service.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    public MainFrame(){
        restart();
        setBounds(340,150,820,260);
        setTitle("Coolgle 小恐龙");
        Sound.background();
        ScoreRecorder.init();
        addListener();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void restart(){
        Container c=getContentPane();
        System.out.println(c);
        c.removeAll();
        GamePanel panel=new GamePanel();
        c.add(panel);
        addKeyListener(panel);
        c.validate();
    }
    private void addListener(){
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                ScoreRecorder.save();
            }
        });
    }
}
