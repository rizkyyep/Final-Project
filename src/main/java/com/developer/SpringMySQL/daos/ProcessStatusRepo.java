/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.daos;

import com.developer.SpringMySQL.models.ProcessStatus;
import com.developer.SpringMySQL.models.TestScore;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rizky
 */
public interface ProcessStatusRepo extends CrudRepository<ProcessStatus, Integer> {
    
    //cek data yang sudah lolos berkas dan lanjur ke psikotes
    @Query (value= "select * from process_status where status=?", nativeQuery = true)
    List<ProcessStatus> findByStatus(Integer status);
    
    //cek data candidate sesuai dengan id process status dan id candidate untuk
    //didaftarkan/dibuatkan tes psikotes online
    @Query(value = "select * from process_status where id=? AND candidate = ?", nativeQuery = true)
    public ProcessStatus addPsychotest(Integer id, Integer candidate);
    
//    @Query ("SELECT * FROM ProcessStatus JOIN TestScore ON ProcessStatus.id=TestScore.processStatus "
//            + "WHERE ProcessStatus.status=?")
//    List<TestScore> findByStatusPsy(Integer status);
    
    
}
