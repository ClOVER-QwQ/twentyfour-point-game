package com.cloverassociation.twenwy_point_game.main;

import com.cloverassociation.twenwy_point_game.util.Constant;
import com.cloverassociation.twenwy_point_game.util.music.ButtonMusic;

import javax.swing.*;
import java.awt.*;

import static com.cloverassociation.twenwy_point_game.util.Constant.FRAM_TITLE;
import static com.cloverassociation.twenwy_point_game.util.Constant.score;

public class ScoreFrame {
    public ScoreFrame() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);

        JLabel l1 = new JLabel("得分："+ Constant.score);
        l1.setBounds(75, -20, 400, 100);
        Font font1 = new Font("黑体", Font.PLAIN, 40);
        l1.setFont(font1);

        JButton bkdifficulty = new JButton("返回难度菜单");
        bkdifficulty.setForeground(Color.white);
        bkdifficulty.setVerticalTextPosition(SwingConstants.CENTER);
        bkdifficulty.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageIcon icon2 = new ImageIcon("img/button.png");
        //替换为你的图标路径
        Image img2 = icon2.getImage();
        Image newImg2 = img2.getScaledInstance(150, 30, java.awt.Image.SCALE_SMOOTH); // 调整图标大小以适应按钮
        Icon newIcon2 = new ImageIcon(newImg2);
        bkdifficulty.setIcon(newIcon2);
        bkdifficulty.setContentAreaFilled(false);
        bkdifficulty.setBorderPainted(false);
        bkdifficulty.setFocusPainted(false);
        bkdifficulty.setFocusPainted(false);
        bkdifficulty.setBounds(100, 100, 150, 30);

        Font font = new Font("黑体", Font.PLAIN, 40);
        JTextField input = new JTextField();
        input.setBounds(100, 50, 200, 30);
        input.setFont(font);

        contentPanel.add(l1);
        contentPanel.add(bkdifficulty);
        contentPanel.add(input);

        ImageIcon background = new ImageIcon("img/win.png");
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(0, 0, 400, 200);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        contentPanel.add(label);

        JFrame scorefram = new JFrame();
        scorefram.setContentPane(contentPanel);
        scorefram.setVisible(true);
        scorefram.setSize(400, 200);
        scorefram.setTitle(FRAM_TITLE);
        scorefram.setLocation(425, 200);
        scorefram.setResizable(false);
        scorefram.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        bkdifficulty.addActionListener(e -> {
            GameRankingFramework.addPlayer(input.getText(), score);
            ButtonMusic.playMusic(ButtonMusic.PATH);
            new DifficultyFrame();
            scorefram.dispose();
            Constant.score = 0;
        });
    }
}
