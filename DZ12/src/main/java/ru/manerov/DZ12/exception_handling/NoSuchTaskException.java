package ru.manerov.DZ12.exception_handling;


public class NoSuchTaskException extends RuntimeException{
    public NoSuchTaskException(Long id) {
        super("Задача с id '" + id + "' не найдена");
    }
}
