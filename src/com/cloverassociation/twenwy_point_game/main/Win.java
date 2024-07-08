package com.cloverassociation.twenwy_point_game.main;

import com.cloverassociation.twenwy_point_game.util.music.ButtonMusic;

import javax.swing.*;
import java.awt.*;

import static com.cloverassociation.twenwy_point_game.util.Constant.FRAM_TITLE;

public class Win extends JFrame {
    public Win() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);

        JLabel l1 = new JLabel("回答正确！！！");
        l1.setBounds(75, -20, 400, 100);
        Font font1 = new Font("黑体", Font.PLAIN, 40);
        l1.setFont(font1);

        JButton resume = new JButton("继续");
        resume.setForeground(Color.white);
        resume.setVerticalTextPosition(SwingConstants.CENTER);
        resume.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageIcon icon2 = new ImageIcon("img/button.png");
        //替换为你的图标路径
        Image img2 = icon2.getImage();
        Image newImg2 = img2.getScaledInstance(150, 30, java.awt.Image.SCALE_SMOOTH); // 调整图标大小以适应按钮
        Icon newIcon2 = new ImageIcon(newImg2);
        resume.setIcon(newIcon2);
        resume.setContentAreaFilled(false);
        resume.setBorderPainted(false);
        resume.setFocusPainted(false);
        resume.setFocusPainted(false);
        resume.setBounds(100, 100, 150, 30);

        contentPanel.add(l1);
        contentPanel.add(resume);

        ImageIcon background = new ImageIcon("img/win.png");
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(0, 0, 400, 200);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        contentPanel.add(label);

        JFrame win = new JFrame();
        win.setContentPane(contentPanel);
        win.setVisible(true);
        win.setSize(400, 200);
        win.setTitle(FRAM_TITLE);
        win.setLocation(425, 200);
        win.setResizable(false);
        win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        resume.addActionListener(e -> {
            win.dispose();
            new DifficultyFrame();
            ButtonMusic.playMusic(ButtonMusic.PATH);
        });
    }
}
