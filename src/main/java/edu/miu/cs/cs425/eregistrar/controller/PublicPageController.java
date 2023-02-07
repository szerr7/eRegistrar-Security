package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicPageController {



    @GetMapping("/")
    public String displayHomePage(){

        return "public/index" ;
    }



    @GetMapping("/about")
    public String displayAboutUs(){

        return "public/about";
    }
}
