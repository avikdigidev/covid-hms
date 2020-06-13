package com.avikdigidev.covid.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class WebController {
  @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }
  @RequestMapping(value="/PatientDet",method = RequestMethod.GET)
  public String homepage2(){
      return "PatientDet";
  }
  
  
  
}