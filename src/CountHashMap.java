import java.util.HashMap;
import java.util.Map;

/**
 * Created by Григорий on 20.12.2016.
 */

public class CountHashMap<E> implements CountMap<E> {
    private final HashMap<E, Integer> objects;

    public CountHashMap() {
        objects = new HashMap<E, Integer>();
    }

    @Override
    public void add(E e) {
        objects.putIfAbsent(e, 0);
        objects.put(e, objects.get(e) + 1);
    }

    @Override
    public int getCount(E e) {
        Integer count = objects.get(e);
        return count != null ? count : 0;
    }

    @Override
    public int remove(E e) {
        Integer count = objects.remove(e);
        return count == null ? 0 : count;
    }

    @Override
    public int size() {
        return objects.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        for (Object o : source.toMap().entrySet()) {
            E key = (E) ((Map.Entry) o).getKey();
            Integer value = (Integer) ((Map.Entry) o).getValue();
            objects.put(key, getCount(key) + value);
        }
    }

    @Override
    public Map toMap() {
        return new HashMap<E, Integer>(objects);
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        for (E e : objects.keySet()) {
            destination.put(e, getCount(e));
        }
    }
}
