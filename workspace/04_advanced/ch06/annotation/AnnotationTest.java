package ch06.annotation;

import java.lang.reflect.InvocationTargetException;

public class AnnotationTest {
    void main() throws InvocationTargetException, IllegalAccessException {
        Work w = new Work();
//        w.task1();
//        w.task2();

        TimeProcessor processor = new TimeProcessor();
        processor.process(w);
    }
}
