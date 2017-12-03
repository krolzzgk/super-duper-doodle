package com.apiwhiletrue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class TestController {
    
    @GetMapping("/teste-api")
    public ModelAndView index() {
        return new ModelAndView("teste-api.html");
    }
}
