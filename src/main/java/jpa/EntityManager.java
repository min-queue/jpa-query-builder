package jpa;

public interface EntityManager {
    public Object find(Long id, Class<?> entityClass);

}
