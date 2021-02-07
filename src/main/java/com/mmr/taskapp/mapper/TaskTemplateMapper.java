package com.mmr.taskapp.mapper;

import com.mmr.taskapp.model.bo.TaskTemplateBO;
import com.mmr.taskapp.model.dto.TaskTemplateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTemplateMapper {

    @Autowired
    private TaskEventMapper taskEventMapper;

    public TaskTemplateBO toBO(TaskTemplateDTO taskTemplateDTO) {
        if (taskTemplateDTO != null) {
            TaskTemplateBO taskTemplateBO = new TaskTemplateBO();

            taskTemplateBO.setId(taskTemplateDTO.getId());
            taskTemplateBO.setTitle(taskTemplateDTO.getTitle());
            taskTemplateBO.setType(taskTemplateDTO.getType());
            taskTemplateBO.setRepeatInterval(taskTemplateDTO.getRepeatInterval());
            taskTemplateBO.setScheduleDate(taskTemplateDTO.getScheduleDate());
            taskTemplateBO.setDaysToNotify(taskTemplateDTO.getDaysToNotify());
            taskTemplateBO.setTaskEvents(taskEventMapper.toBOs(taskTemplateDTO.getTaskEvents()));

            return taskTemplateBO;
        }
        return null;
    }

    public TaskTemplateDTO toDTO(TaskTemplateBO taskTemplateBO) {
        if (taskTemplateBO != null) {
            TaskTemplateDTO taskTemplateDTO = new TaskTemplateDTO();

            taskTemplateDTO.setId(taskTemplateBO.getId());
            taskTemplateDTO.setTitle(taskTemplateBO.getTitle());
            taskTemplateDTO.setType(taskTemplateBO.getType());
            taskTemplateDTO.setRepeatInterval(taskTemplateBO.getRepeatInterval());
            taskTemplateDTO.setScheduleDate(taskTemplateBO.getScheduleDate());
            taskTemplateDTO.setDaysToNotify(taskTemplateBO.getDaysToNotify());
            taskTemplateDTO.setTaskEvents(taskEventMapper.toDTOs(taskTemplateBO.getTaskEvents()));

            return taskTemplateDTO;
        }
        return null;
    }
}
