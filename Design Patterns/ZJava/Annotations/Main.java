package ZJava.Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Cat nyCat = new Cat("Doug");

        if(nyCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("Very Important Annotation is present");
        } else {
            System.out.println("Very Important Annotation is not present");
        }

        for(Method method: nyCat.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(RunImmediately.class)) {
                try {
                    RunImmediately runImmediately = method.getAnnotation(RunImmediately.class);
                    int times = runImmediately.times();
                    while (times-- > 0) {
                        method.invoke(nyCat);   
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } 
        }

        for(Field field: nyCat.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(ImportantString.class)) {
                Annotation importantString = field.getAnnotation(ImportantString.class);
                try {
                    System.out.println(field.get(nyCat).toString().toUpperCase());
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
