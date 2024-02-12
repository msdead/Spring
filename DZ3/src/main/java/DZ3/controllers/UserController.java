package DZ3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import DZ3.domain.User;
import DZ3.services.RegistrationService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private RegistrationService service;

    /**
     * Базовый метод вывода всехпользователей
     * @return Список всех пользователей
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().findAll();
    }

    /**
     * Ответ на запрос добавления пользователя при помощи переданного Json-файла
     * @param user Пользователь, переданный в виде Json-файла
     * @return Ответ успешного добавления пользователя
     */
    @PostMapping("/body")//localhost:8080/users/body
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getRepository().save(user);
        service.getNotificationService().notifyUser(user);
        return service.getNotificationService().sendNotification(user);
    }

    /**
     *
     * @param name Имя, переданное в запросе как параметр
     * @param age Возраст, переданный в запросе как параметр
     * @param email E-mail, переданный в запросе как параметр
     * @return Ответ успешного добавления пользователя
     */
    @PostMapping("/param")//localhost:8080/users/param?name=Artur&age=23&email=exam1@yandex.ru
    @ResponseBody
    public String userAddFromParam(
            @RequestParam("name") String name
            , @RequestParam("age") int age
            , @RequestParam("email") String email) {
        return service.processRegistration(name, age, email);
    }
}
