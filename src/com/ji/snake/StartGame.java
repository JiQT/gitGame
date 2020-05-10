package com.ji.snake;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        //绘制一个静态窗口
        JFrame frame = new JFrame("贪吃蛇小游戏");
        //设置页面大小
        frame.setBounds(10,10,920,720);
        //窗口大小不可改变
        frame.setResizable(false);
        //设置关闭
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //启动
        frame.add(new Panel());
        //展示窗口
        frame.setVisible(true);

    }
}
