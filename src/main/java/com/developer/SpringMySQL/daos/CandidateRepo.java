/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.daos;

import com.developer.SpringMySQL.models.Candidate;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rizky
 */
public interface CandidateRepo extends CrudRepository<Candidate,Integer>{
    
}
