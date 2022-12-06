package lambda;

public class ContainsAnalyzer implements MyAnalyzer<String>{
    @Override
    public boolean analyzer(String search, String target) {
        return target.contains(search);
    }
}
