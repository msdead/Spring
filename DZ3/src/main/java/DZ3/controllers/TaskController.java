package DZ3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import DZ3.domain.User;
import DZ3.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private DataProcessingService service;

    /**
     * Базовый метод вывода всех запросов
     * @return список запросов
     */
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    /**
     * Ответ на запрос сортировки по возрасту
     * @return Список пользователей, возраст которых больше указанного в запросе
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge();
    }

    /**
     * Ответ на запрос фильтрации по возрасту
     * @param age Возраст, старше которого выводятся пользователи
     * @return Список пользователей старше заданного возраста
     */
    @GetMapping("/filter/{age}")//localhost:8080/tasks/filter/23
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        return service.filterUsersByAge(age);
    }

    /**
     * Ответ на запрос вычисления среднего возраста
     * @return Средний возраст пользователей
     */
    @GetMapping("/calc")//localhost:8080/tasks/calc
    public double calculateAverageAge(){
        return service.calculateAverageAge();
    }
}
