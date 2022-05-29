package com.company;

import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/7 21:54
 */
public class MySort {
    public static final int[] arrs = new int[20];
    public static final int[] tmpArr = new int[arrs.length];

    static {
        Random random = new Random();
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = random.nextInt(100);
        }
    }

    //选择排序
    public void selectArray(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            int min = arrs[i];
            for (int j = i + 1; j < arrs.length; j++) {
                if (min > arrs[j]) {
                    min = arrs[j];
                    exchange(arrs, i, j);
                }
            }
        }
        showArrays(arrs);
    }

    private void showArrays(int[] arrs) {
        int i = 0;
        while (i < arrs.length) System.out.printf(arrs[i++] + " ");
    }

    private void exchange(int[] arrs, int i, int j) {
        int tmp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = tmp;
    }

    public void insertSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            for (int j = i; j > 0 && less(arrs[j], arrs[j - 1]); j--) {
                exchange(arrs, j, j - 1);
            }
        }
        showArrays(arrs);
    }

    private boolean less(int arr, int arr1) {
        return arr < arr1;
    }

    public void mergeSort(int[] arrs) {
        sortForMerge(arrs, 0, arrs.length - 1);
        showArrays(arrs);
    }

    private void sortForMerge(int[] arrs, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sortForMerge(arrs, lo, mid);
        sortForMerge(arrs, mid + 1, hi);
        merge(arrs, lo, mid, hi);
    }

    private void merge(int[] arrs, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            tmpArr[k] = arrs[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arrs[k] = tmpArr[j++];
            else if (j > hi) arrs[k] = tmpArr[i++];
            else if (less(tmpArr[j], tmpArr[i])) arrs[k] = tmpArr[j++];
            else arrs[k] = tmpArr[i++];
        }
    }

    public void quickSort(int[] arrs) {
        sortForQuick(arrs, 0, arrs.length - 1);
        showArrays(arrs);
    }

    private void sortForQuick(int[] arrs, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        int v = arrs[lo];
        while (i <= gt) {
            if (less(arrs[i], v)) exchange(arrs, lt++, i++);
            else if (less(v, arrs[i])) exchange(arrs, i, gt--);
             else i++;
        }
        sortForQuick(arrs, lo, lt - 1);
        sortForQuick(arrs, gt + 1, hi);
    }
}
