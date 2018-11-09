package stackDemo;

import generators.PrimitiveGenerator;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/11/8
 */
public class ObjectArrayStack<T> {
    private Object[] storage = null;
    private int size;
    private int count;

    public ObjectArrayStack(int size) {
        if (size >= 0) {
            this.size = size;
            this.count = 0;
            storage = new Object[size];
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

    public T pop() {
        if (count == 0) {
            return null;
        }
        --count;
        T item = (T)storage[count];
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
        ObjectArrayStack<String> stack = new ObjectArrayStack<String>(15);
        for (String s : "A B C D E F G H I".split(" ")) {
            stack.push(s);
        }
        System.out.println(stack);
    }
}
