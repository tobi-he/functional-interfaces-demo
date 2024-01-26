package org.example.demo;

import org.example.demo.operator.AddOperator;
import org.example.demo.operator.MyOperator;

import java.util.Random;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args){
        AddOperator addOperator = new AddOperator();

        // ==========================================
        // Using an own functional interface
        // => interface must have exactly one method
        // ==========================================
        withRandomNumbers(addOperator);
        withRandomNumbers(new MyOperator() {
            @Override
            public int compute(int x, int y) {
                return x+y;
            }
        });

        withRandomNumbers((x,y) -> x+y);
        withRandomNumbers((x,y) -> {
            // do something or write a comment
            return x+y;
        });

        withRandomNumbers(Main::doAnOperation);

        // ==========================================================================================
        // Without an own interface, just using functional interfaces provided by java.util.function
        // ==========================================================================================
        withRandomNumbersJavaUtil(addOperator::compute);
        withRandomNumbersJavaUtil(Main::doAnOperation);
    }

    private static void withRandomNumbers(MyOperator operator) {
        Random random = new Random();
        int x = random.nextInt(100);
        int y=random.nextInt(100);
        int result=operator.compute(x,y);
        System.out.println(String.format("x=%s, y=%s, result=%s", x, y, result));
    }

    private static void withRandomNumbersJavaUtil(BiFunction<Integer, Integer, Integer> operator) {
        Random random = new Random();
        int x = random.nextInt(100);
        int y=random.nextInt(100);
        int result=operator.apply(x,y);
        System.out.println(String.format("x=%s, y=%s, result=%s", x, y, result));
    }

    private static int doAnOperation(int x, int y) {
        return x+y;
    }
}
