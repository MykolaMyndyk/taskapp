package com.mmr.taskapp.service;

import com.mmr.taskapp.model.TaskRepeatInterval;
import com.mmr.taskapp.model.bo.TaskEventBO;
import com.mmr.taskapp.model.bo.TaskTemplateBO;
import com.mmr.taskapp.repository.TaskEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskEventGeneratorImpl implements TaskEventGenerator {

    private static final int YEARS_TO_GENERATE = 10;
    private static final int MONTH_TO_GENERATE = 12;
    private static final int DAYS_IN_YEAR = 365;
    private static final int DAYS_TO_GENERATE = YEARS_TO_GENERATE * DAYS_IN_YEAR;//TODO: find better solution

    @Autowired
    private TaskEventRepository taskEventRepository;

    @Override
    public List<TaskEventBO> generateTaskEvents(TaskTemplateBO taskTemplateBO) {
        List<TaskEventBO> taskEventBOS = new ArrayList<>();

        if (taskTemplateBO.getRepeatInterval().equals(TaskRepeatInterval.YEAR)) {
            taskEventBOS.addAll(generateTaskEventBOSForYear(taskTemplateBO));
        } else if (taskTemplateBO.getRepeatInterval().equals(TaskRepeatInterval.MONTH)) {
            taskEventBOS.addAll(generateTaskEventBOSForMonth(taskTemplateBO));
        } else if (taskTemplateBO.getRepeatInterval().equals(TaskRepeatInterval.DAY)) {
            taskEventBOS.addAll(generateTaskEventBOSForDay(taskTemplateBO));
        } else if (taskTemplateBO.getRepeatInterval().equals(TaskRepeatInterval.ONE_TIME)) {
            taskEventBOS.add(generateTaskEventBOSForOneTime(taskTemplateBO));
        }

        return taskEventBOS;
    }

    private TaskEventBO generateTaskEventBOSForOneTime(TaskTemplateBO taskTemplateBO) {
        TaskEventBO taskEventBO = new TaskEventBO(taskTemplateBO.getTitle(), taskTemplateBO.getScheduleDate(), taskTemplateBO.getId());

        return taskEventRepository.save(taskEventBO);
    }

    private List<TaskEventBO> generateTaskEventBOSForDay(TaskTemplateBO taskTemplateBO) {
        List<TaskEventBO> taskEventBOS = new ArrayList<>();

        for (int d = 0; d < DAYS_TO_GENERATE; d++) {
            LocalDateTime nextDayDateTime = taskTemplateBO.getScheduleDate().plusDays(d);

            TaskEventBO taskEventBO = new TaskEventBO(taskTemplateBO.getTitle(), nextDayDateTime, taskTemplateBO.getId());

            taskEventBOS.add(taskEventRepository.save(taskEventBO));
        }

        return taskEventBOS;
    }

    private List<TaskEventBO> generateTaskEventBOSForMonth(TaskTemplateBO taskTemplateBO) {
        List<TaskEventBO> taskEventBOS = new ArrayList<>();

        for (int y = 0; y < YEARS_TO_GENERATE; y++) {
            LocalDateTime nextYearDateTime = taskTemplateBO.getScheduleDate().plusYears(y);

            for (int m = 0; m < MONTH_TO_GENERATE; m++) {
                LocalDateTime nextMonthDateTime = nextYearDateTime.plusMonths(m);

                TaskEventBO taskEventBO = new TaskEventBO(taskTemplateBO.getTitle(), nextMonthDateTime, taskTemplateBO.getId());

                taskEventBOS.add(taskEventRepository.save(taskEventBO));
            }
        }
        return taskEventBOS;
    }

    private List<TaskEventBO> generateTaskEventBOSForYear(TaskTemplateBO taskTemplateBO) {
        List<TaskEventBO> taskEventBOS = new ArrayList<>();

        for (int i = 0; i < YEARS_TO_GENERATE; i++) {
            LocalDateTime nextDateTime = taskTemplateBO.getScheduleDate().plusYears(i);

            TaskEventBO taskEventBO = new TaskEventBO(taskTemplateBO.getTitle(), nextDateTime, taskTemplateBO.getId());

            taskEventBOS.add(taskEventRepository.save(taskEventBO));
        }
        return taskEventBOS;
    }
}
