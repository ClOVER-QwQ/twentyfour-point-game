package com.cloverassociation.twenwy_point_game.main;

import javax.swing.*;
import java.awt.*;

import static com.cloverassociation.twenwy_point_game.util.Constant.FRAM_TITLE;

public class Doing extends JFrame{
    public Doing() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setVisible(true);

        JLabel l1 = new JLabel("正在施工！！！");
        l1.setForeground(Color.green);
        Font font1 = new Font("黑体",Font.PLAIN,30);
        l1.setBounds(0,0,250,100);
        l1.setFont(font1);
        l1.setVisible(true);

        contentPanel.add(l1);

        ImageIcon background = new ImageIcon("img/doing.jpg");
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(0, 0,300, 150);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        contentPanel.add(label);

        JFrame doing = new JFrame();
        doing.setContentPane(contentPanel);
        doing.setVisible(true);
        doing.setSize(300, 150);
        doing.setTitle(FRAM_TITLE);
        doing.setLocation(425, 200);
        doing.setResizable(false);
        doing.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
