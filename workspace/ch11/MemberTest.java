package ch11;

public class MemberTest {
    String id;

    MemberTest(){

    }
    // 생성자 정의
    MemberTest(String name){
        this.id = name;
    }

    // 이 예제에서만 JVM이 void main()으로 하면 main을 못 찾는다.
    // 해결 방법
    // 1. 기본생성자 만들기
    // 2. void main()에 static을 넣어서
    // 프로그램 시작하자마자 메모리에 할당하게 하기
//    public static void main(String[] args){
//        MemberTest member = new MemberTest("young");
//        System.out.println("회원 아이디: "+member.id);
//    }

    // void main()은 인스턴스 메서드(객체 메서드)이기 때문에
    // 객체가 있어야 호출할 수 있다.
    // void main을 생성할려면 JVM이 먼저 객체를 생성해야하고
    // 객체를 생성하려면 기본 생성자가 필요하다.
    // static은 고정 시키는 변수여서 static 키워드를 main앞에 넣는다면
    // 프로그램 시작시 메모리에 할당이 된다.
    void main(){
        MemberTest member = new MemberTest("young");
        System.out.println("회원 아이디: "+member.id);
    }
}
