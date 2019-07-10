package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskRepository;
import com.example.demo.form.PracticeForm;

@Controller
public class PracticeController {

	@Autowired
	TaskRepository TR;

	@ModelAttribute("practiceForm")
	public PracticeForm setupform() {
		PracticeForm form = new PracticeForm();
		return form;

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView top(@ModelAttribute PracticeForm practiceForm, ModelAndView mav) {

		List<Task> tasklist = TR.findAll();
		mav.addObject("tasklist", tasklist);
		mav.setViewName("task");
		return mav;

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createTaskGet(ModelAndView mav) {
		mav.setViewName("redirect:/");
		return mav;

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createTaskPost(
			@Validated @ModelAttribute PracticeForm practiceForm,
			BindingResult br,
			ModelAndView mav,
			RedirectAttributes ra) {

		if (br.hasErrors()) {
			return top(practiceForm, mav);
		}

		Task task = new Task();
		task.setTitle(practiceForm.getTitle());
		task.setCreate_date(new Date());
		task.setUpdate_date(new Date());
		task.setIs_Done(0);

		TR.save(task);

		mav.setViewName("redirect:/");
		return mav;

	}

	@RequestMapping(value = "/complet")
	public ModelAndView updateTask(@ModelAttribute PracticeForm form, ModelAndView mav) {

		Task task = TR.findById(form.getId()).get();

		task.setUpdate_date(new Date());
		task.setIs_Done(1);

		TR.save(task);

		mav.setViewName("redirect:/");
		return mav;

	}

	@RequestMapping(value = "/delete")
	public ModelAndView deleteTask(@ModelAttribute PracticeForm form, ModelAndView mav) {

		TR.deleteById(form.getId());

		mav.setViewName("redirect:/");
		return mav;

	}
}
