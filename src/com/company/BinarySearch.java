package com.company;

import java.util.List;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/7 21:27
 */
public class BinarySearch {

    public int rank(List<Integer> arrs, int key, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + hi / 2;
        if (arrs.get(mid) > key) return rank(arrs, key, lo, mid);
        else if (arrs.get(mid) < key) return rank(arrs, key, mid, hi);
        else return mid;
    }
}
