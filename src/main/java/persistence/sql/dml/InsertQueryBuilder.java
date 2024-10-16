package persistence.sql.dml;

import jakarta.persistence.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertQueryBuilder extends DMLQueryBuilder{
        public String insert(Object entity) {
            Class<?> entityClass = entity.getClass();
            if (!entityClass.isAnnotationPresent(Entity.class)) {
                throw new IllegalArgumentException("This Class is not an Entity ");
            }

            String tableName = getTableName(entityClass);
            String columns = columnsClause(entityClass);
            String values = valueClause(entity);

            return "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ");";
        }
}