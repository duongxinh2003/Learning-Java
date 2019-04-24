package com.sonnh.myspringcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sonnh.myspringcrud.entity.User;

@Repository //scan component
public interface UserRepository extends CrudRepository<User, Long>{
	
//	@Query(value="select * from user.user u where u.name = :name", nativeQuery = true)
//	List<User> findUserByName(@Param("name") String name);
	
	@Query("select u from User u where u.name = ?1")
	List<User> findUserByName(String name);
}
