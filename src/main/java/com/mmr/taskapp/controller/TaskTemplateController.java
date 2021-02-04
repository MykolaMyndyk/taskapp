package com.mmr.taskapp.controller;

import com.mmr.taskapp.mapper.TaskTemplateMapper;
import com.mmr.taskapp.model.bo.TaskTemplateBO;
import com.mmr.taskapp.model.dto.TaskTemplateDTO;
import com.mmr.taskapp.service.TaskTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TaskTemplateController {

    @Autowired
    private TaskTemplateService taskTemplateService;

    @Autowired
    private TaskTemplateMapper taskTemplateMapper;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<TaskTemplateBO> taskTemplateBOs = taskTemplateService.findAll();

        List<TaskTemplateDTO> taskTemplateDTOs = taskTemplateBOs.stream()
                .map(t -> taskTemplateMapper.toDTO(t))
                .collect(Collectors.toList());

        model.addAttribute("taskTemplates", taskTemplateDTOs);

        return "index";
    }

    @GetMapping("/showAddTaskTemplateForm")
    public String showAddTaskTemplateForm(Model model) {
        TaskTemplateDTO taskTemplateDTO = new TaskTemplateDTO();

        model.addAttribute("taskTemplate", taskTemplateDTO);

        return "add_task_template_form";
    }

    @PostMapping("/saveTaskTemplate")
    public String saveTaskTemplate(@ModelAttribute("taskTemplate") TaskTemplateDTO taskTemplateDTO) {

        TaskTemplateBO taskTemplateBO = taskTemplateMapper.toBO(taskTemplateDTO);

        taskTemplateService.save(taskTemplateBO);

        return "redirect:/";
    }

    @GetMapping("/showUpdateTaskTemplateForm/{id}")
    public String showUpdateTaskTemplateForm(@PathVariable(value = "id") long id, Model model) {
        TaskTemplateBO taskTemplateBO = taskTemplateService.findById(id);
        TaskTemplateDTO taskTemplateDTO = taskTemplateMapper.toDTO(taskTemplateBO);

        model.addAttribute("taskTemplate", taskTemplateDTO);

        return "update_task_template_form";
    }

    @GetMapping("/deleteTaskTemplateById/{id}")
    public String deleteTaskTemplateById(@PathVariable(value = "id") long id) {

        this.taskTemplateService.deleteById(id);

        return "redirect:/";
    }
}
