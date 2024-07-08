package com.cloverassociation.twenwy_point_game.main;

import com.cloverassociation.twenwy_point_game.util.Constant;
import com.cloverassociation.twenwy_point_game.util.music.ButtonMusic;

import javax.swing.*;
import java.awt.*;

import static com.cloverassociation.twenwy_point_game.util.Constant.*;

public class DifficultyFrame extends JFrame {
        public DifficultyFrame() {
        JPanel contentPanel = new JPanel();

        contentPanel.setLayout(null);



        JButton easy = new JButton("简  单");
        easy.setForeground(Color.white);
        easy.setVerticalTextPosition(SwingConstants.CENTER);
        easy.setHorizontalTextPosition(SwingConstants.CENTER);
        easy.setFont(new Font("黑体", Font.BOLD, 30));
        ImageIcon easyicon = new ImageIcon("img/button.png");
        easy.setIcon(easyicon);
        easy.setContentAreaFilled(false);
        easy.setBorderPainted(false);
        easy.setSize(200, 50);
        easy.setLocation(360,50);
        easy.setFocusPainted(false);
        easy.setVisible(true);

        JButton normal = new JButton("正  常");
        normal.setForeground(Color.white);
        normal.setVerticalTextPosition(SwingConstants.CENTER);
        normal.setHorizontalTextPosition(SwingConstants.CENTER);
        normal.setFont(new Font("黑体", Font.BOLD, 30));
        normal.setIcon(easyicon);
        normal.setContentAreaFilled(false);
        normal.setBorderPainted(false);
        normal.setBounds(360,200, 200, 50);
        normal.setFocusPainted(false);

        JButton hard = new JButton("困  难");
        hard.setForeground(Color.white);
        hard.setVerticalTextPosition(SwingConstants.CENTER);
        hard.setHorizontalTextPosition(SwingConstants.CENTER);
        hard.setFont(new Font("黑体", Font.BOLD, 30));
        hard.setIcon(easyicon);
        hard.setContentAreaFilled(false);
        hard.setBorderPainted(false);
        hard.setBounds(360,350, 200, 50);
        hard.setFocusPainted(false);

        JButton bkmain = new JButton("返回主菜单");
        bkmain.setForeground(Color.white);
        bkmain.setVerticalTextPosition(SwingConstants.CENTER);
        bkmain.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageIcon icon = new ImageIcon("img/button.png");
        // 替换为你的图标路径
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(100, 30, java.awt.Image.SCALE_SMOOTH); // 调整图标大小以适应按钮
        Icon newIcon = new ImageIcon(newImg);
        bkmain.setIcon(newIcon);
        bkmain.setContentAreaFilled(false);
        bkmain.setBorderPainted(false);
        bkmain.setFocusPainted(false);
        bkmain.setBounds(750,400,100,30);

        contentPanel.add(easy);
        contentPanel.add(normal);
        contentPanel.add(hard);
        contentPanel.add(bkmain);

        ImageIcon background = new ImageIcon("img/difficulty.png");
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(-6, 0, FRAM_WIDTH, FRAM_HIGHT);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        contentPanel.add(label);

        JFrame DifficultyFrame = new JFrame();

        DifficultyFrame.setLayout(null);

        DifficultyFrame.setVisible(true);

        DifficultyFrame.setSize(FRAM_WIDTH, FRAM_HIGHT);

        DifficultyFrame.setTitle(FRAM_TITLE);

        DifficultyFrame.setLocation(FRAM_X, FRAM_Y);

        DifficultyFrame.setResizable(false);

        DifficultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DifficultyFrame.setContentPane(contentPanel);

        bkmain.addActionListener(e -> {
                ButtonMusic.playMusic(ButtonMusic.PATH);
                new GameFrame(){
                };
                DifficultyFrame.dispose();
                Constant.count = 0;
        });

        easy.addActionListener(e -> {
                ButtonMusic.playMusic(ButtonMusic.PATH);
                new Easy(){
                };
                DifficultyFrame.dispose();
        });

        normal.addActionListener(e -> {
                ButtonMusic.playMusic(ButtonMusic.PATH);
                new Normal();
                DifficultyFrame.dispose();
        });

        hard.addActionListener(e -> {
                ButtonMusic.playMusic(ButtonMusic.PATH);
                new Hard();
                DifficultyFrame.dispose();
        });
        }
}
