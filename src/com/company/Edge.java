package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: 边/横切边
 * @date 2022/5/29 16:29
 */
public class Edge implements Comparable<Edge> {

    private final int v;

    private final int w;

    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getEither() {
        return v;
    }

    public int getOther(int vertex) throws Exception {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new Exception("no edge like this");
    }

    public double getWeight() {
        return weight;
    }


    @Override
    public int compareTo(Edge that) {
        if (this.getWeight() > that.getWeight()) return 1;
        else if (this.getWeight() < that.getWeight()) return -1;
        else return 0;
    }
}
