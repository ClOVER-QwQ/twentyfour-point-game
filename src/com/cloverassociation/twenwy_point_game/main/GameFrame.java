package com.cloverassociation.twenwy_point_game.main;

import com.cloverassociation.twenwy_point_game.util.music.ButtonMusic;

import javax.swing.*;
import java.awt.*;

import static com.cloverassociation.twenwy_point_game.util.Constant.*;


public class GameFrame extends JFrame {
    public GameFrame() {

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);

        JButton difficulty = new JButton("开  始  游  戏");
        difficulty.setForeground(Color.white);
        difficulty.setVerticalTextPosition(SwingConstants.CENTER);
        difficulty.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageIcon diffultyicon = new ImageIcon("img/button.png");
        // 替换为你的图标路径
        Image img = diffultyicon.getImage();
        Image newImg = img.getScaledInstance(200, 30, java.awt.Image.SCALE_SMOOTH); // 调整图标大小以适应按钮
        Icon newIcon = new ImageIcon(newImg);
        difficulty.setIcon(newIcon);
        difficulty.setContentAreaFilled(false);
        difficulty.setBorderPainted(false);
        difficulty.setBounds(350, 200, 200, 30);
        difficulty.setVisible(true);
        difficulty.setFocusPainted(false);

        JButton setting = new JButton("设  置");
        setting.setForeground(Color.white);
        setting.setVerticalTextPosition(SwingConstants.CENTER);
        setting.setHorizontalTextPosition(SwingConstants.CENTER);
        setting.setIcon(newIcon);
        setting.setContentAreaFilled(false);
        setting.setBorderPainted(false);
        setting.setBounds(350,300, 200, 30);
        setting.setVisible(true);
        setting.setFocusPainted(false);

        JButton about = new JButton("关于");
        about.setForeground(Color.white);
        about.setVerticalTextPosition(SwingConstants.CENTER);
        about.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageIcon icon3 = new ImageIcon("img/button.png");
        // 替换为你的图标路径
        Image img3 = icon3.getImage();
        Image newImg3 = img3.getScaledInstance(60, 30, java.awt.Image.SCALE_SMOOTH); // 调整图标大小以适应按钮
        Icon newIcon3 = new ImageIcon(newImg3);
        about.setIcon(newIcon3);
        about.setContentAreaFilled(false);
        about.setBorderPainted(false);
        about.setFocusPainted(false);
        about.setBounds(20,430,60,30);

        JButton exit = new JButton("退  出  游  戏");
        exit.setForeground(Color.white);
        exit.setVerticalTextPosition(SwingConstants.CENTER);
        exit.setHorizontalTextPosition(SwingConstants.CENTER);
        exit.setIcon(newIcon);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.setBounds(350,350, 200, 30);
        exit.setVisible(true);
        exit.setFocusPainted(false);

        JButton rank = new JButton("排  行  榜");
        rank.setForeground(Color.white);
        rank.setVerticalTextPosition(SwingConstants.CENTER);
        rank.setHorizontalTextPosition(SwingConstants.CENTER);
        rank.setIcon(newIcon);
        rank.setContentAreaFilled(false);
        rank.setBorderPainted(false);
        rank.setFocusPainted(false);
        rank.setBounds(350,250, 200, 30);
        rank.setVisible(true);
        rank.setFocusPainted(false);

        contentPanel.add(setting);
        contentPanel.add(difficulty);
        contentPanel.add(about);
        contentPanel.add(exit);
        contentPanel.add(rank);

        ImageIcon background = new ImageIcon("img/background.png");
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(-6, 0,900, 500);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        contentPanel.add(label);

        JFrame GameFrame = new JFrame(FRAM_TITLE);
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameFrame.setSize(FRAM_WIDTH, FRAM_HIGHT);
        GameFrame.setLocation(FRAM_X, FRAM_Y);
        GameFrame.setResizable(false);
        GameFrame.setVisible(true);
        GameFrame.setContentPane(contentPanel);

        difficulty.addActionListener(e -> {
            new DifficultyFrame();
            GameFrame.dispose();
            ButtonMusic.playMusic(ButtonMusic.PATH);
        });

        setting.addActionListener(e -> {
            new Setting();
            ButtonMusic.playMusic(ButtonMusic.PATH);
        });

        about.addActionListener(e -> {
            new About() {
            };
            ButtonMusic.playMusic(ButtonMusic.PATH);
        });

        exit.addActionListener(e -> System.exit(0));

        rank.addActionListener(e -> {
            new GameRankingFramework();
            GameFrame.dispose();
        });
    }
}
