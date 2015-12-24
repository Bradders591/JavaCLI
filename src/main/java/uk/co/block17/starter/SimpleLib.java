package uk.co.block17.starter;

public class SimpleLib {

    // take two integers and return the value of one multiplied by the other
    // without using the multiply operator
    public static Integer MultiplyTwo(Integer first, Integer second) {
        Integer result = 0;

        // use the positive values of the paramters to calculate the total
        for (int i = 1; i <= Math.abs(first); i++) {
            result += Math.abs(second);
        }

        // if one parameter is negative then flip the sign of the result
        if (first.compareTo(0) < 0) {
            result = -result;
        }
        // if both parameters are negative then flip the sign of the result back
        if (second.compareTo(0) < 0) {
            result = -result;
        }
        return result;
    }

    public static Integer Fibonacci(Integer n) {
        if (n.compareTo(0) < 0) {
            throw new IllegalArgumentException("N Parameter cannot be negative.");
        }
        if (n.equals(0)) {
            return 0;
        }
        if (n.equals(1)) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static Integer FibonacciNonRecursive(Integer n) {
        if (n.compareTo(0) < 0) {
            throw new IllegalArgumentException("N Parameter cannot be negative.");
        }
        if (n.equals(0)) {
            return 0;
        }
        if (n.equals(1)) {
            return 1;
        }
        Integer prev = 1;
        Integer prevPrev = 0;
        Integer answer = 0;

        for (int i = 2; i <= n; i++) {
            answer = prev + prevPrev;
            prevPrev = prev;
            prev = answer;
        }

        return answer;
    }

    public static void BubbleSort(Integer array[]) {
        int n = array.length;
        Integer temp;
        for (int b = 0; b < n; b++) {
            for (int f = 0; f < n - 1; f++) {
                if (array[f] > array[f + 1]) {
                    temp = array[f];
                    array[f] = array[f + 1];
                    array[f + 1] = temp;
                }
            }
        }
    }

    public static void PrintArray(Integer array[]) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + (i + 1 == n ? "" : ", "));
        }
        System.out.println();
    }
}
