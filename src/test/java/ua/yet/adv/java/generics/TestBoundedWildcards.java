package ua.yet.adv.java.generics;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import ua.yet.adv.java.generics.domain.Camera;
import ua.yet.adv.java.generics.domain.Container;
import ua.yet.adv.java.generics.domain.Phone;

public class TestBoundedWildcards {
    
    private Container<Camera> cameraContainer;
    
    @Before
    public void setup() {
        cameraContainer = new Container<Camera>(new Camera("camera"));
    }

    @Test
    public void test() {
        Collection<Camera> cams = new ArrayList<>();
        Collection<Camera> cams2 = new ArrayList<>();
        
        cameraContainer.copy(cams, cams2);
        Container.copyStatic(cams, cams2);
        
        Collection<Object> objects = new ArrayList<>();
        
        cameraContainer.copy(cams, objects);
        Container.copyStatic(cams, objects);
        
        Collection<Serializable> serializableObjects = new ArrayList<>();
        
        cameraContainer.copy(cams, serializableObjects);
        Container.copyStatic(cams, serializableObjects);
        
        Collection<Phone> phones = new ArrayList<>();
        // cameraContainer.copy(cams, phones);    - compile error
        // Container.copyStatic(cams, phones);    - compile error
    }

}
