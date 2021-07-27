package com.geekbang.waitnotify;

import java.util.Queue;

/**
 * producer.
 *
 * @author wangwenjie
 * @date 2021-07-27
 */
public class Producer<T> {
    private Queue<T> task;
    private int maxSize;

    public Producer(Queue<T> task, int maxSize) {
        this.task = task;
        this.maxSize = maxSize;
    }

    public void produce(T t) throws InterruptedException {
        synchronized (task) {
            while (task.size() >= maxSize) {
                task.wait();
            }
            task.offer(t);
            System.out.println("添加消息：" + t);
            task.notifyAll();
        }
    }
}
