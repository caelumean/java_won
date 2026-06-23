package ch02.list;

public class PerformanceTest {

    void main(){
        int times = 10000;

        // Array list는 맨 뒤에 넣는게 성능이 가장 좋다.
        // Linked list는 맨 앞에 넣는게 성능이 가장 좋다
        MyArry list = new MyArry();
//        MyLinkedList list = new MyLinkedList();

        long start = System.currentTimeMillis();
//        addFirst(list, times);
        addLast(list, times);
        System.out.println("저장된 수: "+ list.size());
        long end = System.currentTimeMillis();
        System.out.println("MyArray addFirst 소요 시간: " + (end - start) +"ms");
    }

    // list를 이용해서 맨 앞에 times 만큼의 데이터를 추가한다.
    void addFirst(MyList list, int times){
        for(int i = 0; i < times; i++){
            list.add(0,"데이터-" + i);

        }
    }
    void addLast(MyList list, int times){
        for(int i = 0; i < times; i++){
            list.add("데이터-" + i);

        }
    }

}
