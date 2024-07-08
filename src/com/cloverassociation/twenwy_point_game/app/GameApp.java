package com.cloverassociation.twenwy_point_game.app;

import com.cloverassociation.twenwy_point_game.main.GameFrame;
import com.cloverassociation.twenwy_point_game.util.music.BkMusic;

import java.util.concurrent.TimeUnit;

import static com.cloverassociation.twenwy_point_game.util.music.BkMusic.BGM;


public class GameApp {

    public static void main(String[] args) {
        BkMusic.playMusic(BGM);
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new GameFrame() {
        };
    }
}