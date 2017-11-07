package params;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EliptGroupParams {
    private int m;

    public EliptGroupParams(int m) {
        this.m = m;
    }

    //all a and b pairs for such M
    public Map<Integer, Set<Integer>> getAllPairs() {
        Map<Integer, Set<Integer>> pairs = new HashMap<Integer, Set<Integer>>();
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (checkMod(a, b)) {
                    if (pairs.containsKey(a)) {
                        pairs.get(a).add(b);
                    } else {
                        pairs.put(a, new HashSet<Integer>());
                        pairs.get(a).add(b);
                    }
                }
            }
        }
        return pairs;
    }

    //just one of pairs for such M
    public Integer[] getPair(Map<Integer, Set<Integer>> allPairs) {
        Integer[] pair = new Integer[2];
        for (int a = 1; a < allPairs.size(); a++) {
            Set<Integer> bs = allPairs.get(a);
            Integer b = (Integer) bs.toArray()[0];
            pair[0] = a;
            pair[1] = b;
            return pair;
        }
        return null;
    }

    //find one of pairs for G
    public Integer[] findG(Map<Integer, Set<Integer>> EM) {
        Integer[] g = new Integer[2];
        for (int a = 3; a < EM.size(); a++) {
            Set<Integer> bs = EM.get(a);
            if (bs != null) {
                Integer b = (Integer) bs.toArray()[0];
                g[0] = a;
                g[1] = b;
                return g;
            }
        }
        return null;
    }

    private boolean checkMod(int a, int b) {
        return (4 * a * a * a + 27 * b * b) % m != 0;
    }
}
