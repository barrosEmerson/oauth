package br.com.barrostech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.barrostech.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
