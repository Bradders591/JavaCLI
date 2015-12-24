package uk.co.block17.starter;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortTest {

    public BubbleSortTest() {
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
    public void testBubbleSort() {
        System.out.println("testBubbleSort");
        Integer[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        Integer[] expectedOutput = new Integer[input.length];

        // make a copy of the unsorted input array
        System.arraycopy(input, 0, expectedOutput, 0, input.length);
        // sort it using the Java built-in functionality
        Arrays.sort(expectedOutput);

        // for human sanity checking
        System.out.print("input: ");
        SimpleLib.PrintArray(input);
        SimpleLib.BubbleSort(input);

        System.out.print("sorted input: ");
        SimpleLib.PrintArray(input);
        System.out.print("expected output: ");
        SimpleLib.PrintArray(expectedOutput);

        assertTrue(Arrays.equals(input, expectedOutput));
    }
}
