package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Prob01 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        // 1. 참가자 명단 구선
        for(String name: participant){
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 2. 완주 명단 제외
        for(String name: completion){
            map.put(name, map.get(name) - 1);
        }

        // 3. 미완주 선수 반환
        for(String name: map.keySet()){
            if(map.get(name) != 0 ){
                answer = name;
            }
        }
        return answer;
    }

    void main(){
        String[] participant = {"hello", "world", "hello", "java"};
        String[] completion = {"hello", "world", "java"};
        String result = solution(participant, completion);
        if(result.equals("hello")){
            System.out.println("통과");
        }else{
            System.out.println(result);
        }
    }

}
