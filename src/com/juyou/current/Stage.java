package com.juyou.current;

/**
 * @Desc: 舞台线程
 * @Company: 聚优福利
 * @Author  wuyz@huayingcul.com
 * @Date  2018/9/4 13:18
 */
public class Stage extends Thread{

    @Override
    public void run(){
        System.out.println("欢迎观看隋唐演义");

        //让观众安静片刻，等待大戏的上演
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //大幕徐徐拉开
        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说隋朝末年，隋军与农民起义杀得昏天黑地。。。");

        ArmyRunnable armyTaskOfSui = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        //使用Runnable接口创建线程
        Thread sui = new Thread(armyTaskOfSui, "隋军");
        Thread revolt = new Thread(armyTaskOfRevolt, "农民军");

        //启动线程,让军队开始作战
        sui.start();
        revolt.start();
        //舞台线程休眠，专心观看军队厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //军队停止作战
        armyTaskOfSui.keepRunning=false;
        armyTaskOfRevolt.keepRunning=false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正当双方激战正酣，半路杀出个程咬金");
        KeyPersonThread keyPersonThread = new KeyPersonThread();
        keyPersonThread.setName("程咬金");
        System.out.println("程咬金的理想就是结束战争，百姓安居乐业");
        //历史大戏留给关键人物
        keyPersonThread.start();
        //所有线程需要等待关键天生线程完成历史使命
        try {
            keyPersonThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民做出了杰出的贡献");
        System.out.println("谢谢观看隋唐演义，再见！！！");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
