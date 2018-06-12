package test;


import org.junit.*;

/**
 * Sample test showing sequence of test method invocations ATTENTION! Don't
 * print on Java console in a real test!
 *
 * @author Gall Anonim
 * @version 1.0
 *
 */
public class TestSequence {

    @BeforeClass
    public static void oneTimeSetUp() {
        System.out.println("-> a one-time initialization of all tests");
    }

    @Before
    public void init() {
        System.out.println("---> single test launched");
    }

    @Test()
    public void testFirst() {
        System.out.println("-----> first test");
    }

    //@Test
    @Ignore
    public void testSecond() {
        System.out.println("-----> second test");
    }

    @Test
    public void testThird() {
        System.out.println("-----> third test");
    }

    @After
    public void dispose() {
        System.out.println("---> completion of a single test");
    }

    @AfterClass
    public static void oneTimeDispose() {
        System.out.println("-> completion of all tests");
    }
}
