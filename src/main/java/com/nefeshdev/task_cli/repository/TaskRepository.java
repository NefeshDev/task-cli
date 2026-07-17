package com.nefeshdev.task_cli.repository;

import com.nefeshdev.task_cli.model.Status;
import com.nefeshdev.task_cli.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByStatus(Status status);
}
