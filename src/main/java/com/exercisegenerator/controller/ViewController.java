package com.exercisegenerator.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ViewController {



    @GetMapping({"/"})
    public ModelAndView main(){

        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");

        return mv;

    }

    @PostMapping("/save")
    public View saveOrUpdate() {
        View view = new RedirectView("/index");

        return view;

    }

}
