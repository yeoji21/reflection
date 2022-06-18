package exercises;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;

        Map<String, Integer> mapObject = new HashMap<>();
        Class<?> hashMapClass = mapObject.getClass();

        Class<?> squareClass = Class.forName("exercises.Main$Square");

//        printClassInfo(stringClass, hashMapClass, squareClass);

        var circleObject = new Drawable() {
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };

        printClassInfo(Collection.class, boolean.class, int[][].class, Color.class, circleObject.getClass());
    }

    private static void printClassInfo(Class<?>... classes) {
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getSimpleName() + ", " + clazz.getPackageName());

            Class<?>[] implementedInterfaces = clazz.getInterfaces();
            for (Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(clazz.getSimpleName() + " implements " + implementedInterface.getSimpleName());
            }

            System.out.println("is array" + clazz.isArray());
            System.out.println("is primitive" + clazz.isPrimitive());
            System.out.println("is enum" + clazz.isEnum());
            System.out.println("is interface" + clazz.isInterface());
            System.out.println("is anonymous " + clazz.isAnonymousClass());

            System.out.println();
        }
    }


    private static class Square implements Drawable{
        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private interface Drawable{
        int getNumberOfCorners();
    }

    private enum Color{
        BLUE,
        RED,
        GREEN
    }
}
