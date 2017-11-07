package group;

import report.ConsoleReport;
import util.MathUtils;

import java.util.Random;

public class ExchangeKeys {
    private int m;
    private int a;
    private Integer[] G;

    public ExchangeKeys(int m, int a, Integer[] g) {
        this.m = m;
        this.a = a;
        this.G = g;
    }

    public int secretKey() {
        int key = new Random().nextInt() % (m - 2);
        return key > 0 ? key : Math.abs(key) + 1;
    }

    public Integer[] openKey(int secretKey) {
        return mul(secretKey, G);
    }

    public Integer[] bothKey(int number, Integer[] key){
        return mul(number, key);
    }

    private Integer[] mul(int num, Integer[] p) {
        Integer[] q = new Integer[]{p[0], p[1]};
        for (int i = 0; i < num - 1; i++) {
            p = sum(p, q);
        }
        return p;
    }

    private Integer[] sum(Integer[] p, Integer[] q) {
        int lambda = 0;
        if (p[0].equals(q[0]) && p[1].equals(q[1])) {
            int right = MathUtils.mod((3 * p[0] * p[0] + a), m);
            for (int i = 1; i < 10000; i++) {
                if (MathUtils.mod((2 * p[1]) * i, m) == right) {
                    lambda = i;
                    break;
                }
            }
        } else {
            int right = MathUtils.mod(q[1] - p[1], m);
            for (int i = 1; i < 10000; i++) {
                if (MathUtils.mod((q[0] - p[0]) * i, m) == right) {
                    lambda = i;
                    break;
                }
            }
        }
        int x = MathUtils.mod(lambda * lambda - p[0] - q[0], m);
        int y = MathUtils.mod((- p[1] + lambda * (p[0] - x)), m);
        return new Integer[]{x, y};
    }

}
