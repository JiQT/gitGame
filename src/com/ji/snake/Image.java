package com.ji.snake;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.net.URL;
import java.util.Date;

public class Image {
    //定位地址
    public static URL headURL = Image.class.getResource("/statics/header.png");
    public static URL upURL = Image.class.getResource("/statics/up.png");
    public static URL downURL = Image.class.getResource("/statics/down.png");
    public static URL leftURL = Image.class.getResource("/statics/left.png");
    public static URL rightURL = Image.class.getResource("/statics/right.png");
    public static URL backgroundURL = Image.class.getResource("/statics/bg.png");
    public static URL iconURL = Image.class.getResource("/statics/icon.jpg");
    public static URL headsURL = Image.class.getResource("/statics/heads.jpg");
    //身体
    public static URL bodyURL = Image.class.getResource("/statics/body.png");
    //食物
    public static URL foodURL = Image.class.getResource("/statics/food.png");
    //获取图片
    public static ImageIcon heads = new ImageIcon(headsURL);
    public static ImageIcon icon = new ImageIcon(iconURL);
    public static ImageIcon background = new ImageIcon(backgroundURL);
    public static ImageIcon top=new ImageIcon(upURL);
    public static ImageIcon down=new ImageIcon(downURL);
    public static ImageIcon left=new ImageIcon(leftURL);
    public static ImageIcon right=new ImageIcon(rightURL);
    public static ImageIcon food=new ImageIcon(foodURL);
    public static ImageIcon body=new ImageIcon(bodyURL);
}
