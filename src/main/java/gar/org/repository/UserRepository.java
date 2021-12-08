
package gar.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gar.org.entites.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur, Long>{
	
	public Utilisateur findByUsernameAndPassword(String username, String pass);

}
