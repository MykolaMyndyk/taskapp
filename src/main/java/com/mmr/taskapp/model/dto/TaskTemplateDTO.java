package com.mmr.taskapp.model.dto;

import com.mmr.taskapp.model.TaskRepeatInterval;
import com.mmr.taskapp.model.TaskType;
import com.mmr.taskapp.model.bo.TaskEventBO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskTemplateDTO {

    private long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private TaskType type;

    @Enumerated(EnumType.STRING)
    private TaskRepeatInterval repeatInterval;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime scheduleDate;

    private int daysToNotify;

    private List<TaskEventDTO> taskEvents;
}
