package io.pello.homework.javahomeworkplatform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
