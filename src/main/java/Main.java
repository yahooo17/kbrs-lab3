import group.EliptGroup;
import group.ExchangeKeys;
import params.EliptGroupParams;
import report.ConsoleReport;

import java.util.Map;
import java.util.Set;

public class Main {
    private static final int M = 67;

    public static void main(String[] args) {
        ConsoleReport report = new ConsoleReport();
        EliptGroupParams eliptGroupParams = new EliptGroupParams(M);
        Map<Integer, Set<Integer>> pairs = eliptGroupParams.getAllPairs();
        Integer[] ABpair = eliptGroupParams.getPair(pairs);
        int a = ABpair[0];
        int b = ABpair[1];
        report.printParameters(a, b);

        EliptGroup eliptGroup = new EliptGroup(a, b, M);
        Map<Integer, Set<Integer>> elements = eliptGroup.findEM();
        report.printElements(elements);

        Integer[] G = eliptGroupParams.findG(elements);
        report.printG(G);

        ExchangeKeys exchangeKeys = new ExchangeKeys(M, a, G);
        int nA = exchangeKeys.secretKey();
        int nB = exchangeKeys.secretKey();
        report.printSecretKeys(nA, nB);

        Integer[] PA = exchangeKeys.openKey(nA);
        Integer[] PB = exchangeKeys.openKey(nB);
        // тут должны быть векторы из EM, если правильно сработает
        report.printOpenKeys(PA, PB);

        Integer[] KA = exchangeKeys.bothKey(nA, PB);
        Integer[] KB = exchangeKeys.bothKey(nB, PA);
        // а тут должны быть 2 одинаковых, если правильно сработает
        report.printhBothKey(KA);
        report.printhBothKey(KB);
    }
}
