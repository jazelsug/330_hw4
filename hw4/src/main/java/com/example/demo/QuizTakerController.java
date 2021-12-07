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

	@RequestMapping(value = "/postq2", method = RequestMethod.GET)
    public String postq2(@RequestParam(name = "roommate") String q2_result) {
		//Assigns the correct values to potential results and redirects to q3.html

		switch(q2_result){
			case "lazy":
				model.addToCyrus(0.45);
				break;
			case "noisy":
				model.addToLnx1(1.75);
				break;
			case "venter":
				model.addToShaking(1.3);
				break;
			case "perf":
				model.addToThankYou(0.4);
				break;
			case "homebody":
				model.addToWazowski(0.3);
				break;
			default:
				//do nothing
				break;
		}
        return "q3";
    }

	@RequestMapping(value = "/postq3", method = RequestMethod.GET)
    public String postq3(@RequestParam(name = "movie") String q3_result) {
		//Assigns the correct values to potential results and redirects to q4.html

		switch(q3_result){
			case "brainiac":
				model.addToCyrus(0.3);
				break;
			case "theater":
				model.addToLnx1(0.67);
				break;
			case "meanie":
				model.addToShaking(0.8);
				break;
			case "jock":
				model.addToThankYou(0.75);
				break;
			case "ditcher":
				model.addToWazowski(0.3);
				break;
			default:
				//do nothing
				break;
		}
        return "q4";
    }

	@RequestMapping(value = "/postq4", method = RequestMethod.GET)
    public String postq4(@RequestParam(name = "show") String q4_result) {
		//Assigns the correct values to potential results and redirects to q5.html

		switch(q4_result){
			case "fifthgrade":
				model.addToCyrus(1.9);
				break;
			case "voice":
				model.addToLnx1(1.4);
				break;
			case "chopped":
				model.addToShaking(0.85);
				break;
			case "housewives":
				model.addToThankYou(1.1);
				break;
			case "house":
				model.addToWazowski(1.2);
				break;
			default:
				//do nothing
				break;
		}
		return "q5";
    }

	@RequestMapping(value = "/postq5", method = RequestMethod.GET)
    public String postq5(@RequestParam(name = "vacation") String q5_result) {
		//Assigns the correct values to potential results and redirects to q6.html

		switch(q5_result){
			case "friends":
				model.addToCyrus(2.0);
				break;
			case "local":
				model.addToLnx1(1.6);
				break;
			case "travel":
				model.addToShaking(2.3);
				break;
			case "projects":
				model.addToThankYou(0.9);
				break;
			case "inside":
				model.addToWazowski(1.0);
				break;
			default:
				//do nothing
				break;
		}
        //return showResults();
		return "q6";
    }

	@RequestMapping(value = "/postq6", method = RequestMethod.GET)
    public String postq6(@RequestParam(name = "music") String q6_result) {
		//Assigns the correct values to potential results and redirects to q7.html

		switch(q6_result){
			case "funsies":
				model.addToCyrus(0.58);
				break;
			case "maker":
				model.addToLnx1(2.5);
				break;
			case "never":
				model.addToShaking(2.0);
				break;
			case "snob":
				model.addToThankYou(0.9);
				break;
			case "focused":
				model.addToWazowski(1.0);
				break;
			default:
				//do nothing
				break;
		}
        return "q7";
    }

	@RequestMapping(value = "/postq7", method = RequestMethod.GET)
    public String postq7(@RequestParam(name = "yelp") String q7_result) {
		//Assigns the correct values to potential results and ends quiz

		switch(q7_result){
			case "nice":
				model.addToCyrus(1.3);
				break;
			case "snooty":
				model.addToLnx1(0.8);
				break;
			case "evil":
				model.addToShaking(1.12);
				break;
			case "opinionated":
				model.addToThankYou(1.6);
				break;
			case "myeh":
				model.addToWazowski(0.87);
				break;
			default:
				//do nothing
				break;
		}
        return showResults();
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