package com.wk.javaalgorithm.taskscheduler;

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


}
