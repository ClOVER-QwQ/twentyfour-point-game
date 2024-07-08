package com.cloverassociation.twenwy_point_game.main;

import javax.swing.*;
import java.awt.*;

import static com.cloverassociation.twenwy_point_game.util.Constant.FRAM_TITLE;

public class Error {
    public Error(){
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);

        JLabel l1 = new JLabel("<html>系统出现错误，也许是表达式输入有问题，或者使用了中文括号。如果有其他问题请及时反馈。</html>");
        l1.setBounds(0,-20,380,180);
        Font font1 = new Font("黑体",Font.PLAIN,20);
        l1.setFont(font1);

        contentPanel.add(l1);
        ImageIcon background = new ImageIcon("img/other.png");
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(0, 0, 400, 200);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        contentPanel.add(label);

        JFrame error = new JFrame();
        error.setContentPane(contentPanel);
        error.setVisible(true);
        error.setSize(390,200);
        error.setTitle(FRAM_TITLE);
        error.setLocation(425,200);
        error.setResizable(false);
        error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
