package com.mmr.taskapp.service;

import com.mmr.taskapp.model.bo.TaskEventBO;
import com.mmr.taskapp.model.bo.TaskTemplateBO;
import com.mmr.taskapp.repository.TaskEventRepository;
import com.mmr.taskapp.repository.TaskTemplateRepository;
import com.mmr.taskapp.telegram.TelegramNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskEventServiceImpl implements TaskEventService {

    @Autowired
    private TaskEventRepository taskEventRepository;

    @Override
    public List<TaskEventBO> findAll() {
        return taskEventRepository.findAll();
    }
}
