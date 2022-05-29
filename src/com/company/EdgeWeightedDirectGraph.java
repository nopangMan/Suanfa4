package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: 加权无向图
 * @date 2022/5/29 13:45
 */
//无向图数据结构
public class EdgeWeightedDirectGraph {

    //顶点数
    private final int V;
    //边数
    private int E;
    //包 内部为链表结构
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDirectGraph(int V, int E) {
        this.V = V;
        this.E = E;
        this.adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(DirectedEdge directedEdge) throws Exception {
        adj[directedEdge.from()].add(directedEdge);
        ++E;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() throws Exception {
        Bag<DirectedEdge> edges = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge edge :
                    adj[v]) {
                edges.add(edge);
            }
        }
        return edges;
    }
}
