package com.geekbang.waitnotify;

import java.util.Queue;

/**
 * consumer.
 *
 * @author wangwenjie
 * @date 2021-07-27
 */
public class Consumer<T> {
    private Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public T consume() throws InterruptedException {
        synchronized (tasks) {
            // 为0 等待队列填充
            while (tasks.size() == 0) {
                tasks.wait();
            }
            // consume
            T task = tasks.poll();
            System.out.println("消费消息： " + task);
            tasks.notifyAll();
            return task;
        }
    }
}
