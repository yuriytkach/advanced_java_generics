package ua.yet.adv.java.generics;

import java.io.Serializable;

import org.junit.Test;

import ua.yet.adv.java.generics.domain.Camera;
import ua.yet.adv.java.generics.domain.Phone;
import ua.yet.adv.java.generics.domain.Product;

public class TestContainers {
    
    static class ContainerSimple<T extends Product<T>> {
    }

    static class ContainerStrict<T extends Product<T> & Serializable> {
    }
    
    @Test
    public void test() {
        ContainerSimple<Camera> cs1;
        ContainerSimple<Phone> cs2;

        ContainerStrict<Camera> ct2;
        // ContainerStrict<Phone> ct3; - Compile Error: Phone does not implement Serializable
    }

}
