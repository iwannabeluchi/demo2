package test.example.demo2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    private Calculator calculator;


    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting a new test...");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test finished.");
    }
    

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    // JUnit5 参数化测试：使用 @MethodSource 提供多组可变长度数组和期望值
    @ParameterizedTest
    @MethodSource("provideArrays")
    void parameterizedAddVarArgs(int[] numbers, int expected) {
        assertEquals(expected, calculator.add(numbers));
    }
    static Stream<Arguments> provideArrays() {
        return Stream.of(
                Arguments.of(new int[]{1, 1}, 2),
                Arguments.of(new int[]{1, 2}, 3),
                Arguments.of(new int[]{2, 3}, 5),
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{4, 5, 6, 7}, 22)
        );
    }


    @Test
    @Tag("dev")
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }
    
    @DisabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
    }

    @Test
    void testTime() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            for (int i = 0; i < 1000000; i++) Math.sqrt(i);
        });
    }

    @RepeatedTest(value = 3, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
    @DisplayName("重复测试加法方法")
    void testRepeated() {
        System.out.println("Running repeated test for add method");
    }

    @Test
    @Tag("Dev")
    void testAssert(){
        fail();
        assertTrue(5 > 2, "5 should be greater than 2");
    }

}