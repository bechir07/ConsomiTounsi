package tn.esprit.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import tn.esprit.spring.Service.SubjectService;
import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.OutputMessage;
import tn.esprit.spring.entities.Subject;

@RestController("/Subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	  @MessageMapping("/chat")
	  
	  @SendTo("/topic/messages") public OutputMessage send(Message message) throws
	  Exception { String time = new SimpleDateFormat("HH:mm").format(new Date());
	  return new OutputMessage(message.getFrom(), message.getText(), time); }
	 

	@GetMapping("/SujetAlaLigne")
	List<Subject>getSujetAlaLigne(){
		return subjectService.AffichageSujetAlaLaUne();
	}
	
	@PatchMapping("/Rating")
	void rating(@RequestBody Subject s,@RequestParam(name = "nbEtoiles")int nbEtoiles) {
		subjectService.Rating(s, nbEtoiles);
	}
	
	@DeleteMapping("/DeleteSujetRedondant")
	boolean checkAndDeletesujetRedondant(@RequestBody Subject s) {
		return subjectService.deleteSujetRedondant(s);
	}
	
}
