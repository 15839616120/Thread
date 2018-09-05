package com.juyou.current;
/**
 * @Desc: 线程先生和线程小姐
 * @Company: 聚优福利
 * @Author  wuyz@huayingcul.com
 * @Date  2018/9/3 18:41
 */
public class Actor extends Thread{

    @Override
    public void run(){
        System.out.println(getName()+"是一个演员");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(getName()+"第"+ ++count +"登台演出");
            if (count==100){
                keepRunning=false;
            }
            if (count%10==0){
                try {
                    Thread.sleep(1000);
                    System.out.println("10的倍数");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"的演出结束了");
    }

    static class Actress implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"是一个演员");
            int count = 0;
            boolean keepRunning = true;
            while (keepRunning){
                System.out.println(Thread.currentThread().getName()+"第"+ ++count +"登台演出");
                if (count==100){
                    keepRunning=false;
                }
                if (count%5==0){
                    try {
                        Thread.sleep(1000);
                        System.out.println("5的倍数");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName()+"的演出结束了");
        }
    }

    public static void main(String[] args) {
        //线程先生
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();
        //线程小姐
        Thread actress = new Thread(new Actress(), "Ms.Runnable");
        actress.start();

    }
}
