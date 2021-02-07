package com.mmr.taskapp.model.bo;

/*
 * Copyright (c) 2021 CompuGROUP Software GmbH
 * This software is the confidential and proprietary information of
 * CompuGROUP Software GmbH. You shall not disclose such confidential
 * information and shall use it only in accordance with the terms of
 * the license agreement you entered into with CompuGROUP Software GmbH.
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TASK_EVENT")
public class TaskEventBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "event_date")
    private LocalDateTime eventDateTime;

    @Column(name = "taskTemplate_id")
    private long taskTemplateId;

    public TaskEventBO(String title, LocalDateTime eventDateTime, long taskTemplateId) {
        this.title = title;
        this.eventDateTime = eventDateTime;
        this.taskTemplateId = taskTemplateId;
    }
}
