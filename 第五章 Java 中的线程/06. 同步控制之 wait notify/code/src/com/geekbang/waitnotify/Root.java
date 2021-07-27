package com.geekbang.waitnotify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/**
 * .
 *
 * @author wangwenjie
 * @date 2021-07-27
 */
public class Root {
    public static void main(String[] args) {
        Queue<String> messages = new LinkedList<>();

        Consumer<String> consumer = new Consumer<>(messages);
        Producer<String> producer = new Producer<>(messages, 10);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        consumer.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        String[] str = {"a", "b", "c", "d"};
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        producer.produce(str[random.nextInt(3)]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
