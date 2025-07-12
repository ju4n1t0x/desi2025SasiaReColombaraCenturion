package tuti.desi.services.transform;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class Transformator {


    public <I, O> O transform(I input) throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> source = input.getClass();
        Class<?> target = Class.forName("com.desi2026.tuti.presentacion.models." +
                source.getSimpleName() + "Model");

        @SuppressWarnings("unchecked")
        O targetInstance = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        // Crear un mapa para búsqueda eficiente
        Map<String, Field> targetFieldMap = Arrays.stream(targetFields)
                .collect(Collectors.toMap(Field::getName, Function.identity()));

        for (Field sourceField : sourceFields) {
            Field targetField = targetFieldMap.get(sourceField.getName());

            if (targetField != null &&
                    sourceField.getType().equals(targetField.getType())) {
                sourceField.setAccessible(true);
                targetField.setAccessible(true);

                try {
                    Object value = sourceField.get(input);
                    targetField.set(targetInstance, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error accessing field: " + sourceField.getName(),
                            e);
                }
            }
        }

        return targetInstance;
    }

}