package ch07;

public class Calculator {
    int add(int n1, int n2){
        return n1 + n2;
    }
    double divide(int n1, int n2){
        if(n2 == 0) throw new ArithmeticException();
        return Math.round(((double) n1 / n2) * 100) / 100.0;
    }
}
