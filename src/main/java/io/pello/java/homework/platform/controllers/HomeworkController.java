package io.pello.java.homework.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pello.java.homework.platform.commands.HomeworkCommand;
import io.pello.java.homework.platform.commands.MessageCommand;
import io.pello.java.homework.platform.services.HomeworkService;
import io.pello.java.homework.platform.services.MessageService;

@Controller
public class HomeworkController {
	private HomeworkService homeworkService;
	
    public HomeworkController(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}

	@RequestMapping("/homeworks")
    public String list (Model model) {    	
        model.addAttribute("homeworkCommand", new HomeworkCommand());
    	model.addAttribute("homeworks", homeworkService.getHomeworks());
        return "homeworks/homeworks";
    }
	
    @PostMapping("/homeworks")
    public String saveHomework(Model model, @ModelAttribute HomeworkCommand homeworkCommand) {
    	HomeworkCommand savedHomeworkCommand = homeworkService.saveHomework(homeworkCommand);
    	model.addAttribute("homework", savedHomeworkCommand);
        return "homeworks/homeworkSaved";
    }
	
}
