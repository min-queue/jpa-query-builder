package persistence.sql.ddl;

import domain.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DDLQueryBuilderTest {
    @Test
    public void testCreateTableQueryForPerson() {
        // Given: DDLQueryBuilder 인스턴스 생성
        DDLQueryBuilder ddlQueryBuilder = new DDLQueryBuilder();

        // When: Person 클래스에 대한 CREATE TABLE 쿼리 생성
        String createTableQuery = DDLQueryBuilder.createTable(ddlQueryBuilder, Person.class);

        // Expected: 예상되는 쿼리
        String expectedQuery = "CREATE TABLE Person (" +
                "id BIGINT PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "age INTEGER" +
                ");";

        // Then: 생성된 쿼리와 예상 쿼리 비교
        assertEquals(expectedQuery, createTableQuery);
    }
}