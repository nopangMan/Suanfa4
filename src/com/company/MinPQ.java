package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/29 16:54
 */
public class MinPQ<Edge> {

    private final List<com.company.Edge> pqAll = new ArrayList<>();

    public void insert(com.company.Edge edge) {
        pqAll.add(edge);
    }

    public Edge delMin() {
        if (pqAll.isEmpty()) throw new NoSuchElementException();
        double minWeights = pqAll.get(0).getWeight();
        int index = 0;
        //查找并返回所有边中的最小权重边
        for (int i = 0; i < pqAll.size(); i++) {
            if (minWeights < pqAll.get(i).getWeight()) continue;
            minWeights = pqAll.get(i).getWeight();
            index = i;
        }
        return (Edge) pqAll.get(index);
    }

    public boolean isEmpty() {
        return pqAll.isEmpty();
    }


}
