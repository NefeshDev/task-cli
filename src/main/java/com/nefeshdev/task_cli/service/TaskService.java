package com.nefeshdev.task_cli.service;

import com.nefeshdev.task_cli.model.Status;
import com.nefeshdev.task_cli.model.Task;
import com.nefeshdev.task_cli.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void addTask(String description) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(Status.TODO);
        repository.save(task);
    }

    public List<Task> listAllTasks(){
        return repository.findAll();
    }

    public List<Task> listByStatus(Status status) {
        return repository.findByStatus(status);
    }

    public void updateStatus(Long id, Status status){
        Task task = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada com ID:" + id));
        task.setStatus(status);
        repository.save(task);
    }

    public void updateDescription(Long id, String description) {
        Task task = repository.findById(id).orElseThrow();
        task.setDescription(description);
        repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
