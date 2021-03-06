package com.mmr.taskapp.service;

import com.mmr.taskapp.model.bo.TaskTemplateBO;

import java.util.List;

/*
 * Copyright (c) 2021 CompuGROUP Software GmbH
 * This software is the confidential and proprietary information of
 * CompuGROUP Software GmbH. You shall not disclose such confidential
 * information and shall use it only in accordance with the terms of
 * the license agreement you entered into with CompuGROUP Software GmbH.
 */
public interface TaskTemplateService {

    List<TaskTemplateBO> findAll();

    TaskTemplateBO save(TaskTemplateBO taskTemplate);

    TaskTemplateBO findById(long id);

    void deleteById(long id);

}
