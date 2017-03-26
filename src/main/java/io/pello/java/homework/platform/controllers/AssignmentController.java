package io.pello.java.homework.platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pello.java.homework.platform.commands.AssignmentCommand;
import io.pello.java.homework.platform.commands.MessageCommand;
import io.pello.java.homework.platform.services.AssignmentService;
import io.pello.java.homework.platform.services.MessageService;

@Controller
public class AssignmentController {
	private AssignmentService assignmentService;
	
    public AssignmentController(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	@RequestMapping("/assignments")
    public String list (Model model) {    	
        model.addAttribute("assignmentCommand", new AssignmentCommand());
    	model.addAttribute("assignments", assignmentService.getAssignments());
        return "assignments/assignments";
    }
	
    @PostMapping("/assignments")
    public String saveAssignment(Model model, @ModelAttribute AssignmentCommand assignmentCommand) {
    	AssignmentCommand savedAssignmentCommand = assignmentService.saveAssignment(assignmentCommand);
    	model.addAttribute("assignment", savedAssignmentCommand);
        return "assignments/assignmentSaved";
    }
	
}
