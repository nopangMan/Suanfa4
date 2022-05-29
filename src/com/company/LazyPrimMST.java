package com.company;


import sun.misc.Queue;

/**
 * @author Fzc
 * @version 1.0
 * @description: 最小生成数延迟Prim算法
 * @date 2022/5/29 16:50
 */
public class LazyPrimMST {

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph g) throws Exception {
        this.marked = new boolean[g.V()];
        this.mst = new Queue<>();
        this.pq = new MinPQ<>();

        visit(g, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.delMin();

            int v = edge.getEither();
            int w = edge.getOther(v);
            //跳过被标记过的顶点
            if (marked[v] && marked[w]) continue;
            mst.enqueue(edge);
            if (!marked[v]) visit(g, v);
            if (!marked[w]) visit(g, w);
        }
    }

    private void visit(EdgeWeightedGraph g, int v) throws Exception {
        marked[v] = true;
        for (Edge edge :
                g.adj(v)) {
            if (!marked[edge.getOther(v)]) pq.insert(edge);
        }
    }

//即时算法
}
