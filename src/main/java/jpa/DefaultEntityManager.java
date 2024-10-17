package jpa;

import dummy.Person;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jdbc.JdbcTemplate;
import jpa.fakehibernate.FakePersistenceContext;

public class DefaultEntityManager implements EntityManager{
    private FakePersistenceContext persistenceContext;
    private final JdbcTemplate jdbcTemplate;
    public DefaultEntityManager(
            PersistenceContext persistenceContext,
            JdbcTemplate jdbcTemplate
    ) {
        this.persistenceContext = persistenceContext;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Object find(Long id, Object object) {
        if(Objects.isNull(persistenceContext.get(object,id))){
            jdbcTemplate.queryForObject("",null);
        }

        Person person = new Person();
        persistenceContext.add(person,id);
        return null;
    }
}
