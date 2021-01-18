package com.wk.javaalgorithm.leetcode721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * <p>
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * <p>
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 */
public class SolutionJ {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailToIndex = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        int emailCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailCount++);
                    emailToName.put(email, name);
                }
            }
        }

        Union union = new Union(emailCount);
        for (List<String> account : accounts) {
            int firstIndex = emailToIndex.get(account.get(1));
            int size = account.size();
            for (int i = 2; i < size; i++) {
                int nextIndex = emailToIndex.get(account.get(i));
                union.union(firstIndex, nextIndex);
            }
        }

        HashMap<Integer, List<String>> indexToEmail = new HashMap<>();

        for (String email : emailToIndex.keySet()) {
            int index = union.find(emailToIndex.get(email));
            List<String> account = indexToEmail.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmail.put(index, account);
        }

        ArrayList<List<String>> merged = new ArrayList<>();
        for (List<String> emails : indexToEmail.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }

    class Union {
        int[] parent;

        Union(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int x, int y) {
            parent[find(x)] = find(y);
        }

        int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
    }
}
