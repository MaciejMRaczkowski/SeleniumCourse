package junit;

import org.junit.jupiter.api.*;

public class JunitAnnotations {

    @BeforeAll
    public static void classSetUp(){
        System.out.println("classSetUp()");
    }

    @AfterAll
    public static void classTearDown(){
        System.out.println("classTearDown()");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("setUp()");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("tearDown()");
    }

    @Test
    public void testA() {
        System.out.println("testA()");
    }

    @Test
    public void testB() {
        System.out.println("testB()");
    }

    @Test
    public void testAssertionA() {
        System.out.println("testAssertionA()");

        Assertions.assertEquals(100, 100, "Kwota nie jest prawidlowa!");
        Assertions.assertTrue(true);
    }

    @Disabled("Wylaczony z jakiegos powodu")
    @Test
    public void testC() throws Exception {
        throw new Exception();
        //System.out.println("testC()");
    }
}
