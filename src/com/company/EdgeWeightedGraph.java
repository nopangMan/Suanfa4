package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: 加权无向图
 * @date 2022/5/29 13:45
 */
//无向图数据结构
public class EdgeWeightedGraph {

    //顶点数
    private final int V;
    //边数
    private int E;
    //包 内部为链表结构
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V, int E) {
        this.V = V;
        this.E = E;
        this.adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(Edge edge) throws Exception {
        int v = edge.getEither();
        int w = edge.getOther(v);
        adj[v].add(edge);
        adj[w].add(edge);
        ++E;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() throws Exception {
        Bag<Edge> edges = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge edge :
                    adj[v]) {
                if (edge.getOther(v) > v) edges.add(edge);
            }
        }
        return edges;
    }
}
