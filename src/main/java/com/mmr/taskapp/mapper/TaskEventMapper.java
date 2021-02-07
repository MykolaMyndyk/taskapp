package com.mmr.taskapp.mapper;

import com.mmr.taskapp.model.bo.TaskEventBO;
import com.mmr.taskapp.model.dto.TaskEventDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskEventMapper {

    public TaskEventBO toBO(TaskEventDTO taskEventDTO) {

        if (taskEventDTO != null) {
            TaskEventBO taskEventBO = new TaskEventBO();

            taskEventBO.setId(taskEventDTO.getId());
            taskEventBO.setTitle(taskEventDTO.getTitle());
            taskEventBO.setEventDateTime(taskEventDTO.getLocalDateTime());
            taskEventBO.setTaskTemplateId(taskEventDTO.getTaskTemplateId());

            return taskEventBO;
        }

        return null;
    }

    public List<TaskEventBO> toBOs(List<TaskEventDTO> taskEventDTOS) {

        if (taskEventDTOS != null) {
            return taskEventDTOS.stream()
                    .map(this::toBO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public TaskEventDTO toDTO(TaskEventBO taskEventBO) {
        if (taskEventBO != null) {
            TaskEventDTO taskEventDTO = new TaskEventDTO();

            taskEventDTO.setId(taskEventBO.getId());
            taskEventDTO.setTitle(taskEventBO.getTitle());
            taskEventDTO.setLocalDateTime(taskEventBO.getEventDateTime());
            taskEventDTO.setTaskTemplateId(taskEventBO.getTaskTemplateId());

            return taskEventDTO;
        }
        return null;
    }

    public List<TaskEventDTO> toDTOs(List<TaskEventBO> taskEventBOS) {

        if (taskEventBOS != null) {
            return taskEventBOS.stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
