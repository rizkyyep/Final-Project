/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.controllers;


import com.developer.SpringMySQL.daos.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rizky
 */
@Controller
public class CandidateController {
    
    @Autowired
    CandidateRepo candidate;
    
    @RequestMapping("/candidate")
    public ModelAndView doCandidate(){
        ModelAndView mv = new ModelAndView("hr/candidate");
        mv.addObject("listCandidate", candidate.findAll());
        return mv;
    }
    
    
}
