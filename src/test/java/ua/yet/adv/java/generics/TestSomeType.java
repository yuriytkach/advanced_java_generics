package ua.yet.adv.java.generics;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ua.yet.adv.java.generics.TypeErasureComplex.SomeType;

public class TestSomeType {

    @Test(expected = ClassCastException.class)
    public void testClassCastException() {
        final SomeType someType = new SomeType();
        final List<String> list = Arrays.asList("some", "test", "value");
        
        someType.test(list); // ClassCastException, because test(final List<Integer> integerList) is called
        
        fail ("No exception. Strange...");
    }
    
    @Test
    public void testSuccessCall() {
        final SomeType<Object> someType = new SomeType<>();
        final List<String> list = Arrays.asList("some", "test", "value");
        
        someType.test(list); // No exception
        
        final List<Integer> intList = Arrays.asList(1, 2, 3);
        someType.test(intList);
    }

}
