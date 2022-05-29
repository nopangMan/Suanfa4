package com.company;

import sun.misc.Queue;

import java.util.Stack;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/29 15:47
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(DGraph dg) {
        this.pre = new Queue<Integer>();
        this.post = new Queue<Integer>();
        this.reversePost = new Stack<Integer>();
        for (int v = 0; v < dg.V(); v++) {
            dfs(dg, v);
        }
    }

    private void dfs(DGraph dg, int v) {
        marked[v] = true;
        pre.enqueue(v);
        for (Integer w :
                dg.adj(v)) {
            if (!marked[w]) dfs(dg, w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Queue<Integer> pre() {
        return this.pre;
    }

    public Queue<Integer> post() {
        return this.post;
    }

    public Stack<Integer> reversePost() {
        return this.reversePost;
    }

}
