package ru.manerov.DZ12.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import ru.manerov.DZ12.model.Task;

import java.io.File;
import java.time.format.DateTimeFormatter;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel taskInputChannel() {
        DirectChannel channel = new DirectChannel();
        channel.setDatatypes(Task.class);
        return channel;
    }

    @Bean
    public MessageChannel fileWriterChannel() {
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "taskInputChannel", outputChannel = "fileWriterChannel")
    public GenericTransformer<Task, String> taskTransformer() {
        return task -> String.format(
                "Задача: '%s'\n\nСтатус: '%s'\n\nСоздана: '%s'",
                task.getDescription(),
                task.getStatus(),
                task.getCreationDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
        );
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        "files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}
