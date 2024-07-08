package com.cloverassociation.twenwy_point_game.util.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BkMusic {
    public static final String BGM = "wav/bkmusic.wav";//bgm文件路径
    public static Clip music = null; //声明Clip接口
    static File sourceFile = null; //声明文件变量

    /**
     * 音乐播放方法
     */
    public static void playMusic(String path) {
        try {
            music = AudioSystem.getClip(); // 获取可用于播放音频文件或音频流的数据流
            sourceFile = new File(path);//获取文件
            if(sourceFile.exists()){
            AudioInputStream ais = AudioSystem.getAudioInputStream(sourceFile);//获得指示格式的音频输入流
            music.open(ais); //打开数据流
            music.start();    //开始播放音乐
            music.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭音乐
     */
    public static void closeMusic() {
        if (music != null)    //需要判断music是否为null，避免出现空指针异常
            music.stop();//暂停音乐
    }

}
