package com.Test.TestSpring.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController, MyErrorController {
    @RequestMapping("/error")
    public String handleError(Model model){
        model.addAttribute("errorTitle", "Oops! Something  went wrong");
        model.addAttribute("errorMessage", "Sorry, an error occurred on this page.");
        return "error";
    }

    @Override
    public String getErrorPath(){
        return "/error";
    }
}
