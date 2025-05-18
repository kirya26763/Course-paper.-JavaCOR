package com.example.Course.paper.JavaCOR.Util;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static int getRandomQuestion(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max должен быть больше 0");
        }
        return random.nextInt(max);
    }
}