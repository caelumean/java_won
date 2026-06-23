package ch02;

import java.util.*;

public class CollectionTest {
    void main(){
//        String[] fruits = new String[5];
//        fruits[0] = "바나나";
//        fruits[1] = "사과";
//        fruits[2] = "오렌지";
//        fruits[3] = "파인애플";
//        fruits[4] = "수박";

//        ArrayList<String> fruits = new ArrayList<>();
//        LinkedList<String> fruits = new LinkedList<>();
//        Vector<String> fruits = new Vector<>();

//        HashSet<String> fruits = new HashSet<>();
//        TreeSet<String> fruits = new TreeSet<>();
        LinkedHashSet<String> fruits = new LinkedHashSet<>();

        fruits.add("바나나");
        fruits.add("사과");
        fruits.add("오렌지");
        fruits.add("파인애플");
        fruits.add("수박");
        fruits.add("사과");

        printFruits(fruits);
    }

    // 전달받은 과일목록을 출력한다.
    void printFruits(String[] fruits){
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }

    void printFruits(ArrayList<String> fruits){
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }

    void printFruits(LinkedList<String> fruits){
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }

    void printFruits(Vector<String> fruits){
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }

    void printFruits(HashSet<String> fruits){
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }

    void printFruits(TreeSet<String> fruits){
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }
}