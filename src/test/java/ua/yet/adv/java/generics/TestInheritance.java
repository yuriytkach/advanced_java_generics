package ua.yet.adv.java.generics;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class TestInheritance {

    @Test
    public void test() {
        List<String> strList = new ArrayList<>();
        Collection<String> strCollection = new ArrayList<>();

        strCollection = strList; // OK: GenericTypes are the same

        print(strCollection);
        print(strList);
    }

    @Test(expected = ClassCastException.class)
    public void testAssignError() {
        List<Object> objList = new ArrayList<>();
        objList.add(new Integer(1));

        List<String> strList = new ArrayList<>();

        // strList = objList;                       - Compile Error: types are different
        // strList = (List<String>) objList;        - Doesn't help: types are different

        strList = (List<String>) ((Object) objList); // Works, but looks crazy, isn't it?

        String number = strList.get(0);             // ClassCastException

        fail("No exception. Strange...");
    }

    @Test(expected = ClassCastException.class)
    public void testCallError() {
        List<Object> objList = new ArrayList<>();
        objList.add(new Integer(1));

        // print(objList);                      - Compile Error: types are different
        // print((Collection<String>) objList); - Doesn't help: types are different

        print((Collection<String>) ((Object) objList)); // - ClassCastException

        fail("No exception. Strange...");
    }

    public static void print(Collection<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }

}
