package com.mmr.taskapp.mapper;

import com.mmr.taskapp.model.bo.TaskTemplateBO;
import com.mmr.taskapp.model.dto.TaskTemplateDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskTemplateMapper {

    public TaskTemplateBO toBO(TaskTemplateDTO taskTemplateDTO) {

        TaskTemplateBO taskTemplateBO = new TaskTemplateBO();

        taskTemplateBO.setId(taskTemplateDTO.getId());
        taskTemplateBO.setTitle(taskTemplateDTO.getTitle());
        taskTemplateBO.setType(taskTemplateDTO.getType());
        taskTemplateBO.setRepeatInterval(taskTemplateDTO.getRepeatInterval());
        taskTemplateBO.setScheduleDate(taskTemplateDTO.getScheduleDate());
        taskTemplateBO.setDaysToNotify(taskTemplateDTO.getDaysToNotify());

        return taskTemplateBO;
    }

    public TaskTemplateDTO toDTO(TaskTemplateBO templateBO) {

        TaskTemplateDTO taskTemplateDTO = new TaskTemplateDTO();

        taskTemplateDTO.setId(templateBO.getId());
        taskTemplateDTO.setTitle(templateBO.getTitle());
        taskTemplateDTO.setType(templateBO.getType());
        taskTemplateDTO.setRepeatInterval(templateBO.getRepeatInterval());
        taskTemplateDTO.setScheduleDate(templateBO.getScheduleDate());
        taskTemplateDTO.setDaysToNotify(templateBO.getDaysToNotify());

        return taskTemplateDTO;
    }
}
