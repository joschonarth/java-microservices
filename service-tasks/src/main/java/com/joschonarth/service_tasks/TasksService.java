package com.joschonarth.service_tasks;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TasksService {
  private final TasksRepository tasksRepository;
  private final NotificationClient notificationClient;

  public TasksService(TasksRepository tasksRepository, NotificationClient notificationClient) {
    this.tasksRepository = tasksRepository;
    this.notificationClient = notificationClient;
  }

  public void sendNotificationForDueTasks() {
    LocalDateTime deadline = LocalDateTime.now().plusDays(1);
    List<TasksEntity> tasks = tasksRepository.findTasksDueWithinDeadline(deadline);
    for (TasksEntity task : tasks) {
      NotificationRequest request = new NotificationRequest("Sua tarefa:" + task.getTitle() + "está prestes a vencer!", task.getEmail());
      notificationClient.sendNotification(request);
      task.setNotified(true);
    }
  }
}