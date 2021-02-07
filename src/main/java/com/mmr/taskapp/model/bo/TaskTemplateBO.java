package com.mmr.taskapp.model.bo;

/*
 * Copyright (c) 2021 CompuGROUP Software GmbH
 * This software is the confidential and proprietary information of
 * CompuGROUP Software GmbH. You shall not disclose such confidential
 * information and shall use it only in accordance with the terms of
 * the license agreement you entered into with CompuGROUP Software GmbH.
 */

import com.mmr.taskapp.model.TaskRepeatInterval;
import com.mmr.taskapp.model.TaskType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "TASK_TEMPLATE")
public class TaskTemplateBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TaskType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "repeatInterval")
    private TaskRepeatInterval repeatInterval;

    @Column(name = "schedule_date")
    private LocalDateTime scheduleDate;

    @Column(name = "days_to_notify")
    private int daysToNotify;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "taskTemplate_id")
    private List<TaskEventBO> taskEvents;


}
