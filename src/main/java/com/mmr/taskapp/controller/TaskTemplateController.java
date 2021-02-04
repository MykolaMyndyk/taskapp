package com.mmr.taskapp.controller;

import com.mmr.taskapp.model.bo.TaskTemplateBO;
import com.mmr.taskapp.service.TaskTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskTemplateController {

    @Autowired
    private TaskTemplateService taskTemplateService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("taskTemplates", taskTemplateService.findAll());

        return "index";
    }

    @GetMapping("/showAddTaskTemplateForm")
    public String showAddTaskTemplateForm(Model model) {
        TaskTemplateBO taskTemplate = new TaskTemplateBO();

        model.addAttribute("taskTemplate", taskTemplate);

        return "add_task_template_form";
    }

    @PostMapping("/saveTaskTemplate")
    public String saveTaskTemplate(@ModelAttribute("taskTemplate") TaskTemplateBO taskTemplate) {

        taskTemplateService.save(taskTemplate);

        return "redirect:/";
    }

    @GetMapping("/showUpdateTaskTemplateForm/{id}")
    public String showUpdateTaskTemplateForm(@PathVariable(value = "id") long id, Model model) {

        TaskTemplateBO taskTemplate = taskTemplateService.findById(id);

        model.addAttribute("taskTemplate", taskTemplate);

        return "update_task_template_form";
    }

    @GetMapping("/deleteTaskTemplateById/{id}")
    public String deleteTaskTemplateById(@PathVariable(value = "id") long id) {

        this.taskTemplateService.deleteById(id);

        return "redirect:/";
    }
}
