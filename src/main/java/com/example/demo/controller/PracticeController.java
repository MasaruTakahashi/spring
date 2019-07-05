package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskRepository;


@Controller
public class PracticeController {

	@Autowired
	TaskRepository TR;

	@RequestMapping(value = "/")
	public ModelAndView top( ModelAndView mav) {

		List<Task> taskList = TR.findAll();
		mav.addObject("taskList",taskList);
		mav.setViewName("task");
		return mav;

	}
}
