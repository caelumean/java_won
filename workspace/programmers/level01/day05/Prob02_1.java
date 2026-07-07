package level01.day05;

public class Prob02_1 {
    public int solution(int a, int d, boolean[] included) {

        int result = 0;
        // 등차수열
        // a가 시작점
        for(int i = 0; i < included.length; i++){
            result = included[i] == true ? result + a + (i * d) : result;
        }
        return result;
    }
    void main(){
        // true인 항들만 더할 것
        boolean[] included = {true, false, false, true, true};

        System.out.println(solution(3,4,included));

    }
}
