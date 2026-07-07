package ch07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorJUnitTest {
    private static Calculator calc;

    // 전체 테스트에서 딱 한번만 실행되게 하고 싶을때
    @BeforeAll
    static void setUp(){
        calc = new Calculator();
    }

//    @BeforeEach
//    void setUp(){
//        calc = new Calculator();
//    }

    // 단위테스트에 사용할 메서드야
    @Test
    @DisplayName("두 정수의 덧셈 검증 2, 3")
    void add(){
        int result = calc.add(2, 3);
        assertEquals(5, result, "덧셈의 결과는 5여야함");
    }
    @Test
    @DisplayName("두 정수의 덧셈 검증 3, 4")
    void add_3_4(){
        int result = calc.add(3, 4);
        assertEquals(7, result,"덧셈의 결과는 7여야함");
//        if(result == 7){
//            // 기대값 7, 기대값과 실제값을 비교해서 일치하면 성공, 아니면 실패
//            System.out.println("두 정수의 덧셈 검증 성공");
//        }else{
//            System.err.println("덧셈의 결과는 7여야함");
//
//        }
    }


    @Test
    @DisplayName("두 정수의 나눗셈")
    void divide(){
        double result = calc.divide(10,6);
        assertEquals(1.67,result,"나눗셈 결과는 1.67여야함");

    }
    @Test
    @DisplayName("0으로 나누기 테스트")
    void divide_byZero(){
        double result;
        assertThrows(ArithmeticException.class,() -> {
            calc.divide(10, 0);
        });
    }
    void main(){
        setUp();
        add();
        add_3_4();
        divide();
        divide_byZero();

    }

}
