package util;

public class MathUtils {
    public static int mod(int number, int m) {
        return number % m > 0 ? number % m : m + (number % m);
    }
}
