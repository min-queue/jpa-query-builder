package jpa.fakehibernate;

import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FakePersistenceContext implements PersistenceContext{
    private Map<Class, Map<Long, Object>> map = new HashMap<>();

    public Object add(Object object, Long id) {
        map.get(clazz);
        Object o = longObjectMap.get(id);
        if(Objects.isNull(o)){
            longObjectMap.put(id, object);
        }
        return o;
    }
    public Object get(Object object, Long id) {
        Map<Long, Object> longObjectMap = map.get(object.getClass());
    }
}
