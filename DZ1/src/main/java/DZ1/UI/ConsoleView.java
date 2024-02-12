package DZ1.UI;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleView {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in, StandardCharsets.UTF_8);
    }



    public String inputFirstName() {
        System.out.print("Введите Имя: ");
        return in.next();
    }

    public String inputLastName() {
        System.out.print("Введите Фамилию: ");
        return in.next();
    }

    public int inputAge() {
        System.out.print("Введите возраст: ");
        return in.nextInt();
    }

    public int menu() {
        System.out.println(
                """
                1 - Сериализация данных
                2 - Десериализация данных
                0 - закрыть приложение
                """
        );
        System.out.print("Введите номер действия: ");
        return in.nextInt();
    }
}
