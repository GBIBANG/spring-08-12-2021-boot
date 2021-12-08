package gar.org.controller;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gar.org.entites.Administrateur;
import gar.org.entites.Utilisateur;
import gar.org.repository.AdministrateurRepository;
import gar.org.repository.UserRepository;

@RestController
@RequestMapping("/setrag")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private AdministrateurRepository ar;
	
	@Autowired
	private EntityManager em;
	
	
	
	@PostMapping("/admin")
    public Administrateur AdminAuth(@RequestBody Administrateur admin) {
		
		String rb_admin_code = admin.getAcode();
		String rb_admin_username = admin.getAsername();
		String rb_admin_pass = admin.getPassword();
		
		Administrateur myadmin = ar.findByAsernameAndPasswordAndAcode(rb_admin_username, rb_admin_pass, rb_admin_code);
		
		if(myadmin ==null) {
			
			throw new RuntimeException("Identification Incorrecte");
		}
		
		else {
			
			return myadmin;
		}
	
	}

}
