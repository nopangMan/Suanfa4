package com.company;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/29 13:53
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private Bag.Node<Item> first = null;
    private int n = 0;

    public Bag() {
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.n;
    }

    public void add(Item item) {
        Bag.Node<Item> oldfirst = this.first;
        this.first = new Bag.Node();
        this.first.item = item;
        this.first.next = oldfirst;
        ++this.n;
    }

    public Iterator<Item> iterator() {
        return new Bag.ListIterator(this.first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Bag.Node<Item> current;

        public ListIterator(Bag.Node<Item> first) {
            this.current = first;
        }

        public boolean hasNext() {
            return this.current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                Item item = this.current.item;
                this.current = this.current.next;
                return item;
            }
        }
    }

    private static class Node<Item> {
        private Item item;
        private Bag.Node<Item> next;

        private Node() {
        }
    }
}
