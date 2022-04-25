package com.alves.secao25course.repositories;

import com.alves.secao25course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
