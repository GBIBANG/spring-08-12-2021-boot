
package gar.org.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gar.org.entites.Client;
import gar.org.entites.Ticket;
import gar.org.entites.Utilisateur;
import gar.org.repository.ClientRepository;
import gar.org.repository.TicketRepository;
import gar.org.repository.UserRepository;

@RestController
@RequestMapping("/setrag")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserRepository userr;
	
	@Autowired
	private EntityManager em;
	
	@PostMapping("/auth")
    public Utilisateur UserAuth(@RequestBody Utilisateur user) {
		
		String rb_username = user.getUsername();
		String rb_password = user.getPassword();
		String rb_gare = user.getUgare();
		
		Utilisateur myuser = userr.findByUsernameAndPassword(rb_username, rb_password);
		
		if(myuser ==null) {
			
			throw new RuntimeException("Identification Incorrecte");
		}
		
		else {
			
			return myuser;
		}
	
	}

}
