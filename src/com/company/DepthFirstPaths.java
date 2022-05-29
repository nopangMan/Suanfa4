package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: 深度优先搜索 路径
 * @date 2022/5/29 14:26
 */
public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    DepthFirstPaths(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.s = s;
    }

    public void dfs(Graph g, int v) {
        //已经搜索
        marked[v] = true;
        //继续向下搜索
        for (Integer w : g.adj(v)
        ) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {

        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
