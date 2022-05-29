package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Fzc
 * @version 1.0
 * @description: TODO
 * @date 2022/5/29 22:42
 */
public class IndexMinPQ<Key extends Comparable<? super Key>> implements Iterable<Integer> {
    /**
     * 索引优先队列,保存对象在数组中的位置，按索引值(即keys[i],i为索引)进行小堆排序
     */
    private int[] pq;
    /**
     * pq的逆序,保存对象索引在pq中的位置
     */
    private int[] qp;
    /**
     * 队列最大元素数
     */
    private int maxSize;
    /**
     * 当前队列元素数量
     */
    private int currentSize;

    /**
     * 具体元素
     */
    private Key[] keys;

    public IndexMinPQ(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("参数非法");
        }
        this.maxSize = maxSize;
        pq = new int[maxSize + 1];
        qp = new int[maxSize + 1];
        keys = (Key[]) new Comparable[maxSize + 1];
        currentSize = 0;

        for (int i = 0; i < maxSize + 1; i++) {
            //qp 初始化为-1 ，表示没有索引关联的对象
            qp[i] = -1;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }

    public Key keyOf(int i) {
        checkIndex(i);
        if (!contains(i)) throw new NoSuchElementException("不存在该索引");
        return keys[i];
    }

    /**
     * 返回最小的索引，即索引队列pq[1]对应的索引对象
     *
     * @return
     */
    public int minIndex() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空");
        }
        return pq[1];
    }

    public boolean isEmpty() {
        return pq.length == 0 ? true : false;
    }

    public boolean contains(int index) {
        checkIndex(index);
        //如果存在，则qp[index]一定不为-1，且指向 该对象index在 索引队列pq中的位置
        return qp[index] != -1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= maxSize) {
            throw new IndexOutOfBoundsException("参数越界");
        }
    }

    /**
     * 插入一对值
     *
     * @param index 索引
     * @param key   索引关联的值
     */
    public void insert(int index, Key key) {
        checkIndex(index);
        if (contains(index)) {
            throw new IllegalArgumentException("索引" + index + "已存在");
        }
        //增加元素数
        currentSize++;
        //当前对象的索引为队列尾部
        qp[index] = currentSize;
        //该索引指向的对象在key中的位置为index
        pq[currentSize] = index;
        keys[index] = key;
        //对尾部元素上滤
        percolateUp(currentSize);
    }

    /**
     * 上滤
     *
     * @param n
     */
    private void percolateUp(int n) {
        //将n和n/2（n的父亲）比较，如果父亲大，则交换两个节点
        for (; n > 1 && compareTo(n, n / 2) < 0; n /= 2) {
            swap(n, n / 2);
        }
    }

    /**
     * 比较索引队列i和j上的对应的key值大小
     *
     * @param i
     * @param j
     * @return
     */
    private int compareTo(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]);
    }

    /**
     * 交换pq[i]和pq[j]的元素
     * 并更新qp,qp[pq[i]]=i;
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 删除最小键并返回其关联的索引。
     *
     * @return 关联的索引 即pq[1]
     */
    public int delMin() {
        if (currentSize == 0) {
            return -1;
        }

        int minIndex = pq[1];
        swap(1, currentSize--);
        percolateDown(1);
        //删除当前对象，即pq中不存在该对象了
        qp[minIndex] = -1;

        pq[currentSize + 1] = -1;//不是必须的
        keys[minIndex] = null;
        return minIndex;
    }

    /**
     * 下滤
     *
     * @param k
     */
    private void percolateDown(int k) {
        int child;
        for (; k * 2 <= currentSize; k = child) {
            child = 2 * k;
            if (child < currentSize && compareTo(child + 1, child) < 0) {
                child++;
            }
            if (compareTo(child, k) < 0) {
                swap(child, k);
            } else {
                break;
            }
        }

    }

    /**
     * 修改索引i关联的key值
     *
     * @param i
     * @param key
     */
    public void changeKey(int i, Key key) {
        checkIndex(i);
        if (!contains(i)) throw new NoSuchElementException("不存在该索引");

        keys[i] = key;
        percolateUp(qp[i]);
        percolateDown(qp[i]);
    }

    /**
     * 将与索引 i 关联的键减小为指定值。
     *
     * @param i
     * @param key
     */
    public void decreaseKey(int i, Key key) {
        checkIndex(i);
        if (!contains(i)) throw new NoSuchElementException("不存在该索引");
        if (keys[i].compareTo(key) < 0) {
            throw new IllegalArgumentException("当前key无法缩小原key值");
        }
        keys[i] = key;
        //当前key变小，因此上滤即可
        percolateUp(qp[i]);

    }

    /**
     * 将与索引 i 关联的键增加为指定值。
     *
     * @param i
     * @param key
     */
    public void increaseKey(int i, Key key) {
        checkIndex(i);
        if (!contains(i)) throw new NoSuchElementException("不存在该索引");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("当前key无法增加原key值");
        keys[i] = key;
        //当前key变大，因此下滤即可
        percolateDown(qp[i]);
    }

}
