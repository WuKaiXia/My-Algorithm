package com.wk.javaalgorithm.taskscheduler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * leetCode 621. 任务调度器
 * 你需要计算完成所有任务所需要的 最短时间 。
 */
public class SolutionJ {


    public int leastInterval(char[] tasks, int n) {
        // 用来统计每个字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        // 最大字符次数
        int maxExec = 0;
        for (char task : tasks) {
            int count = map.getOrDefault(task, 0) + 1;
            map.put(task, count);
            maxExec = Math.max(maxExec, count);
        }
        AtomicInteger maxCount = new AtomicInteger();

        int finalMaxExec = maxExec;
        map.forEach((character, integer) -> {
            if (integer == finalMaxExec) {
                maxCount.getAndIncrement();
            }
        });
        return Math.max(((maxExec - 1) * (n + 1) + maxCount.getAndIncrement()), tasks.length);
    }

    public int leastInterval1(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int maxExec = freq[25];
        int maxCount = 1;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] != maxExec) {
                break;
            }
            maxCount++;
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
