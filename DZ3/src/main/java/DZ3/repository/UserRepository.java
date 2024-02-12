package DZ3.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import DZ3.domain.User;

import java.util.List;


@Setter
@Getter
@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;

    /**
     * Метод вывода всех пользователей
     * @return Список всех пользователей
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";
        return jdbc.query(sql, newUserRowMapper());
    }

    /**
     * Метод добавления пользователя
     * @param user Новый пользователь
     */
    public void save(User user) {
        String sql = "INSERT INTO userTable (name,age, email) VALUES ( ?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

    /**
     * Метод сортировки пользователей по возрасту
     * @param age Возраст, старше которого выводятся пользователи
     * @return Список пользователей, соответствующих условию
     */
    public List<User> filterUserByAge(int age){
        String sql = "SELECT * FROM userTable WHERE age>?";
        return jdbc.query(sql, newUserRowMapper(), age);
    }

    /**
     * Метод сортировки по возрасту
     * @return Список пользователей, отсортированный по возрасту
     */
    public List<User> sortedUserByAge(){
        String sql = "SELECT * FROM userTable ORDER BY age";



        return jdbc.query(sql, newUserRowMapper());
    }

    /**
     * Метод нахождения среднего возраста пользователей
     * @return Средний возраст пользователей
     */
    public Double averageAge(){
        String sql = "SELECT AVG(age) AS Average_Age FROM userTable";
        return jdbc.queryForObject(sql, Double.class);
    }

    /**
     * Метод создания словаря пользователей
     * @return Словарь пользователей
     */
    private RowMapper<User> newUserRowMapper(){
        return (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
    }

}
