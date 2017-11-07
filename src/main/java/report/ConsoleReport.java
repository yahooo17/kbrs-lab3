package report;

import java.util.Map;
import java.util.Set;

public class ConsoleReport {
    public void printElements(Map<Integer, Set<Integer>> elements) {
        System.out.println("============ EM(a,b)elements =======");
        for (Map.Entry<Integer, Set<Integer>> entry : elements.entrySet()) {
            Set<Integer> y = entry.getValue();
            for (Integer tempY : y) {
                System.out.print("(" + entry.getKey() + "," + tempY + ") ");
            }
            System.out.println();
        }
    }

    public void printParameters(int a, int b) {
        System.out.println("============= Parameters ===========");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    public void printSecretKeys(int keyA, int keyB) {
        System.out.println("============ Secret keys ============");
        System.out.println("key A: " + keyA);
        System.out.println("key B: " + keyB);
    }

    public void printOpenKeys(Integer[] pa, Integer[] pb) {
        System.out.println("============ Open keys ==============");
        System.out.println("PA: (" + pa[0] + "," + pa[1] + ")");
        System.out.println("PB: (" + pb[0] + "," + pb[1] + ")");
    }

    public void printG(Integer[] g) {
        System.out.println("============= G ================");
        System.out.println("(" + g[0] + "," + g[1] + ")");
    }

    public void printhBothKey(Integer[] key){
        System.out.println("============ Shared for both key ======");
        System.out.println("(" + key[0] + "," + key[1] + ")");
    }
}
