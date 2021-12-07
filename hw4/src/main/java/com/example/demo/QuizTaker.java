package com.example.demo;

//Model
public class QuizTaker{
	String name;
	String result;

	double cyrus = 0.0;
	double lnx1 = 0.0;
	double shaking = 0.0;
	double thankyou = 0.0;
	double wazowski = 0.0;


	public void setName(String n){
		name = n;
	}

	public String getName(){
		return name;
	}

	public void setResult(String r){
		result = r;
	}

	public String getResult(){
		return result;
	}

	//adders: Add a given value to one of the result counts

	public void addToCyrus(double value){
		cyrus = cyrus + value;
	}

	public void addToLnx1(double value){
		lnx1 = lnx1 + value;
	}

	public void addToShaking(double value){
		shaking = shaking + value;
	}

	public void addToThankYou(double value){
		thankyou = thankyou + value;
	}

	public void addToWazowski(double value){
		wazowski = wazowski + value;
	}

	public String calculateResult(){
		//Sets and returns result based on maximum value
		double maxVal = 0.0;

		if (maxVal <= cyrus){
			maxVal = cyrus;
			result = "cyrus.jpg";
		}
		if (maxVal <= lnx1){
			maxVal = lnx1;
			result = "lnx1.jpg";
		}
		if (maxVal <= shaking){
			maxVal = shaking;
			result = "shaking.gif";
		}
		if (maxVal <= thankyou){
			maxVal = thankyou;
			result = "thankyou.gif";
		}
		if (maxVal <= wazowski){
			maxVal = wazowski;
			result = "wazowski.png";
		}

		return result;
	}

	public void refresh(){
		//Flushes result counts
		cyrus = 0.0;
		lnx1 = 0.0;
		shaking = 0.0;
		thankyou = 0.0;
		wazowski = 0.0;
	}
}