package ru.manerov.DZ12.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.manerov.DZ12.exception_handling.NoSuchTaskException;
import ru.manerov.DZ12.model.Task;
import ru.manerov.DZ12.model.TaskStatus;
import ru.manerov.DZ12.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public Task getTaskFromId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchTaskException(id));
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findAllByStatus(status);
    }

    public Task updateTaskStatus(Long id, Task updatedTask) {
        Task task = getTaskFromId(id);
        task.setStatus(updatedTask.getStatus());

        return repository.save(task);
    }

    public void deleteTask(Long id) {
        getTaskFromId(id);
        repository.deleteById(id);
    }
}
