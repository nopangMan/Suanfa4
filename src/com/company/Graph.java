package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/29 13:45
 */
//无向图数据结构
public class Graph {

    //顶点数
    private final int V;
    //边数
    private int E;
    //包 内部为链表结构
    private Bag<Integer>[] adj;

    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
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
        this.adj[w].add(v);
        ++E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

}
