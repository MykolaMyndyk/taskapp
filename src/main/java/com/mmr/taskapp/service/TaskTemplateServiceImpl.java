package com.mmr.taskapp.service;

import com.mmr.taskapp.model.bo.TaskTemplateBO;
import com.mmr.taskapp.repository.TaskTemplateRepository;
import com.mmr.taskapp.telegram.TelegramNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTemplateServiceImpl implements TaskTemplateService {

    private static final String NO_TASK_TEMPLATE_WITH_SUCH_ID_FOUND = "No TaskTemplate with such id found";

    @Autowired
    private TaskTemplateRepository taskTemplateRepository;

    @Autowired
    private TelegramNotifier telegramNotifier;

    @Override
    public List<TaskTemplateBO> findAll() {
        return taskTemplateRepository.findAll();
    }

    @Override
    public TaskTemplateBO save(TaskTemplateBO taskTemplate) {
        return taskTemplateRepository.save(taskTemplate);
    }

    @Override
    public TaskTemplateBO findById(long id) {
        return taskTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(NO_TASK_TEMPLATE_WITH_SUCH_ID_FOUND));
    }

    @Override
    public void deleteById(long id) {
        taskTemplateRepository.deleteById(id);
    }
}
