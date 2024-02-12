package DZ3.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import DZ3.domain.User;

@Getter
@AllArgsConstructor
@Service
public class RegistrationService {

    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;

    /**
     * Метод регистрации пользователя
     * @param name Имя
     * @param age Возраст
     * @param email E-mail
     * @return Строка успешного добавления пользователя
     */
    public String processRegistration(String name, int age, String email){
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        return notificationService.sendNotification(newUser);
    }

}
