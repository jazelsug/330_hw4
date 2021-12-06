package com.example.demo;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizTakerController{
	private QuizTaker model;

	public QuizTakerController(){//QuizTaker m){
		//model = m;
		model = new QuizTaker();
	}

	@RequestMapping(value = "/startquiz", method = RequestMethod.GET)
    public String startQuiz(@RequestParam(name = "fname", defaultValue="anonymous") String n) {
        model.setName(n);
        return "q1";	//goes to q1.html
    }

	@RequestMapping(value = "/postq1", method = RequestMethod.GET)
    public String postq1(@RequestParam(name = "done") String q1_result) {
        if (q1_result.equals("cyrus")){
			model.addToCyrus(1.7);
		}
        return "q2";	//goes to q1.html
    }

	@GetMapping("/results")
	public String showResults(){
		model.calculateResult();
		return "results_page";
	}
}