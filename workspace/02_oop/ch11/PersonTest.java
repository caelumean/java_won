package ch11;

public class PersonTest {

    void main(){
        // heap영역에 Person클래스 메모리 영역을 할당하고 주소를 반환한다
        // stack에 main에 Person타입의 p에 주소를 저장한다.
        Person p = new Person();
        p.name = "하루";
        p.age = 6;


        p.intruduce();
    }
}
