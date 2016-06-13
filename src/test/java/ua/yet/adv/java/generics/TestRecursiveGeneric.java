package ua.yet.adv.java.generics;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.yet.adv.java.generics.domain.Camera;
import ua.yet.adv.java.generics.domain.Phone;

public class TestRecursiveGeneric {

    @Test
    public void testCamera() {
        Camera cam1 = new Camera("camera");
        cam1.setPixel(10);
        Camera cam2 = new Camera("camera");
        cam2.setPixel(5);
        
        assertTrue(cam1.compareTo(cam2) > 0);
    }
    
    @Test
    public void testWithPhone() {
        Phone phone1 = new Phone("phone");
        phone1.setModel("a");
        Phone phone2 = new Phone("phone");
        phone2.setModel("b");
        
        assertTrue(phone1.compareTo(phone2) < 0);
    }
    
    @Test(expected = ClassCastException.class)
    public void testFailedCompilation() {
        Camera cam1 = new Camera("camera");
        Phone phone1 = new Phone("phone");
        
        // cam1.compareTo(phone1);              - Compilation error
        
        cam1.compareTo((Camera)((Object)phone1)); // ClassCastException
        
        fail("No exception. Strange...");
    }

}
