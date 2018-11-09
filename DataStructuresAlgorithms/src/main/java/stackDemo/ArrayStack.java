package stackDemo;

import generators.Generated;
import generators.Generator;
import generators.PrimitiveGenerator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/11/8
 */
public class ArrayStack<T> {
    private T[] storage;
    private int size;       // 栈的大小
    private int count;      // 元素的个数

    public ArrayStack(Class<T> type, Generator<T> gen, int n) {
        if (size >= 0) {
            this.size = n;
            this.count = 0;
            storage = Generated.array(type, gen, n);
        } else {
            throw  new RuntimeException("Illegal stack size: " + size);
        }

    }

    public boolean push(T item) {
        if (count == size) {
            return false;
        }
        storage[count++] = item;
        return true;
    }
    public boolean push(Generator<T> gen) {
        if (count == size) {
            return false;
        }
        storage[count++] = gen.next();
        return true;
    }

    public T pop() {
        if (count == 0) {
            return null;
        }
        --count;
        T item = storage[count];
        storage[count] = null;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append(":");
        for (int i = 0; i < count; i++) {
            sb.append(storage[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ArrayStack<String> stack = new ArrayStack<String>(String.class,
                new PrimitiveGenerator.String(), 15);
        for (String s : "A B C D E F G H I".split(" ")) {
            stack.push(s);
        }
        System.out.println(stack);
    }
}
