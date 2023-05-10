package it.beije.mockito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.mockito.model.ToDoList;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Integer>{
	
	public List<ToDoList> findByUsername(String username);

}
