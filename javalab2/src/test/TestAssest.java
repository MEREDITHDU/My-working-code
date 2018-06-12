package test;

import java.util.*;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.core.CombinableMatcher;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Sample test showing different test cases
 *
 * @author Gall Anonim
 * @version 1.0
 *
 */
public class TestAssest {

    @SuppressWarnings("unused")
	@Test
    public void testFlowControl() {
        if ((2 + 2) != 4) {
            fail("Error in adding!");
            //assertTrue( "Error in adding!", false );
            //assertFalse( "Error in adding!", true );
            //assert false: "Error in adding!";
        }

        int x = 4;
        switch (x) {
            case 5:
                ;
            case 4:
                ;
            case 3:
                ;
            case 2:
                break;
            default:
                fail("Lack of positive number!");
        }
    }

    @Test
    public void testEquals() {
        int x = 4;
        int y = 2 + 2;
        float z = 4.001f;
        assertEquals("Variable values ​​are not the same!", x, y);
        assertEquals("Variable values ​​differ by more than 0.01!", x, z, 0.01);
    }

   
    public void testArrayEquals() {
        int tab1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int tab2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals("Collections values ​​in both arrays are not identical!", tab1, tab2);
    }

    @Test
    public void testReferences() {
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = null;

        assertNotSame("References point to the same object!", object1, object2);
        assertNotSame("References point to the same object!", object1, object3);
        assertNotNull("Reference to null!", object1);
        assertNotNull("Reference to null!!", object2);
        assertNull("Reference not null!", object3);
        object3 = object1;
        assertSame("References do not indicate the same object!", object1, object3);
    }

    @Test
    public void testAssertThat() {
        int x = 3;
        assertThat("x is 3", x, is(3));
        assertThat(x, is(not(4)));

        List<Integer> list = new LinkedList<>();
        list.add(x);
        assertThat(list, hasItem(3));

        String color = "my colors";
        assertThat(color, either(containsString("color")).or(containsString("colour"))
        ); 
        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(CombinableMatcher.<Integer>either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }

    @Test
    public void testExceptionUsingTryCatch() {
        try {
            //float x = 1 / 0;
            float y = 1/0f;
            fail("Should have thrown an exception");
        } catch (ArithmeticException e) {
        }
    }

    @Test(expected = ArithmeticException.class)
    public void testException() {
       // float x = 1 / 0;
         float y = 1/0f;
        fail("Should have thrown an exception");
    }

    @Test(timeout = 1000)
    public void testPerformance() {
        int j;
        for (int i = 0; i < 100000000; i++) {
            j = i + 1;
        }
    }
}
