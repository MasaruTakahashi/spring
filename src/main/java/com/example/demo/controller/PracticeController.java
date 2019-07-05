package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PracticeController {

	@RequestMapping(value = "/")
	public ModelAndView top(ModelAndView mav) {
		mav.setViewName("task");
		return mav;

	}
}
