package com.cloverassociation.twenwy_point_game.main;

import com.cloverassociation.twenwy_point_game.util.Constant;
import com.cloverassociation.twenwy_point_game.util.music.ButtonMusic;
import com.cloverassociation.twenwy_point_game.util.music.FailMusic;
import com.cloverassociation.twenwy_point_game.util.music.WinMusic;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static com.cloverassociation.twenwy_point_game.util.Constant.*;
import static com.cloverassociation.twenwy_point_game.util.algorithm.Caculator.getValue;
import static com.cloverassociation.twenwy_point_game.util.algorithm.Panduan.point24;

public class Easy extends JFrame {
    int timenum = 90;
    public Easy() {

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setVisible(true);

        Random r = new Random();
        int n1 = r.nextInt(1, 9);
        String num1 = Integer.toString(n1);

        JLabel number1 = new JLabel(num1);
        number1.setBounds(100, 100, 50, 60);
        Font font = new Font("黑体", Font.PLAIN, 70);
        number1.setFont(font);

        int n2 = r.nextInt(1, 9);
        String num2 = Integer.toString(n2);
        JLabel number2 = new JLabel(num2);
        number2.setBounds(300, 100, 50, 60);
        number2.setFont(font);

        int n3 = r.nextInt(1, 9);
        String num3 = Integer.toString(n3);
        JLabel number3 = new JLabel(num3);
        number3.setBounds(500, 100, 50, 60);
        number3.setFont(font);

        int n4 = r.nextInt(1, 9);
        String num4 = Integer.toString(n4);
        JLabel number4 = new JLabel(num4);
        number4.setBounds(700, 100, 50, 60);
        number4.setFont(font);

        JButton yes = new JButton("确 认");
        yes.setForeground(Color.white);
        yes.setFont(new Font("黑体", Font.BOLD, 20));
        yes.setVerticalTextPosition(SwingConstants.CENTER);
        yes.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageIcon diffultyicon = new ImageIcon("img/button.png");
        // 替换为你的图标路径
        Image img = diffultyicon.getImage();
        Image newImg = img.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH); // 调整图标大小以适应按钮
        Icon newIcon = new ImageIcon(newImg);
        yes.setIcon(newIcon);
        yes.setContentAreaFilled(false);
        yes.setBorderPainted(false);
        yes.setFocusPainted(false);
        yes.setBounds(400, 300, 100, 50);

        JButton reload = new JButton("刷新");
        reload.setForeground(Color.white);
        reload.setVerticalTextPosition(SwingConstants.CENTER);
        reload.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageIcon icon1 = new ImageIcon("img/button.png");
        //替换为你的图标路径
        Image img1 = icon1.getImage();
        Image newImg1 = img1.getScaledInstance(100, 30, java.awt.Image.SCALE_SMOOTH); // 调整图标大小以适应按钮
        Icon newIcon1 = new ImageIcon(newImg1);
        reload.setIcon(newIcon1);
        reload.setContentAreaFilled(false);
        reload.setBorderPainted(false);
        reload.setFocusPainted(false);
        reload.setBounds(750, 400, 100, 30);

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
        bkdifficulty.setBounds(10, 400, 150, 30);

        Font font1 = new Font("黑体", Font.PLAIN, 40);
        JTextField input = new JTextField();
        input.setBounds(200, 200, 500, 60);
        input.setFont(font1);

        JLabel time = new JLabel("时间：" + timenum);
        time.setBounds(700, 10, 150, 50);
        Font timefont = new Font("黑体", Font.PLAIN, 30);
        time.setFont(timefont);

        char c1 = (char)(48+n1);
        char c2 = (char)(48+n2);
        char c3 = (char)(48+n3);
        char c4 = (char)(48+n4);

        contentPanel.add(number1);
        contentPanel.add(number2);
        contentPanel.add(number3);
        contentPanel.add(number4);
        contentPanel.add(input);
        contentPanel.add(yes);
        contentPanel.add(reload);
        contentPanel.add(bkdifficulty);
        contentPanel.add(time);

        ImageIcon background = new ImageIcon("img/easybk.png");
        // 把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(-6, 0, FRAM_WIDTH, FRAM_HIGHT);
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel.setOpaque(false);
        // 把背景图片添加到分层窗格的最底层作为背景
        contentPanel.add(label);

        JFrame easy = new JFrame();
        easy.setLayout(null);
        easy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        easy.setTitle(FRAM_TITLE);
        easy.setSize(FRAM_WIDTH, FRAM_HIGHT);
        easy.setLocation(FRAM_X, FRAM_Y);
        easy.setResizable(false);
        easy.setVisible(true);
        easy.setContentPane(contentPanel);

        Timer timer = new Timer(1000, e -> {
            timenum--;
            time.setText("时间: " + timenum);
            if (timenum == 0) {
                ((Timer) e.getSource()).stop();
                Constant.count++;
                easy.dispose();
                new TimeFram();
            }
        });
        timer.start();

        reload.addActionListener(e -> {
            timer.stop();
            ButtonMusic.playMusic(ButtonMusic.PATH);
            easy.dispose();
            new Easy(){
            };
        });

        bkdifficulty.addActionListener(e -> {
            timer.stop();
            ButtonMusic.playMusic(ButtonMusic.PATH);
            new DifficultyFrame(){
            };
            easy.dispose();
        });

        yes.addActionListener(e -> {
            timer.stop();
            ButtonMusic.playMusic(ButtonMusic.PATH);
            String snum = input.getText();
            if(!(point24(n1,n2,n3,n4))&&snum.equals("NO")){
                easy.dispose();
                score++;
                Constant.count++;
                if(Constant.count !=3) {
                        new Win() {
                        };
                }
            }
            else {
                int length = snum.length();
                int count = 0;
                char[] other = snum.toCharArray();
                char[] rother = new char[]{c1, c2, c3, c4};
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (other[i] == rother[j]) {
                            count++;
                        }
                    }
                }
                boolean flag = true;
                if(!snum.equals("NO")) {
                    try {
                        getValue(snum);//可能出现异常的代码
                    } catch (Exception ex) {
                        new Error() {
                        };
                        flag = false;
                        ex.printStackTrace();
                    }
                }
                if ((count < 4 || length < 7) && flag&&!snum.equals("NO")) {
                    new Other() {
                    };
                } else if (getValue(snum) == 24) {
                    WinMusic.playMusic(WinMusic.PATH);
                    Constant.count++;
                    score++;
                    if(Constant.count !=3) {
                        new Win() {
                        };
                    }
                    easy.dispose();
                } else {
                    FailMusic.playMusic(FailMusic.PATH);
                    Constant.count++;
                    if(Constant.count !=3) {
                        new Fail() {
                        };
                    }
                        easy.dispose();
                }
                if(Constant.count == 3){
                    new ScoreFrame();
                    easy.dispose();
                    Constant.count = 0;
                }
            }
        });
    }
}
