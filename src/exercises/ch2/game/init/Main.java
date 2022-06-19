package exercises.ch2.game.init;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
    }

    public static <T> T createObjectRecursively(Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = getFirstConstructor(clazz);
        List<Object> constructorArguments = new ArrayList<>();

        for (Class<?> parameterType : constructor.getParameterTypes()) {
            Object objectType = createObjectRecursively(parameterType);
            constructorArguments.add(objectType);
        }
        constructor.setAccessible(true);
        return (T) constructor.newInstance(constructorArguments.toArray());
    }


    private static Constructor<?> getFirstConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length == 0) throw new IllegalArgumentException("no constructor");
        return constructors[0];
    }
}
