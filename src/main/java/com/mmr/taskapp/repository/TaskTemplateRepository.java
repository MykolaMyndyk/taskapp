package com.mmr.taskapp.repository;

import com.mmr.taskapp.model.bo.TaskTemplateBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Copyright (c) 2021 CompuGROUP Software GmbH
 * This software is the confidential and proprietary information of
 * CompuGROUP Software GmbH. You shall not disclose such confidential
 * information and shall use it only in accordance with the terms of
 * the license agreement you entered into with CompuGROUP Software GmbH.
 */

@Repository
public interface TaskTemplateRepository extends JpaRepository<TaskTemplateBO, Long> {

}
