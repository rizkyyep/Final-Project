/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.controllers;

import com.developer.SpringMySQL.daos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rizky
 */
@Controller
public class PsychotestController {

    @Autowired
    QuestionRepo questionRepo;

    @RequestMapping("/psychotest")
    public ModelAndView doIntroduce() {
        ModelAndView md = new ModelAndView("psychotest/introduction");
        return md;
    }
    
    @RequestMapping("/starttest")
    public ModelAndView doStartTest() {
        ModelAndView md = new ModelAndView("psychotest/starttest");
        
    return md;
    }

}
