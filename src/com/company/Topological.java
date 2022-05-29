package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/29 16:07
 */
public class Topological {

    // is DAG 是无环有向图吗

    private DepthFirstOrder dfo = new DepthFirstOrder(null);
    //拓补排序 order...
    Integer order = dfo.reversePost().pop();
}
