package ch12.family.ex02;

// Son이 Parent의 필드와 메서드를 상속 받는다.
public class Son extends Parent {

    Son(String name){
        // 부모클래스를 super라고 한다
        // 부모의 생성자 호출
        super(name);
    }
    // 오버라이딩: 상속받은 메서드의 기능을 재정의하는 것을 말한다.
    void play(){
        work();
        System.out.println(name + ": 게임을 한다.");
    }
    private void work(){
        System.out.println(name + ": 일한다.");
    }

    public void study(){
        System.out.println(name + ": 도서관에서 공부한다.");
    }

}
