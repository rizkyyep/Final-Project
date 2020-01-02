/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.controllers;

import com.developer.SpringMySQL.daos.CandidateRepo;
import com.developer.SpringMySQL.daos.ProcessStatusRepo;
import com.developer.SpringMySQL.daos.testScoreRepo;
import com.developer.SpringMySQL.models.Candidate;
import com.developer.SpringMySQL.models.ProcessStatus;
import com.developer.SpringMySQL.models.TestScore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rizky
 */
@Controller
public class CandidateController {

    @Autowired
    CandidateRepo candidate;
    @Autowired
    ProcessStatusRepo processStatusRepo;
    @Autowired
    testScoreRepo scoreRepo;

    @RequestMapping("/mainhr")
    public ModelAndView mainHr() {
        ModelAndView mv = new ModelAndView("hr/mainhr");
        return mv;
    }

    @RequestMapping("/candidate")
    public ModelAndView cvAccepted() {
        ModelAndView mv = new ModelAndView("hr/candidate");
//        mv.addObject("listCandidate", candidate.getCandidate2("2"));
        mv.addObject("title", "CV Accepted");
        mv.addObject("list", processStatusRepo.findByStatus(2));
        return mv;
    }

//    {id}
    @RequestMapping(value = "/addschedule", method = RequestMethod.GET)
    public ModelAndView addSchedulePsychotest(@RequestParam("idcand") int idCandidate,
            @RequestParam("idprocess") int idProcessStatus) {
        ModelAndView mv = new ModelAndView("hr/addschedule");
        
        mv.addObject("title", "Add Online Psychotest Schedule");
//        mv.addObject("idCand", idCandidate);
//        mv.addObject("idProcess", idProcessStatus);
        mv.addObject("scheduleList", processStatusRepo.addPsychotest(idProcessStatus, idCandidate));
        return mv;
    }
//    @RequestMapping("/addschedule/{idCandidate}/{idProcessStatus}")
//    public ModelAndView addSchedulePsychotest(@PathVariable("idCandidate") int idCandidate,
//            @PathVariable("idProcessStatus") int idProcessStatus) {
//        ModelAndView mv = new ModelAndView("hr/addschedule");
//        mv.addObject("title", "Add Online Psychotest Schedule");
////        mv.addObject("idCand", idCandidate);
////        mv.addObject("idProcess", idProcessStatus);
//        mv.addObject("scheduleList", processStatusRepo.addPsychotest(idProcessStatus, idCandidate));
//        return mv;
//    }

    @RequestMapping(value = "/addPsychotestSchedule/save", method = RequestMethod.POST)
    public ModelAndView addSchedule(@RequestParam("idcand") String idCand, @RequestParam("idprocess") String idProcess,
            @RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate
//            @RequestParam("time_start") String timeStart, @RequestParam("time_end") String timeEnd
    ) throws ParseException {
        
        ModelAndView mv = new ModelAndView("redirect:/candidate");
        
        String start = startDate + " 00:00:00";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date pd = sd.parse(start);
        java.sql.Date getStart = new java.sql.Date(pd.getTime());
        
        String end = endDate + " 23:59:59";
        SimpleDateFormat ed = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date pe = sd.parse(end);
        java.sql.Date getEnd = new java.sql.Date(pe.getTime());

        TestScore testScore;
        testScore = new TestScore();
        testScore.setCandidate(new Candidate(Integer.parseInt(idCand)));
        testScore.setProcessStatus(new ProcessStatus(Integer.parseInt(idProcess)));
        testScore.setStartDate(getStart);
        testScore.setEndDate(getEnd);
        testScore.setStatus(0);
        scoreRepo.save(testScore);
        
        ProcessStatus processStatus = (ProcessStatus) processStatusRepo.findOne(Integer.parseInt(idProcess));
        processStatus.setStatus(3);
        processStatusRepo.save(processStatus);
//        processStatusRepo.changeProcessStatus(3, Integer.parseInt(idProcess));

        return mv;
    }
    
    @RequestMapping("/listPsychotest")
    public ModelAndView listPsychotest() {
        ModelAndView mv = new ModelAndView("hr/listPsychotest");
//        mv.addObject("listCandidate", candidate.getCandidate2("2"));
        
        
        mv.addObject("title", "Psychotest Process");
        mv.addObject("list", processStatusRepo.findByStatus(3));
        
        return mv;
    }

}
