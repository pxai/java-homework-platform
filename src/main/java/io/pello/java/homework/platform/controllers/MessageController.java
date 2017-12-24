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
public class MessageController {
	private MessageService messageService;
	
    public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@RequestMapping("/messages")
    public String list (Model model) {    	
        model.addAttribute("messageCommand", new MessageCommand());
    	model.addAttribute("messages", messageService.getMessages());
        return "messages";
    }
	
    @PostMapping("/messages")
    public String saveMessage(Model model, @ModelAttribute MessageCommand messageCommand) {
    	MessageCommand savedMessageCommand = messageService.saveMessage(messageCommand);
    	model.addAttribute("message", savedMessageCommand);
        return "messageSaved";
    }
	
}
