package uk.co.block17.starter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciNonRecursiveTest {

    public FibonacciNonRecursiveTest() {
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
    public void testFibonacciNRZeroReturnsZero() {
        System.out.println("testFibonacciNRZeroReturnsZero");
        assertTrue(SimpleLib.FibonacciNonRecursive(0).equals(0));
    }

    @Test
    public void testFibonacciNROneReturnsOne() {
        System.out.println("testFibonacciNROneReturnsOne");
        assertTrue(SimpleLib.FibonacciNonRecursive(1).equals(1));
    }

    @Test
    public void testFibonacciNRTwoReturnsOne() {
        System.out.println("testFibonacciNRTwoReturnsOne");
        assertTrue(SimpleLib.FibonacciNonRecursive(2).equals(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNRNegativeNumbersNotAllowed() {
        System.out.println("testNRNegativeNumbersNotAllowed");
        Integer f = SimpleLib.FibonacciNonRecursive(-1);
    }
    
    @Test
    public void testComparisonWithRecursiveVersion(){
        System.out.println("testComparisonWithRecursiveVersion");
        assertTrue(SimpleLib.Fibonacci(6).equals(SimpleLib.FibonacciNonRecursive(6)));
    }
}
