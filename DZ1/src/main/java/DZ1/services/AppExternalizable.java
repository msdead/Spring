package DZ1.services;

import DZ1.models.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;


public class AppExternalizable {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Сериализация в файл 'persons.json'
    public void serializationPerson (String FILE_JSON, Person person){
        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(FILE_JSON), person);
            System.out.println("Сериализация в файл 'persons.json' выполнена успешно!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Десериализация из файла 'persons.json'
    public void deSerializationPerson (String FILE_JSON){
        Person person;
        try {
            File fileJSON = new File(FILE_JSON);
            person = objectMapper.readValue(fileJSON, Person.class);
            System.out.println("Десериализация из файла 'persons.json' выполнена успешно!");
            System.out.println(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
