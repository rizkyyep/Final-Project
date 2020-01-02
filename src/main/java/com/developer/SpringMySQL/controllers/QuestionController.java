/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.controllers;

import com.developer.SpringMySQL.daos.QuestionRepo;
import com.developer.SpringMySQL.models.Questions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class QuestionController {

    @Autowired
    QuestionRepo questionRepo;

    @RequestMapping("/question")
    public ModelAndView doListQUestion() {
        ModelAndView md = new ModelAndView("question/question");
        md.addObject("listQuestion", questionRepo.findAll());
        return md;
    }

    @RequestMapping(value = "/question/save", method = RequestMethod.POST)
    public ModelAndView doSaveQuestion(@RequestParam("id") String id,
            @RequestParam("question") String question, @RequestParam("a") String a,
            @RequestParam("b") String b, @RequestParam("c") String c,
            @RequestParam("d") String d, @RequestParam("e") String e,
            @RequestParam("f") String f, @RequestParam("created") String created,
            @RequestParam("answer") String answer) throws ParseException {

        String startDate = created;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

        ModelAndView mv = new ModelAndView("redirect:/question");
        Questions questions;
        if (!id.isEmpty()) {
            questions = (Questions) questionRepo.findOne(Integer.parseInt(id));
        } else {
            questions = new Questions();
        }
        questions.setQuestion(question);
        questions.setA(a);
        questions.setB(b);
        questions.setC(c);
        questions.setD(d);
        questions.setE(e);
        questions.setF(f);
        questions.setCreated(sqlStartDate);
        questions.setAnswer(answer);
        questionRepo.save(questions);
        return mv;
    }

    @RequestMapping(value = "/updateQuestion/{id}", method = RequestMethod.GET)
    public ModelAndView doFormEditQuestion(@PathVariable("id") int id) {
        ModelAndView md = new ModelAndView("question/editQuestion");
        md.addObject("listUpdate", questionRepo.findOne(id));
        return md;
    }

    @RequestMapping(value = "/deleteQuestion/{id}", method = RequestMethod.GET)
    public ModelAndView doDeleteQuestion(@PathVariable("id") int id) {
        ModelAndView md = new ModelAndView("redirect:/question");
        questionRepo.delete(id);
        return md;
    }
}
