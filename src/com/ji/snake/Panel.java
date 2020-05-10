package com.ji.snake;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
//855 100
//855 555
public class Panel extends JPanel implements KeyListener, ActionListener {
    //蛇的长度，位置
    int length;
    int[] snakeX=new int[600];
    int[] snakeY=new int[500];

    //方向
    String dir;

    //食物
    int foodx;
    int foody;
    Random rnd=new Random();

    //定时器100ms=1s 10帧
    Timer timer= new Timer(100,this);

    //游戏是否开始
    boolean isStart=false;

    //失败
    boolean isFalse=false;

    //积分系统
    int score;
    //构造器,初始化数据
    public Panel(){
        init();
        //获取键盘的监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }
    //初始化
    public void init(){
        length=3;
        //头部坐标
        snakeX[0]=100;snakeY[0]=150;
        //身体坐标
        snakeX[1]=75;snakeY[1]=150;
        snakeX[2]=50;snakeY[2]=150;
        dir="R";
        //食物
        foodx=25+25*rnd.nextInt(33);
        foody=125+25*rnd.nextInt(17);
        //积分
        score=0;
    }

    //画界面和蛇，Graphics g画笔
    @Override
    protected void paintComponent(Graphics g) {
        //清屏
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.black);

        //拿到图片
        Image.icon.paintIcon(this,g,25,10);
        Image.heads.paintIcon(this,g,135,10);
        Image.background.paintIcon(this,g,25,120);
        //游戏区域
        //g.fillRect(25,75,850,600);
        if(dir.equals("R")){
            Image.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(dir.equals("L")){
            Image.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(dir.equals("U")){
            Image.top.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(dir.equals("D")){
            Image.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        //画静态蛇
        for(int i=1;i<length;i++){
            Image.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //画食物
        Image.food.paintIcon(this,g,foodx,foody);
        //游戏是否开始的提示
        if(isStart==false){
            g.setColor(Color.white);
            g.setFont(new Font("华文楷体",Font.BOLD,40));
            g.drawString("按下空格开始",330,300);
        }
        //游戏失败提醒
        if(isFalse){
            g.setColor(Color.RED);
            g.setFont(new Font("华文楷体",Font.BOLD,40));

            g.drawString("游戏结束,"+"您的最终得分为:"+score,220,300);
            g.drawString("空格重新开始",340,400);
        }
        //画积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度："+length,780,40);
        g.drawString("得分："+score,780,88);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //键盘按下弹起操作
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //键盘按下未释放
        //获取按下的键
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE){
            //若失败了,重启游戏
            if(isFalse){
                isFalse=false;
                init();
            }else{
                //启动或者暂停
                isStart=!isStart;
            }
            repaint();//刷新界面
        }
        //键盘控制方向
        if(keyCode==KeyEvent.VK_LEFT){
            dir="L";
        }else if(keyCode==KeyEvent.VK_RIGHT){
            dir="R";
        }else if(keyCode==KeyEvent.VK_UP){
            dir="U";
        }else if(keyCode==KeyEvent.VK_DOWN){
            dir="D";
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //释放某个键
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //若游戏开始,并且没有失败
        if(isStart && isFalse==false){
            //身体移动
            for(int i=length-1;i>0;i--){
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            //头部移动
            if(dir.equals("R")){
                snakeX[0]+=25;
                if(snakeX[0]>855){ isFalse=true; }  //边界判断
            }else if(dir.equals("L")){
                snakeX[0]-=25;
                if(snakeX[0]<25){ isFalse=true; }  //边界判断
            }else if(dir.equals("U")){
                snakeY[0]-=25;
                if(snakeY[0]<120){isFalse=true;}  //边界判断
            }else if(dir.equals("D")){
                snakeY[0]+=25;
                if(snakeY[0]>655){isFalse=true;}  //边界判断
            }

            //吃食物
            if(snakeX[0]==foodx && snakeY[0]==foody){
                length++;
                //吃完后再次随机生成
                foodx=25+25*rnd.nextInt(33);
                foody=125+25*rnd.nextInt(17);
                //积分
                score+=10;
            }
            //身体碰撞结束判断
            for(int i=1;i<length;i++){
                if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                    isFalse=true;
                }
            }
            //刷新页面
            repaint();
        }
        timer.start();
    }
}
