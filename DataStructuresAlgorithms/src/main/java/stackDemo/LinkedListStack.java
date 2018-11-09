package stackDemo;

import java.util.LinkedList;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/11/8
 */
public class LinkedListStack<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    public boolean push(T item) {
        storage.addFirst(item);
        return true;
    }

    public T pop() {
        return storage.removeFirst();
    }

    public T peek() {
        return storage.getFirst();
    }
}
