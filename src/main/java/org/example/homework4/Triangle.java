package org.example.homework4;

public class Triangle {

    public double triangleArea(int a, int b, int c) throws MyException {

        if(a + b < c || b + c < a || a + c < b) throw new MyException();
        if(a < 0 || b < 0 || c < 0) throw new MyException();
        if(a == 0 || b == 0 || c == 0) throw new MyException();
        int p = (a + b + c) / 2;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;

    }

}
