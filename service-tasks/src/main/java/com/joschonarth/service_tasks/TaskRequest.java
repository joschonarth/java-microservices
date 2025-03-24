package com.joschonarth.service_tasks;

import java.time.LocalDateTime;

public record TaskRequest(String title, String email, LocalDateTime dueDate, Boolean notified) {}