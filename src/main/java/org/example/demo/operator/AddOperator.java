package org.example.demo.operator;

public class AddOperator implements MyOperator{
    @Override
    public int compute(int x, int y) {
        return x+y;
    }
}
