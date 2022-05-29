package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/16 20:55
 */
public class Key implements Comparable {

    private int keyAge;

    public Key(int keyAge) {
        this.keyAge = keyAge;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Key) {
            Key a = (Key) o;
            return this.keyAge - a.keyAge;
        }
        return -999;
    }
}
