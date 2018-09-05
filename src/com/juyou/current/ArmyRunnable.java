package com.juyou.current;

/**
 * @Desc: 军队线程
 * @Company: 聚优福利
 * @Author  wuyz@huayingcul.com
 * @Date  2018/9/3 19:20
 */
public class ArmyRunnable implements Runnable {
    //可见性原则
    volatile boolean keepRunning =true;
    @Override
    public void run() {
        while (keepRunning){
            //发送五连击
            for(int i = 0 ; i<5 ; i++ ){
                System.out.println(Thread.currentThread().getName()+"第"+ i +"击打");
                //让出处理器时间
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗");
    }
}
