package com.cloverassociation.twenwy_point_game.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GameRankingFramework extends JFrame {
    private static final Map<String, Integer> playerScores = new HashMap<>();
    private static final String SAVE_FILE_PATH = "game_ranking_data.txt";
    private final JTable rankingTable;

    public GameRankingFramework() {
        // 初始化窗口
        setTitle("Game Ranking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 加载数据
        loadData();

        // 创建表格
        String[] columnNames = {"Player Name", "Score"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][], columnNames);
        rankingTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(rankingTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // 更新表格显示
        updateTable();

        // 添加返回按钮
        JButton backButton = new JButton("Back to Game");
        backButton.addActionListener(e -> {
            new GameFrame();
            dispose();
        });
        // 显示窗口
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().add(backButton,BorderLayout.SOUTH);
    }

    // 加载保存的数据
    private static void loadData() {
        playerScores.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(SAVE_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    if (!playerScores.containsKey(playerName) || playerScores.get(playerName) < score) {
                        playerScores.put(playerName, score);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // 保存数据到文件
    private static void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_FILE_PATH))) {
            for (Map.Entry<String, Integer> entry : playerScores.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 更新表格显示
    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) rankingTable.getModel();
        model.setRowCount(0); // 清空表格内容
        for (Map.Entry<String, Integer> entry : playerScores.entrySet()) {
            model.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }
    }

    // 公共修改方法
    public static void addPlayer(String playerName, int score) {
        if (playerName == null || playerName.isEmpty() || playerName.equals("游客")) {
            playerName = "游客";
        }
        if (!playerScores.containsKey(playerName) || playerScores.get(playerName) < score) {
            playerScores.put(playerName, score);
            saveData(); // 保存数据到文件
        }
    }
}