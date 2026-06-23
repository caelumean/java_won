package ch02;

import java.util.*;

public class MapTest {
    void main(){

        // 키-값으로 사용할 것을 알려줄 수 있다.
        // 제<String, String네릭을 쓰면 좀 더 편안하게 사용할 수 있다.
        // 타입추론: 왼쪽것을 따라서 너가 추론해봐
//        Map<String, String> fruits = new HashMap<>();
//        Map<String, String> fruits = new TreeMap<>();
        Map<String, String> fruits = new LinkedHashMap<>();


        fruits.put("월","바나나");
        fruits.put("화","사과");
        fruits.put("수","오렌지");
        fruits.put("목","파인애플");
        fruits.put("수","수박");
        fruits.put("금","aPPlE");

        // 부모를 자식으로 변환할려면 명시적으로 형변환을 사용해야한다.
        String fridayFruit =fruits.get("금").toUpperCase();
        System.out.println("금요일에 먹을 과일: " + fridayFruit);

        printFruits(fruits);
    }

    // 전달받은 과일목록을 출력한다.
    void printFruits(Map<String, String> fruits){
        System.out.println("월요일에 먹을 과일: " + fruits.get("월"));
        System.out.println("수요일에 먹을 과일: " + fruits.get("수"));
        System.out.println("화요일에 먹을 과일: " + fruits.get("화"));

        System.out.println("요일별 모든 과일 출력");

        for(Map.Entry<String, String> entry : fruits.entrySet()){
            String key = entry.getKey();
            String fruit = entry.getValue();
            System.out.println(key + ": " + fruit);
        }
    }
}