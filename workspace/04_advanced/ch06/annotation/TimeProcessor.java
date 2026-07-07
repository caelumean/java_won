package ch06.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeProcessor {
    public void process(Object target) throws InvocationTargetException, IllegalAccessException {
        // target 객체에 정의된 모든 메서드 목록
        Method[] methods = target.getClass().getDeclaredMethods();

        // 각 메서드를 순회
        for (Method method : methods){
            long start = System.currentTimeMillis();
            // 어노테이션 객체 정보 확인
            if(method.isAnnotationPresent(MeasureTime.class)){
                MeasureTime measureTime = method.getAnnotation(MeasureTime.class);
                String taskName = measureTime.taskName().isEmpty() ?  method.getName() : measureTime.taskName();
                try {
                    // 해당 메서드를 호출한다.
                    method.invoke(target);
                } catch (Exception e) {
                    System.out.println("대상 메서드 호출 예외: " + e.getMessage());
                }
                long end = System.currentTimeMillis();
                System.out.println(taskName+" 소요 시간: " +(end - start) + "ms");

            }
        }

    }
}
