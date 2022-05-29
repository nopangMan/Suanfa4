package com.company;

import sun.misc.Queue;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/29 15:06
 */
public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edge;
    private final int s;

    public BreadthFirstPaths(Graph g, int s) throws InterruptedException {
        this.s = s;
        this.marked = new boolean[g.V()];
        this.edge = new int[g.V()];
        bfs(g, s);
    }

    private void bfs(Graph g, int s) throws InterruptedException {
        Queue<Integer> tmp = new Queue<>();
        marked[s] = true;
        tmp.enqueue(s);
        while (!tmp.isEmpty()) {
            Integer v = tmp.dequeue();
            for (Integer w :
                    g.adj(v)) {
                if (!marked[w]) {
                    edge[w] = v;
                    marked[w] = true;
                    tmp.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {

        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edge[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
