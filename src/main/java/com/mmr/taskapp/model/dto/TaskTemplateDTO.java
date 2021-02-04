package com.mmr.taskapp.model.dto;

import com.mmr.taskapp.model.TaskRepeatInterval;
import com.mmr.taskapp.model.TaskType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
public class TaskTemplateDTO {

    private long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private TaskType type;

    @Enumerated(EnumType.STRING)
    private TaskRepeatInterval repeatInterval;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduleDate;

    private int daysToNotify;
}
