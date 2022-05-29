package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] arrs = MySort.arrs;
        MySort mySort = new MySort();
        //递归二分查找
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        Collections.sort(arrayList);
//        System.out.println(arrayList);
//        BinarySearch binarySearch = new BinarySearch();
//        int result = binarySearch.rank(arrayList, 4, 0, arrs.length - 1);
//        System.out.println("result = " + result);

        //选择排序
        //mySort.selectArray(arrs);
        //插入排序
        //mySort.insertSort(arrs);
        //归并排序
        //mySort.mergeSort(arrs);
        //快速排序
        mySort.quickSort(arrs);
    }
}
