package com.cloverassociation.twenwy_point_game.main;

import javax.swing.*;
import java.awt.*;

import static com.cloverassociation.twenwy_point_game.util.Constant.*;

public class About {
    public About(){
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);

        JLabel l1 = new JLabel("<html><body>游戏规则；<br>&nbsp;&nbsp;&nbsp;&nbsp;将数字1-9通过合理的运算<br>&nbsp;&nbsp;&nbsp;&nbsp;可以使用括号(括号不可以用中文括号)和交换律<br>&nbsp;&nbsp;&nbsp;&nbsp;使给的四个数字的运输算结果是24<br>&nbsp;&nbsp;&nbsp;&nbsp;如果结果不是24，则输入NO<br>&nbsp;&nbsp;&nbsp;&nbsp;每次游戏一共有三轮，刷新不算论数增加。<br>游戏时间：<br>&nbsp;&nbsp;&nbsp;&nbsp;简单模式：90秒每题<br>&nbsp;&nbsp;&nbsp;&nbsp;中等模式：60秒每题<br>&nbsp;&nbsp;&nbsp;&nbsp;困难模式：30秒每题<br>开发者：四叶<br>四叶的小窝 qq群：677477238<br>v3.0<br>更新日志：1.对界面进行了美化和优化<br>2.修复了部分bug<br>3.中等，困难模式已经更新<body></html><body></html>");
        l1.setBounds(0,0,400,300);
        Font font1 = new Font("黑体",Font.PLAIN,15);
        l1.setFont(font1);

        contentPanel.add(l1);

        ImageIcon background = new ImageIcon("img/about.png");
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(-6, 0, FRAM_WIDTH, FRAM_HIGHT);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        contentPanel.add(label);

        JFrame about = new JFrame();
        about.setContentPane(contentPanel);
        about.setVisible(true);
        about.setSize(500,400);
        about.setTitle(FRAM_TITLE);
        about.setLocation(425,200);
        about.setResizable(true);
        about.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
