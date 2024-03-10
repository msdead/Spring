package ru.manerov.DZ12.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import ru.manerov.DZ12.model.Task;

@MessagingGateway(defaultRequestChannel = "taskInputChannel")
public interface FileGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, Task task);
}
