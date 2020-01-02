/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.daos;

import com.developer.SpringMySQL.models.Candidate;
import com.developer.SpringMySQL.models.ProcessStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Rizky
 **/
public interface CandidateRepo extends CrudRepository<Candidate, Integer> {

    @Query(value = "select * from process_status where status = :status", nativeQuery = true)
    public ProcessStatus getCandidate2(@Param("status") String status);

}
