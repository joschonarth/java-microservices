package com.joschonarth.service_tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TasksNotificationSchedule {
  
  private final TasksService tasksService;

  public TasksNotificationSchedule(TasksService tasksService) {
    this.tasksService = tasksService;
  }

  @Scheduled(fixedRate = 1000 * 60 * 60 * 24)
  public void checkAndNotifyTasks() {
    this.tasksService.sendNotificationForDueTasks();
  }
}