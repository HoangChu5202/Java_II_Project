package lambda;

@FunctionalInterface
public interface MyAnalyzer<T> {
    boolean analyzer(T search, T target);

}
