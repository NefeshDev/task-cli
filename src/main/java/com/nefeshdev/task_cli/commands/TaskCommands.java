package com.nefeshdev.task_cli.commands;

import com.nefeshdev.task_cli.model.Status;
import com.nefeshdev.task_cli.service.TaskService;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.stereotype.Component;

@Component
@Command(group = "Task Commands")
public class TaskCommands {

    private final TaskService taskService;

    public TaskCommands(TaskService taskService) {
        this.taskService = taskService;
    }

    @Command(command = "add", description = "Adiciona uma nova tarefa")
    public String addTask(String description) {
        taskService.addTask(description);
        return "Tarefa adicionada com sucesso!";
    }

    @Command(command = "update", description = "Atualiza a descrição de uma tarefa")
    public String updateTask(Long id, String description) {
        taskService.updateDescription(id, description);
        return "Tarefa " + id + " atualizada com sucesso!";
    }

    @Command(command = "delete", description = "Deleta uma tarefa")
    public String deleteTask(Long id) {
        taskService.deleteTask(id);
        return "Tarefa " + id + " removida.";
    }

    @Command(command = "mark-in-progress", description = "Marca uma tarefa como em progresso")
    public String markInProgress(Long id) {
        taskService.updateStatus(id, Status.IN_PROGRESS);
        return "Tarefa " + id + " marcada como IN_PROGRESS.";
    }

    @Command(command = "mark-done", description = "Marca uma tarefa como concluída")
    public String markDone(Long id) {
        taskService.updateStatus(id, Status.DONE);
        return "Tarefa " + id + " marcada como DONE.";
    }

    @Command(command = "list", description = "Lista tarefas (opcional: todo, in-progress, done)")
    public String listTasks(@Option(defaultValue = "ALL") String status) {
        if (status.equalsIgnoreCase("ALL")) {
            return taskService.listAllTasks().toString();
        }
        return taskService.listByStatus(Status.valueOf(status.toUpperCase())).toString();
    }
}