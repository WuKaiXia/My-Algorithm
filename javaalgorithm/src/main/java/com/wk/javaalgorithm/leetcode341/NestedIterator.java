package com.wk.javaalgorithm.leetcode341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341.扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 */
public class NestedIterator implements Iterator<Integer> {
    private ArrayList<Integer> vals;
    private Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<>();
        dfs(nestedList);
        cur = vals.iterator();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nested :
                nestedList) {
            if (nested.isInteger()) {
                vals.add(nested.getInteger());
            } else {
                dfs(nested.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }
}


// This is the interface that allows for creating nested lists.
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
