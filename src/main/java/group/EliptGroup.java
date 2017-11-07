package group;

import java.util.*;

public class EliptGroup {
    private int a;
    private int b;
    private int m;

    public EliptGroup(int a, int b, int m) {
        this.a = a;
        this.b = b;
        this.m = m;
    }

    public Map<Integer, Set<Integer>> findEM() {
        Map<Integer, Set<Integer>> elements = new TreeMap<Integer, Set<Integer>>();
        for (int x = 0; x < m; x++) {
            int res = (int) (Math.pow(x, 3) + a * x + b) % m;  //x^3+ax+b (mod m)
            for (int y = 0; y < m; y++) {
                if ((y * y) % m == res) {
                    if (!elements.containsKey(x)) {
                        elements.put(x, new TreeSet<Integer>());
                    }
                    elements.get(x).add(y);
                }
            }
        }
        return elements;
    }

}
