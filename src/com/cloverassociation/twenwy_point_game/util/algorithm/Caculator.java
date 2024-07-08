package com.cloverassociation.twenwy_point_game.util.algorithm;

import java.util.LinkedList;
import java.util.Objects;

public class Caculator {
    public static int getValue(String str) {
        if(str.equals("NO")){
            return 1;
        }
        else {
            return value(str.toCharArray(), 0)[0];
        }
    }

    //从str[i...]往下算，遇到字符串终止为止或者右括号就停止
//返回两个数，长度为2的数组
//0）负责这一段的结果是多少
//1）负责这一段计算到了那个位置
    public static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<>();
        int cur = 0;
        int[] bra;
        //从i出发，开始撸串
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {
                cur = cur * 10 + str[i++] - '0';
            } else if (str[i] != '(') {//遇到的是运算符号
                addNum(que, cur);
                que.addLast(String.valueOf(str[i++]));
                cur = 0;
            } else {//遇到左括号
                bra = value(str, i + 1);
                cur = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, cur);
        return new int[]{getNum(que), i};
    }

    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.parseInt(Objects.requireNonNull(que.pollLast()));
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur;
        int num;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.parseInt(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }
}