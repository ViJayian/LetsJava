package com.geekbang.learnthread;

/**
 * interrupt.
 *
 * @author wangwenjie
 * @date 2021-07-27
 */
public class InterrupteDemo2 {
    public static void main(String[] args) {
        Thread task1 = new Thread(() -> {
            try {
                //>> TODO 中断状态被清空，并且抛出异常.
                Thread.sleep(2000);//java.lang.InterruptedException: sleep interrupted
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //>> TODO 是否被中断 中断状态不受影响.
            System.out.println("是否被中断 " + Thread.currentThread().isInterrupted());//true
            //>> TODO 是否中断 会清除中断状态，下次调用是false.
            System.out.println("是否中断 " + Thread.interrupted());//true
        });
        task1.start();
        task1.interrupt();
    }

}
