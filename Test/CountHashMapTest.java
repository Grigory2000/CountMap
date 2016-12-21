import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Григорий on 20.12.2016.
 */

public class CountHashMapTest {

    @Test
    public void testConstructor() {
        Assert.assertTrue(null != new CountHashMap<String>());
    }

    @Test
    public void testCountProcess() throws Exception {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("a");
        strings.add("b");
        strings.add("a");
        strings.add("a");
        Assert.assertEquals(3, strings.getCount("a"));
        Assert.assertEquals(1, strings.getCount("b"));
    }

    @Test
    public void testGetCountForNotExistedElement() throws Exception {
        CountHashMap<String> strings = new CountHashMap<>();
        Assert.assertEquals(0, strings.getCount(""));
    }

    @Test
    public void testRemove() {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("a");
        strings.add("a");
        strings.add("b");
        Assert.assertEquals(2, strings.remove("a"));
        Assert.assertEquals(1, strings.remove("b"));
    }

    @Test
    public void testSize() {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("1");
        strings.add("1");
        strings.add("a");
        strings.add("2");
        strings.add("2");
        strings.add("2");
        strings.remove("1");
        Assert.assertEquals(2, strings.size());
    }

    @Test
    public void testAddAll() {
        CountHashMap<String> strings1 = new CountHashMap<>();
        strings1.add("b");
        strings1.add("b");
        strings1.add("c");
        strings1.add("a");
        CountHashMap<String> strings2 = new CountHashMap<>();
        strings2.add("e");
        strings2.addAll(strings1);
        Assert.assertEquals(4, strings2.size());
        Assert.assertEquals(2, strings2.getCount("b"));
        Assert.assertEquals(1, strings2.getCount("a"));
    }

    @Test
    public void testMapToMap() {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("a");
        strings.add("b");
        strings.add("b");
        HashMap<String, Integer> strings2 = new HashMap<>();
        strings2.put("a", 1);
        strings2.put("b", 2);
        Assert.assertEquals(strings2, strings.toMap());
    }

    @Test
    public void testVoidToMap() {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("a");
        strings.add("a");
        strings.add("b");
        strings.add("c");
        Map<String, Integer> strings2 = new HashMap<>();
        strings2.put("a", 2);
        strings2.put("b", 1);
        strings2.put("c", 1);
        Map<String, Integer> destination = new HashMap<>();
        strings.toMap(destination);
        Assert.assertEquals(strings2, destination);
    }
}
