package lambda;

public class MyNumberPredicate {
    public static <T extends Number> Boolean isPrime(T n) {
        if (n.intValue() < 2) return false;
        for (int i = 2; i <= n.intValue() / i; i++) {
            if ((n.intValue() % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
