package tuti.desi.services.transform;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TransformatorToList {

    public <T, R> List<R> mapList(List<T> sourceList, Function<T, R> mapper) {
        return sourceList.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

}
