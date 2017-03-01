package com.exercisegenerator.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ViewController {



    @GetMapping({"/", "/index"})
    public ModelAndView index(){

        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

    @GetMapping("/quiz")
    public ModelAndView quiz() {
        ModelAndView mv = new ModelAndView("quiz");

        return mv;

    }
    @GetMapping("/generator")
    public ModelAndView generator() {
        ModelAndView mv = new ModelAndView("generator");

        return mv;

    }

    @PostMapping("/save")
    public View saveOrUpdate() {
        View view = new RedirectView("/index");

        return view;

    }

}
