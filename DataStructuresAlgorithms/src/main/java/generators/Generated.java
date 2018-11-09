package generators;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/11/8
 */
public class Generated {
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[])Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }

    public static <T> Collection<T> fillCollection(Collection<T> coll, Generator<T> gen, int size) {
        for (int i = 0; i < size; i++) {
            coll.add(gen.next());
        }
        return coll;
    }
}
