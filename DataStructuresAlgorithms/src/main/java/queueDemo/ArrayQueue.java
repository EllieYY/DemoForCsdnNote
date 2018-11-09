package queueDemo;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/11/8
 */
public class ArrayQueue<T> {
    private Object[] storage = null;
    private int size;
    private int head;
    private int tail;

    public ArrayQueue(int size) {
        if (size >= 0) {
            this.size = size;
            head = tail = 0;
            storage = new Object[size];
        } else {
            throw  new RuntimeException("Illegal queue size: " + size);
        }
    }

    public boolean enqueue(T item) {
        if ((tail + 1) % size == head) {
            return false;
        }
        storage[tail] = item;
        tail = (tail + 1) % size;

        return true;
    }

    public T dequeue() {
        if (tail == head) {
            return null;
        }
        T item = (T)storage[head];
        storage[head] = null;
        head = (head + 1) % size;
        return item;
    }


}
