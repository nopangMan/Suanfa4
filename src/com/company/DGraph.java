package com.company;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/29 13:45
 */
//无向图数据结构
public class DGraph {

    //顶点数
    private final int V;
    //边数
    private int E;
    //包 内部为链表结构
    private Bag<Integer>[] adj;

    public DGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        ++E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public DGraph reverse() {
        DGraph dGraph = new DGraph(V);
        for (int v = 0; v < V; v++) {
            for (Integer w :
                    adj[v]) {
                dGraph.addEdge(w, v);
            }
        }
        return dGraph;
    }

    ;

}
