package test;

import code.Auto;
import org.junit.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class TestSuite {

    @Test
    public void autoSetDoorsNoTest(){
        Auto a = new Auto(200, 5);
        try{
            a.setDoorNo(-1);
            fail("Method accepts negative values");
        } catch (Exception e) {
            assertEquals("Unexpected error message", "Negative doorNo not allowed", e.getMessage());
        }
    }

    @Test
    public void autoFieldTest() throws ClassNotFoundException {

        Class<?> myClass = Class.forName("code.Auto");
        Field[] myFields = myClass.getDeclaredFields();

        for(int i = 0; i < myFields.length; i++){
            assertTrue("Field is not private", Modifier.isPrivate(myFields[i].getModifiers()));
        }

    }



}
