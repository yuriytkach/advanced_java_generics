package ua.yet.adv.java.generics;

import java.util.Collection;
import java.util.List;

/**
 * A class to showcase the type erasure. If the instance of this class is
 * created with generics, then compiler uses generics to check types in methods
 * and weaves method correctly. If the instance of this class is created without
 * generics (i.e. raw type), then compiler ignores generics in methods and can
 * weave calls incorrectly.
 * 
 * See {@link TestSomeType} for usages and showcases
 * 
 * @author Yuriy_Tkach
 *
 * @param <T>
 *            Some type. Unused in the logic
 */
public class SomeType<T> {

    public <E> void test(final Collection<E> collection) {
        for (final E object : collection) {
            System.out.println("E: " + object);
        }
    }

    public void test(final List<Integer> integerList) {
        int result = 0;
        for (final Integer integer : integerList) {
            result += integer.intValue();
        }
        System.out.println("result: " + result);
    }

}
