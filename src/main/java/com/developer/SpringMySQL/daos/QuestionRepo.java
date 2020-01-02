/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.daos;

import com.developer.SpringMySQL.models.Questions;
import com.developer.SpringMySQL.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Rizky
 */
public interface QuestionRepo extends CrudRepository<Questions, Integer>{
    
    @Query (value= "select * from questions where id = :id", nativeQuery = true)
    public User getQuestion(@Param("id") String id);
}
