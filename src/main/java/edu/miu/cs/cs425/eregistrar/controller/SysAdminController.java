package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysAdminController {


    @GetMapping(value = "/secured/sysadmin")
    public String displaySisAdminPage(){
        return "secured/sysadmin";

    }


}
