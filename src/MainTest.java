
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

    @Test
    public void test() {

        // Test x^2
        assertEquals(1, sqr(1));
        assertEquals(4, sqr(2));
        assertEquals(9, sqr(3));
        assertEquals(16, sqr(4));
        assertEquals(25, sqr(5));

        // Test facultaet
        assertEquals(1, fac(1));
        assertEquals(2, fac(2));
        assertEquals(6, fac(3));
        assertEquals(24, fac(4));
        assertEquals(120, fac(5));

        // Test x^x+1
        assertEquals(1, powU(1));
        assertEquals(8, powU(2));
        assertEquals(81, powU(3));
        assertEquals(1024, powU(4));
        assertEquals(15625, powU(5));

        // Test fibonacci
        assertEquals(1, fib(1));
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(5, fib(5));

    }

    public int sqr(int i) {
        return i * i;
    }

    public int fac(int i) {
        return (i == 0) ? 1 : i * fac(i - 1);
    }

    public int powU(int i) {
        return (int) Math.pow(i, i + 1);
    }

    public int fib(int i) {
        return (i <= 2) ? 1 : fib(i - 1) + fib(i - 2);
    }

}
