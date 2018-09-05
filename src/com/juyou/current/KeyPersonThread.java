package com.juyou.current;

/**
 * @Desc: 关键人物线程
 * @Company: 聚优福利
 * @Author  wuyz@huayingcul.com
 * @Date  2018/9/4 15:46
 */
public class KeyPersonThread extends Thread{

    @Override
    public void run(){
        System.out.println(getName()+"开始了战斗");
        for (int i =0 ; i<10 ; i++){
            System.out.println(getName()+"左突右杀，攻陷隋军");
        }
        System.out.println(getName()+"结束了战斗");
    }
}
