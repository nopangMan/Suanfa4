package com.company;

import com.sun.org.apache.regexp.internal.RE;

import javax.crypto.interfaces.PBEKey;
import javax.xml.soap.Node;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/16 20:54
 */
public class RedBlackBST<Key extends Comparable<Key>, String> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private String value;
        private int N;
        private Node left, right;
        private boolean color;

        public Node(Key key, String value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }

        private boolean isRed(Node x) {
            if (x == null) return false;
            return x.color == RED;
        }

        public int size() {
            return size(root);
        }

        private int size(Node root) {
            if (root == null) return 0;
            return root.N;
        }

        public Node min() {
            return max(root);
        }

        private Node min(Node node) {
            if (node.left != null)
                return max(node.left);
            return node.left;
        }

        public Node max() {
            return max(root);
        }

        private Node max(Node node) {
            if (node.right != null)
                return max(node.right);
            return node.right;
        }

        //交换颜色
        private void flipColors(Node x) {
            x.color = RED;
            x.left.color = BLACK;
            x.right.color = BLACK;
        }

        //左旋转
        private Node rotateLeft(Node a) {
            Node b = a.right;
            a.right = b.left;
            b.left = a;
            a.color = b.color;
            b.color = RED;
            b.N = a.N;
            a.N = 1 + a.left.N + a.right.N;
            return b;
        }

        //右旋转
        private Node rotateRight(Node a) {
            Node b = a.left;
            a.left = b.right;
            b.right = a;
            a.color = b.color;
            b.color = RED;
            b.N = a.N;
            a.N = 1 + a.left.N + a.right.N;
            return b;
        }

        public String get(Key key) {
            return get(root, key);
        }

        private String get(Node node, Key key) {
            if (node == null) return null;
            int tmp = node.key.compareTo(key);
            // 大于0 在左边递归
            if (tmp > 0) {
                return get(node.left, key);
            } else if (tmp < 0) {
                return get(node.right, key);
            } else
                return node.value;
        }

        public Node put(Key key, String value) {
            return put(root, key, value);
        }

        private Node put(Node node, Key key, String value) {
            if (node == null) return new Node(key, value, 1, RED);
            int tmp = node.key.compareTo(key);
            //在左边
            if (tmp > 0) {
                node.left = put(node.left, key, value);
            } else if (tmp < 0) {
                node.right = put(node.right, key, value);
            } else {
                node.value = value;
            }

            if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
            if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
            if (isRed(node.left) && isRed(node.right)) flipColors(node);

            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }

    }

}
