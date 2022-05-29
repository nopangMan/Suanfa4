package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/29 14:40
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 栈结构
 */
public class Stack<E> {
    private List<E> list = new ArrayList<>();

    /**
     * 元素数量
     *
     * @return
     */
    int size() {
        return list.size();
    }

    /**
     * 是否是空
     *
     * @return
     */
    boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入栈 - 给列表添加元素
     *
     * @param element
     */
    void push(E element) {
        list.add(element);
    }

    /**
     * 出栈 - 移除列表中最后一个元素
     *
     * @return
     */
    E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取栈顶元素 - 获取列表最后一个元素
     *
     * @return
     */
    E top() {
        return list.get(list.size() - 1);
    }

    /**
     * 清空
     */
    void clear() {
        list.clear();
    }
}
