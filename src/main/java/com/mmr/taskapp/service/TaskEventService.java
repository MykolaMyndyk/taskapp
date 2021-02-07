package com.mmr.taskapp.service;

import com.mmr.taskapp.model.bo.TaskEventBO;
import com.mmr.taskapp.model.bo.TaskTemplateBO;

import java.util.List;

public interface TaskEventService {

    List<TaskEventBO> findAll();
}
