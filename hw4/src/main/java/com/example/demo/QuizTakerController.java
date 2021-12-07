package com.example.demo;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizTakerController{
	private QuizTaker model;
	private DataHandler db;

	public QuizTakerController(){
		//Initializes model (QuizTaker and DataHandler).
		model = new QuizTaker();
		db = new DataHandler();
	}

	@GetMapping("/homepage")
    public String home() {
		//Redirects to index.html
        return "index";
    }

	@RequestMapping(value = "/startquiz", method = RequestMethod.GET)
    public String startQuiz(@RequestParam(name = "taker", defaultValue="anonymous") String n) {
		//Sets the name of the quiz taker to parameter n and redirects to q1.html
		model.refresh();	//Flush values
        model.setName(n);
        return "q1";
    }

	@RequestMapping(value = "/postq1", method = RequestMethod.GET)
    public String postq1(@RequestParam(name = "done") String q1_result) {
		//Assigns the correct values to potential results and redirects to q2.html

		switch(q1_result){
			case "dead":
				model.addToCyrus(1.7);
				break;
			case "enjoying":
				model.addToLnx1(2.0);
				break;
			case "idk":
				model.addToShaking(0.8);
				break;
			case "angy":
				model.addToThankYou(1.7);
				break;
			case "teary":
				model.addToWazowski(0.5);
				break;
			default:
				//do nothing
				break;
		}
        return "q2";
    }
	/*
	@GetMapping("/results")
	public String showResults(){
		model.calculateResult();
		return "results_page";
	}
	*/
	@GetMapping("/results")
	public String showResults(){
		String taker = model.getName();
		String res = model.calculateResult();
		System.out.println(taker + ": " + res);
		db.addEntry(taker, res);
		switch(res){
			case "cyrus.jpg":
				return "cyrus";
			case "lnx1.jpg":
				return "lnx1";
			case "shaking.gif":
				return "shaking";
			case "thankyou.gif":
				return "thankyou";
			case "wazowski.png":
				return "wazowski";
			default:
				return "results_page";
		}
	}
}