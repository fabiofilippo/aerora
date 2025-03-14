package it.exolab.aero.utils.customUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Algorythms {

    public static <T> T dynamicEntityCopy(T entity) throws Exception {
        T copy = (T) entity.getClass().getDeclaredConstructor().newInstance();
        Method[] methods = entity.getClass().getMethods();

        List<Method> allGetters = new ArrayList<>();
        List<Method> allSetters = new ArrayList<>();

        for (Method method : methods) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is"))
                    && method.getParameterCount() == 0
                    && isConsiderablePrimitive(method.getReturnType())) {
                allGetters.add(method);
            } else if (method.getName().startsWith("set")
                    && method.getParameterCount() == 1
                    && isConsiderablePrimitive(method.getParameterTypes()[0])) {
                allSetters.add(method);
            }
        }

        List<Method> setterAndGetter = new ArrayList<>();
        for (Method getter : allGetters) {
            int indexOfSetter = indexOfSetter(getter, allSetters);
            if (-1 != indexOfSetter) {
                setterAndGetter.add(allSetters.get(indexOfSetter));
                setterAndGetter.add(getter);
            }
        }

        for (int index = 0; index < setterAndGetter.size(); index += 2) {
            setterAndGetter.get(index).invoke(copy, setterAndGetter.get(index + 1).invoke(entity));
        }

        return copy;
    }

    public static int indexOfSetter(Method getter, List<Method> setters) {
        String rawName = getter.getName().substring(getter.getName().startsWith("is") ? 2 : 3);
        if (!"id".equals(rawName.toLowerCase())) {
            Class<?> returnType = getter.getReturnType();
            for (int index = 0; index < setters.size(); index++) {
                if (setters.get(index).getName().equals("set" + rawName)
                        && setters.get(index).getParameterTypes()[0].equals(returnType)) {
                    return index;
                }
            }
        }
        return -1;
    }

    public static boolean isConsiderablePrimitive(Class<?> clazz) {
        return clazz.equals(String.class)
                || clazz.equals(Boolean.class)
                || clazz.isPrimitive()
                || clazz.isAssignableFrom(Number.class);
    }
}
