package ua.yet.adv.java.generics;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestRawTypes {

    @Test
    public void testAddToRawList() {
        List rawList = new ArrayList();
        List<String> stringList = new ArrayList<>();

        rawList = stringList;
        rawList.add(8); // warning, no runtime error
        
        assertFalse(rawList.isEmpty());
        assertFalse(stringList.isEmpty());
    }
    
    @Test (expected = ClassCastException.class)
    public void testFailOnGettingValue() {
        List rawList = new ArrayList();
        List<String> stringList = new ArrayList<>();

        rawList = stringList;
        rawList.add(8); // warning, no runtime error
        
        String str = stringList.get(0); // ClassCastException
        
        fail("No exception. Strange...");
    }

}
