package com.cloverassociation.twenwy_point_game.util.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ButtonMusic {
    public static final String PATH = "wav/button.wav";//bgm文件路径
    public static Clip music = null; //声明Clip接口
    public static boolean flag = true;
    static File sourceFile = null; //声明文件变量

    /**
     * 音乐播放方法
     */
    public static void playMusic(String path) {
        if(ButtonMusic.flag) {
            try {
                music = AudioSystem.getClip(); // 获取可用于播放音频文件或音频流的数据流
                sourceFile = new File(path);//获取文件
                AudioInputStream ais = AudioSystem.getAudioInputStream(sourceFile);//获得指示格式的音频输入流
                music.open(ais); //打开数据流
                music.start();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
        }
        }

}
