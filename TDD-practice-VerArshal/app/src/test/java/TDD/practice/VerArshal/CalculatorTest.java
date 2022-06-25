package TDD.practice.VerArshal;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void plus(){
        assertThat(calculator.plus(1,2), is(3));
    }

    @Test
    public void minus(){
        assertThat(calculator.minus(5,2), is(3));
        assertThat(calculator.minus(5,-3), is(8));
    }

    @Test
    public void multiply(){
        assertThat(calculator.multiply(5,3), is(15));
    }

    @Test
    public void fibonacciNormal(){
        assertThat(calculator.fib(0), is(0));
        assertThat(calculator.fib(1), is(1));
        assertThat(calculator.fib(2), is(1));
        assertThat(calculator.fib(3), is(2));
        assertThat(calculator.fib(4), is(3));
        assertThat(calculator.fib(5), is(5));
    }

    @Test
    public void fibonacciError(){
        assertThat(calculator.fib(-1), is(0));
        assertThat(calculator.fib(-100), is(0));
    }

    @Test
    public void fiboArr(){
        int[] numbers = {0,1,1,2,3,5,8,13,21,34,55};

        for (int i = 0; i < numbers.length; i++) {
            assertThat(calculator.fib(i), is(numbers[i]));
        }
    }

    @Test
    public void reFactorFiboArr(){
        int[] numbers = {0,1,1,2,3,5,8,13,21,34,55};

        IntStream.range(0, numbers.length).forEach(i -> {
            assertThat(calculator.fib(i), is(numbers[i]));
        });
    }

    @Test
    public void divide(){
        assertThat(calculator.divide(9,3), is(3F));
        assertThat(calculator.divide(9,0), is(0F));
        assertThat(calculator.divide(4,3), is(4F/3F));
    }
}
