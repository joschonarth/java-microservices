package com.joschonarth.service_tasks;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Long> {

  @Query("SELECT t FROM Tasks t WHERE t.dueDate <= :deadline AND t.notified = false")
  List<TasksEntity> findTasksDueWithinDeadline(LocalDateTime deadline);
}