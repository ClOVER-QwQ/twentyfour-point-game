package com.cloverassociation.twenwy_point_game.main;

import com.cloverassociation.twenwy_point_game.util.music.BkMusic;
import com.cloverassociation.twenwy_point_game.util.music.ButtonMusic;
import com.cloverassociation.twenwy_point_game.util.music.FailMusic;
import com.cloverassociation.twenwy_point_game.util.music.WinMusic;

import javax.swing.*;

import static com.cloverassociation.twenwy_point_game.util.Constant.*;

public class Setting extends JFrame{
    public Setting() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);

        JButton setbkmusic = new JButton("背景音乐：开");
        setbkmusic.setBounds(135,150, 200, 30);
        setbkmusic.setVisible(true);
        setbkmusic.setFocusPainted(false);

        JButton seteffectsmusic = new JButton("音效：开");
        seteffectsmusic.setBounds(135,200, 200, 30);
        seteffectsmusic.setVisible(true);
        seteffectsmusic.setFocusPainted(false);

        contentPanel.add(setbkmusic);
        contentPanel.add(seteffectsmusic);

        ImageIcon background = new ImageIcon("img/about.png");
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(-6, 0, FRAM_WIDTH, FRAM_HIGHT);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        contentPanel.add(label);

        JFrame setting = new JFrame();
        setting.setContentPane(contentPanel);
        setting.setVisible(true);
        setting.setSize(500, 400);
        setting.setTitle(FRAM_TITLE);
        setting.setLocation(425, 200);
        setting.setResizable(true);
        setting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setbkmusic.addActionListener(e -> {
            ButtonMusic.playMusic(ButtonMusic.PATH);
            if(BkMusic.music.isRunning()){
                BkMusic.closeMusic();
                setbkmusic.setText("背景音乐：关");
            }
            else {
                BkMusic.music.start();
                setbkmusic.setText("背景音乐：开");
            }
        });

        seteffectsmusic.addActionListener(e -> {
            if(ButtonMusic.flag){
                ButtonMusic.flag = false;
                WinMusic.flag = false;
                FailMusic.flag = false;
                seteffectsmusic.setText("音效：关");
            }
            else{
                ButtonMusic.flag = true;
                WinMusic.flag = true;
                FailMusic.flag = true;
                seteffectsmusic.setText("音效：开");
            }
        });
    }
}
