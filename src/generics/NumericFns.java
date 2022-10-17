package generics;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

class NumericFns<T extends Number> {
    T num;

    // Pass the constructor a reference to
    // a numeric object.
    NumericFns(T n) {
        num = n;
    }

    // Return the reciprocal.
    double reciprocal() {
        return 1 / num.doubleValue();
    }

    // Return the fractional component.
    double fraction() {
        return num.doubleValue() - num.intValue();
    }

    boolean absEqual(NumericFns<?> ob) {
        if (Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue())) return true;

        return false;
    }

    // ...
}


// Demonstrate NumericFns.
class Main3 {
    public static void main(String args[]) {
//
//        NumericFns<Integer> iOb =
//                new NumericFns<Integer>(5);
//
//        System.out.println("Reciprocal of iOb is " +
//                iOb.reciprocal());
//        System.out.println("Fractional component of iOb is " +
//                iOb.fraction());
//
//        System.out.println();
//
//        NumericFns<Double> dOb =
//                new NumericFns<Double>(5.25);
//
//        System.out.println("Reciprocal of dOb is " +
//                dOb.reciprocal());
//        System.out.println("Fractional component of dOb is " +
//                dOb.fraction());
        NumericFns<Integer> ob1 = new NumericFns<>(6);
        NumericFns<Double> ob2 = new NumericFns<>(-6d);
        NumericFns<Long> ob3 = new NumericFns<>(-6L);
        System.out.println(ob1.absEqual(ob2));
        System.out.println(ob2.absEqual(ob3));
        NumericFns<BigDecimal> ob4 = new NumericFns<>(new BigDecimal("-6"));
        System.out.println(ob2.absEqual(ob4));

        Set<Apple> basket = new HashSet<>();
        basket.add(new Gala());
        basket.add(new Gala());
        basket.add(new Gala());
        basket.add(new Gala());
        basket.forEach(new Consumer<Apple>() {
            @Override
            public void accept(Apple apple) {
                System.out.println(apple);
            }
        });
        basket.forEach(apple -> System.out.println(apple));
    }
}
