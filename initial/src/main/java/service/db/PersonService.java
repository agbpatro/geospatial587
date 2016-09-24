package service.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import service.db.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by patro on 9/24/16.
 */

@Service
public class PersonService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addPerson(Person person) {
        String sql = "INSERT INTO person(name, city, age) VALUES(?,?,?)";
        return jdbcTemplate.update(sql, person.getName(),
                person.getCity(), person.getAge());
    }

    public List<Person> getAllPerson() {
        return jdbcTemplate.query("SELECT * FROM person", new RowMapper<Person>() {

            public Person mapRow(ResultSet rs, int arg1) throws SQLException {
                Person p = new Person();
                p.setAge(rs.getInt("age"));
                p.setName(rs.getString("name"));
                p.setCity(rs.getString("city"));
                p.setId(rs.getInt("id"));
                return p;
            }

        });
    }
}