package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: 最短路径简单实现
 * @date 2022/5/29 22:56
 */
public class DijkstraSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDirectGraph g, int s) {
        this.edgeTo = new DirectedEdge[g.V()];
        this.distTo = new double[g.V()];
        pq = new IndexMinPQ<>(g.V());

        for (int v = 0; v < g.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(g, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDirectGraph g, int delMin) {
        for (DirectedEdge directedEdge :
                g.adj(delMin)) {
            int w = directedEdge.to();
            //可以放松
            if (distTo[w] > distTo[delMin] + directedEdge.getWeight()) {
                distTo[w] = distTo[delMin] + directedEdge.getWeight();
                edgeTo[w] = directedEdge;
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }

        }
    }


}
