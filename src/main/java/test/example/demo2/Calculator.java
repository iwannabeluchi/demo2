package test.example.demo2;

public class Calculator {
    
    // 可变参数加法，支持任意数量的整数相加
    public int add(int... nums) {
        int sum = 0;
        if (nums != null) {
            for (int n : nums) sum += n;
        }
        return sum;
    }
    
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return a / b;
    }
}