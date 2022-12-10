package com.lhbh.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MusicPlayer implements Runnable{
    File soundFile;
    Thread thread;
    boolean circulate;
    public MusicPlayer(String path,boolean circulate)
        throws FileNotFoundException{
    this.circulate = circulate;
    soundFile = new File(path);
    if(!soundFile.exists()){
        throw new FileNotFoundException(path+"未找到");
        }
    }
    @Override
    public void run(){
        byte[] auBuffer = new byte[1024*128];
        do{
            AudioInputStream audioInputStream = null;
            SourceDataLine auline = null;
            try{
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                AudioFormat format = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class,format);
                auline = (SourceDataLine)AudioSystem.getLine(info);
                auline.start();
                int byteCount = 0;
                while (byteCount != -1){
                    byteCount = audioInputStream.read(auBuffer,0,auBuffer.length);
                    if(byteCount >= 0){
                        auline.write(auBuffer,0,byteCount);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }catch (UnsupportedAudioFileException e){
                e.printStackTrace();
            }catch (LineUnavailableException e){
                e.printStackTrace();
            }finally {
                auline.drain();
                auline.close();
            }
        }while (circulate);
    }
    public void play(){
        thread = new Thread(this);
        thread.start();
    }
    public  void stop(){
        thread.stop();
    }
}

