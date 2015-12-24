package uk.co.block17.starter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplyTest {

    public MultiplyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass - I run first before any tests.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass - I run last after all tests are finished.");
    }

    @Before
    public void setUp() {
        System.out.println("setUp - I run before each test.");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown - I run after each test.");
    }

    @Test
    public void testTwoPositive() {
        System.out.println("testTwoPositive");
        assertTrue(SimpleLib.MultiplyTwo(3, 5).equals(15));
    }

    @Test
    public void testOnePositiveOneNegative() {
        System.out.println("testOnePositiveOneNegative");
        assertTrue(SimpleLib.MultiplyTwo(3, -6).equals(-18));
        assertTrue(SimpleLib.MultiplyTwo(-3, 7).equals(-21));
    }

    @Test
    public void testTwoNegative() {
        System.out.println("testTwoNegative");
        assertTrue(SimpleLib.MultiplyTwo(-2, -6).equals(12));
    }

    @Test
    public void testZero() {
        System.out.println("testZero");
        assertTrue(SimpleLib.MultiplyTwo(0, 6).equals(0));
        assertTrue(SimpleLib.MultiplyTwo(7, 0).equals(0));
        assertTrue(SimpleLib.MultiplyTwo(0, 0).equals(0));
    }
}
