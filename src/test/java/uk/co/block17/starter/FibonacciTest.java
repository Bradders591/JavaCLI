package uk.co.block17.starter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTest {

    public FibonacciTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFibonacciZeroReturnsZero() {
        System.out.println("testFibonacciZeroReturnsZero");
        assertTrue(SimpleLib.Fibonacci(0).equals(0));
    }

    @Test
    public void testFibonacciOneReturnsOne() {
        System.out.println("testFibonacciOneReturnsOne");
        assertTrue(SimpleLib.Fibonacci(1).equals(1));
    }

    @Test
    public void testFibonacciTwoReturnsOne() {
        System.out.println("testFibonacciTwoReturnsOne");
        assertTrue(SimpleLib.Fibonacci(2).equals(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumbersNotAllowed() {
        Integer f = SimpleLib.Fibonacci(-1);
    }

    @Test
    public void testComparisonWithNonRecursiveVersion() {
        System.out.println("testComparisonWithNonRecursiveVersion");
        assertTrue(SimpleLib.FibonacciNonRecursive(8).equals(SimpleLib.Fibonacci(8)));
    }
}
